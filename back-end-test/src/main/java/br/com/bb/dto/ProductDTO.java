package br.com.bb.dto;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import br.com.bb.model.Product;

@XmlRootElement(name = "ProductDTO")
public class ProductDTO extends AbstractDTO<Product>{

	public ProductDTO() {
		super();
	}
	
	public ProductDTO(List<Product> pList) {
		super(pList);
	}
	
	public ProductDTO(boolean pOk, String pMensagem) {
		super(pOk, pMensagem);
	}
	
	public ProductDTO(boolean pOk, List<Product> pList) {
		super(pOk, pList);
	}

	public ProductDTO(boolean pOk, String pMensagem, List<Product> pList) {
		super(pOk, pMensagem, pList);
	}

}
