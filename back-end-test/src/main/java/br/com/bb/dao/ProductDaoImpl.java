package br.com.bb.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.bb.daointerface.ProductInterface;
import br.com.bb.model.Category;
import br.com.bb.model.Product;

public class ProductDaoImpl implements ProductInterface{
	
	static final String JDBC_DRIVER = "org.h2.Driver";   
	static final String DB_URL = "jdbc:h2:mem:testdb";  
   
	static final String USER = "sa"; 
	static final String PASS = ""; 
	
	@Override
	public List<Product> listByCategory(int id) {

		List<Product> productList = new ArrayList<>();
		Connection connection = null; 
	    Statement stmt = null;
	    
	    try {
			Class.forName(JDBC_DRIVER);
			connection = DriverManager.getConnection(DB_URL,USER,PASS);
			stmt = connection.createStatement();
			String sql = "SELECT P.ID, P.NAME, P.CATEGORY_ID, G.CATEGORY "
					+ "FROM PRODUCT AS P "
					+ "INNER JOIN CATEGORY AS G ON G.ID = P.CATEGORY_ID "
					+ "WHERE P.CATEGORY_ID = '"+Integer.toString(id)+"' ORDER BY P.ID";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Product product = new Product();
				product.setId(rs.getInt("ID"));
				product.setName(rs.getString("NAME"));
				product.setCategory(new Category());
				product.getCategory().setId(rs.getInt("CATEGORY_ID"));
				product.getCategory().setCategory(rs.getString("CATEGORY"));
				productList.add(product);
			}
			rs.close();
			stmt.close();
	    } catch (SQLException e) {
			throw new RuntimeException();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return productList;
	}

	@Override
	public List<Product> listByCategoryName(String category) {
		
		List<Product> productList = new ArrayList<>();
		
		Connection connection = null; 
	    Statement stmt = null;
	    
	    try {
			Class.forName(JDBC_DRIVER);
			connection = DriverManager.getConnection(DB_URL,USER,PASS);
			stmt = connection.createStatement();
			String sql = "SELECT P.ID, P.NAME, P.CATEGORY_ID, C.CATEGORY FROM PRODUCT P INNER JOIN CATEGORY C ON P.CATEGORY_ID = C.ID WHERE UPPER(C.CATEGORY) LIKE UPPER('%"+category+"%')";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Product product = new Product();
				product.setId(rs.getInt("ID"));
				product.setName(rs.getString("NAME"));
				product.setCategory(new Category());
				product.getCategory().setId(rs.getInt("CATEGORY_ID"));
				product.getCategory().setCategory(rs.getString("CATEGORY"));
				productList.add(product);
			}
			rs.close();
			stmt.close();
	    } catch (SQLException e) {
			throw new RuntimeException();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return productList;
	}

}
