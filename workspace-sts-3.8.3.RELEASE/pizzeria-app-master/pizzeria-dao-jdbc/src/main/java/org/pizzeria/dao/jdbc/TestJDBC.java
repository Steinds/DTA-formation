package org.pizzeria.dao.jdbc;

import java.sql.*;
import java.util.ResourceBundle;

public class TestJDBC {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		ResourceBundle bundle = ResourceBundle.getBundle("jdbc");
		String value = bundle.getString("jdbcurl");
		Class.forName("com.mysql.jdbc.Driver");
		
		Connection myConnection = DriverManager.getConnection(value, "root", "");
		Statement statement = myConnection.createStatement();

		ResultSet resultats = statement.executeQuery(" SELECT COUNT(*) FROM pizza ");
		resultats.next();
		int count = resultats.getInt(1);
		resultats.close();
		resultats = statement.executeQuery(" SELECT * FROM pizza ");
		while (resultats.next()) {
			Integer id = resultats.getInt("ID");
			String name = resultats.getString("NOM");
			float prix = resultats.getFloat("PRIX");
			System.out.println("[id=" + id + " nom=" + name + " prix=" + prix + "]");
			;
		}
		resultats.close();
		PreparedStatement selectPizzaSt = myConnection.prepareStatement("SELECT * FROM PIZZA WHERE ID=?");
		for (int i = 1; i < count; i++) {

			selectPizzaSt.setInt(1, i);

			resultats = selectPizzaSt.executeQuery();
			resultats.next();
			System.out.println(resultats.getString(2));
		}

		resultats.close();
	}

}
