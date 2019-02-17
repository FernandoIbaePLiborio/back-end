package br.com.bb.daointerface;

import br.com.bb.dao.CategoryDaoImpl;
import br.com.bb.dao.ProductDaoImpl;

public class DaoFactory {
	
	public static CategoryInterface getCategoryInterface() {
		return new CategoryDaoImpl();
	}
	
	public static ProductInterface getProductInterface() {
		return new ProductDaoImpl();
	}

}
