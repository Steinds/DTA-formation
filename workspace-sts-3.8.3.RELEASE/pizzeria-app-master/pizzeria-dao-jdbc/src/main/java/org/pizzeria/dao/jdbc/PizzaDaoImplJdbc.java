package org.pizzeria.dao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import org.pizzeria.dao.api.IPizzaDao;
import org.pizzeria.dao.api.exception.DeletePizzaException;
import org.pizzeria.dao.api.exception.SavePizzaException;
import org.pizzeria.dao.api.exception.UpdatePizzaException;
import org.pizzeria.domain.CategoriePizza;
import org.pizzeria.domain.Pizza;

public class PizzaDaoImplJdbc implements IPizzaDao {
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<Pizza> findAllPizzas() {
		List<Pizza> list = new ArrayList<>();
		ResourceBundle bundle = ResourceBundle.getBundle("jdbc");
		String value1 = bundle.getString("jdbc.url");
		String value2 = bundle.getString("jdbc.login");
		String value3 = bundle.getString("jdbc.pswrd");

		try {

			Connection myConnection = DriverManager.getConnection(value1, value2, value3);
			Statement statement = myConnection.createStatement();

			ResultSet resultats = statement.executeQuery(" SELECT * FROM pizza ");
			while (resultats.next()) {
				// Integer id = resultats.getInt("ID");
				String code = resultats.getString("CODE");
				String name = resultats.getString("NOM");
				double prix = resultats.getDouble("PRIX");
				CategoriePizza cat = CategoriePizza.valueOf(resultats.getString("CATEGORIE"));
				list.add(new Pizza(code, name, prix, cat));
			}
			myConnection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
	}

	@Override
	public boolean saveNewPizza(Pizza pizza) throws SavePizzaException {
		ResourceBundle bundle = ResourceBundle.getBundle("jdbc");
		String value1 = bundle.getString("jdbc.url");
		String value2 = bundle.getString("jdbc.login");
		String value3 = bundle.getString("jdbc.pswrd");

		try {

			Connection myConnection = DriverManager.getConnection(value1, value2, value3);

			PreparedStatement selectPizzaSt = myConnection.prepareStatement(
					"INSERT IGNORE INTO `pizza`(`ID`, `CODE`, `NOM`, `PRIX`, `CATEGORIE`) VALUES (null,?,?,?,?)");
			selectPizzaSt.setString(1, pizza.getCode());
			selectPizzaSt.setString(2, pizza.getNom());
			selectPizzaSt.setDouble(3, pizza.getPrix());
			selectPizzaSt.setString(4, pizza.getCat().toString());

			selectPizzaSt.executeUpdate();

			myConnection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;
	}

	public boolean updatePizza(String codePizza, Pizza pizza) throws UpdatePizzaException {
		ResourceBundle bundle = ResourceBundle.getBundle("jdbc");
		String value1 = bundle.getString("jdbc.url");
		String value2 = bundle.getString("jdbc.login");
		String value3 = bundle.getString("jdbc.pswrd");

		try {

			Connection myConnection = DriverManager.getConnection(value1, value2, value3);

			PreparedStatement selectPizzaSt = myConnection
					.prepareStatement("UPDATE `pizza`(`ID`, `CODE`, `NOM`, `PRIX`, `CATEGORIE`) VALUES (null,?,?,?,?)");
			selectPizzaSt.setString(1, pizza.getCode());
			selectPizzaSt.setString(2, pizza.getNom());
			selectPizzaSt.setDouble(3, pizza.getPrix());
			selectPizzaSt.setString(4, pizza.getCat().toString());

			int resultat = selectPizzaSt.executeUpdate();

			myConnection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;
	}

	public boolean deletePizza(String codePizza) throws DeletePizzaException {
		ResourceBundle bundle = ResourceBundle.getBundle("jdbc");
		String value1 = bundle.getString("jdbc.url");
		String value2 = bundle.getString("jdbc.login");
		String value3 = bundle.getString("jdbc.pswrd");

		try {

			Connection myConnection = DriverManager.getConnection(value1, value2, value3);

			PreparedStatement selectPizzaSt = myConnection
					.prepareStatement("DELETE FROM `pizza` WHERE CODE`" + codePizza + "`");
			selectPizzaSt.executeUpdate();

			myConnection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;
	}
}
