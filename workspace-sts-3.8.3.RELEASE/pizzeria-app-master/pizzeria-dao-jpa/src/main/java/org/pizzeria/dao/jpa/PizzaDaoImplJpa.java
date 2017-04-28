package org.pizzeria.dao.jpa;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

import javax.persistence.*;


import org.pizzeria.dao.api.IPizzaDao;
import org.pizzeria.dao.api.exception.DeletePizzaException;
import org.pizzeria.dao.api.exception.SavePizzaException;
import org.pizzeria.dao.api.exception.UpdatePizzaException;
import org.pizzeria.domain.Pizza;

public class PizzaDaoImplJpa implements IPizzaDao {
	EntityManagerFactory emf;
	public PizzaDaoImplJpa(){
		java.util.logging.Logger.getLogger("org.hibernate").setLevel(Level.SEVERE);
		 emf =  Persistence.createEntityManagerFactory("pizzeria-unit");
		 
	}
	
	
	@Override
	public List<Pizza> findAllPizzas() {
		List<Pizza> list = new ArrayList<>();
		EntityManager em = emf.createEntityManager();
		Query query= em.createQuery("select p from Pizza p");
		list= (List<Pizza>) query.getResultList();
		em.close();
		return list;
	}

	@Override
	public boolean saveNewPizza(Pizza pizza) throws SavePizzaException {
		
		boolean trouve = findAllPizzas().contains(pizza);
		
		EntityManager em = emf.createEntityManager();
		EntityTransaction et= em.getTransaction();
		if (!trouve){
		
		et.begin();
		em.persist(pizza);
		et.commit();
		} 
	/*	else { 
			System.out.println("else");
			et.begin();
			em.merge(pizza);
			et.commit();
			em.close();
			}*/
		
		em.close();
		return false;
	}

	@Override
	public boolean updatePizza(String codePizza, Pizza pizza) throws UpdatePizzaException {
		EntityManager em = emf.createEntityManager();
		Query query = em.createQuery(" select p from Pizza p where p.code=:code");
		query.setParameter("code", codePizza);
		Pizza p = (Pizza) query.getResultList().get(0);
		EntityTransaction et= em.getTransaction();
		et.begin();
		p.setCode(pizza.getCode());
		p.setNom(pizza.getNom());
		p.setPrix(pizza.getPrix());
		p.setCat(pizza.getCat());
		em.merge(p);
		et.commit();
		em.close();
		return false;
	}

	@Override
	public boolean deletePizza(String codePizza) throws DeletePizzaException {
		EntityManager em = emf.createEntityManager();
		Query query = em.createQuery(" delete from Pizza p where p.code=:code");
		EntityTransaction et= em.getTransaction();
		et.begin();
		query.setParameter("code", codePizza);
		query.executeUpdate();
		et.commit();
		
		
	/*	else { 
			System.out.println("else");
			et.begin();
			em.merge(pizza);
			et.commit();
			em.close();
			}*/
		
		em.close();
		return false;
	}

}
