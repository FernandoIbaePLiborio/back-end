package br.com.bb.controller;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.bb.daointerface.CategoryInterface;
import br.com.bb.daointerface.DaoFactory;
import br.com.bb.daointerface.ProductInterface;
import br.com.bb.dto.CategoryDTO;
import br.com.bb.dto.ProductDTO;
import br.com.bb.model.Category;
import br.com.bb.model.Product;

@RestController
public class ProdutoController {
	
	private static String PRODUTOS_CATEGORIA = "Produtos por categoria";
	private static String CATEGORIAS = "Categorias";
	
	@RequestMapping(value = "/category/listAll", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
	public CategoryDTO listCategory() {
		
		CategoryInterface tDao = DaoFactory.getCategoryInterface();
		List<Category> categoryList = tDao.listAllCategory();
		
		if (CollectionUtils.isEmpty(categoryList))
			return new CategoryDTO(false, "Nenhum registro para categorias foi encontrado.");
		return new CategoryDTO(true, CATEGORIAS, categoryList);
	}
	
	@RequestMapping(value = "/product/listByCategory/{id}", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
	public ProductDTO listByCategory(@PathVariable("id") int id) {
		
		ProductInterface tDao = DaoFactory.getProductInterface();
		List<Product> productList = tDao.listByCategory(id);
		
		if (CollectionUtils.isEmpty(productList))
			return new ProductDTO(false, "Nenhum registro Número:'" + id + "' foi encontrado");
		return new ProductDTO(true, PRODUTOS_CATEGORIA, productList);
    }
	
	@RequestMapping(value = "/product/listByCategoryName/{category}", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
	public ProductDTO listByCategoryName(@PathVariable("category") String category) {
		
		ProductInterface tDao = DaoFactory.getProductInterface();
		List<Product> productList = tDao.listByCategoryName(category);

		if (CollectionUtils.isEmpty(productList))
			return new ProductDTO(false, "Nenhum registro: '" + category + "' foi encontrado");
		return new ProductDTO(true, PRODUTOS_CATEGORIA, productList);
    }
	
}
