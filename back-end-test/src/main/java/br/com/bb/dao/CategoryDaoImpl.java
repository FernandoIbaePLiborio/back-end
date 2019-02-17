package br.com.bb.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.bb.daointerface.CategoryInterface;
import br.com.bb.model.Category;

public class CategoryDaoImpl implements CategoryInterface {

	static final String JDBC_DRIVER = "org.h2.Driver";   
	static final String DB_URL = "jdbc:h2:mem:testdb";  
   
	static final String USER = "sa"; 
	static final String PASS = ""; 

	@Override
	public List<Category> listAllCategory() {
		
		Connection connection = null; 
	    Statement stmt = null; 
		
		List<Category> categoryList = new ArrayList<>();
		try {
			Class.forName(JDBC_DRIVER);
			connection = DriverManager.getConnection(DB_URL,USER,PASS);
			stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM CATEGORY ORDER BY CATEGORY");
			while (rs.next()) {
				Category category = new Category();
				category.setId(rs.getInt("ID"));
				category.setCategory(rs.getString("CATEGORY"));
				categoryList.add(category);
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return categoryList;
	}
	
}
