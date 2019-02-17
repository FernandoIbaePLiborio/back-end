package br.com.bb.daointerface;

import java.util.List;

import br.com.bb.model.Product;

public interface ProductInterface {
	
	List<Product> listByCategoryName(String category);
	
	List<Product> listByCategory(int id);

}
