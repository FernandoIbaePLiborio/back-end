package br.com.bb.dto;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import br.com.bb.model.Category;

@XmlRootElement(name = "CategoryDTO")
public class CategoryDTO extends AbstractDTO<Category>{

	public CategoryDTO() {
		super();
	}
	
	public CategoryDTO(List<Category> pLista) {
		super(pLista);
	}
	
	public CategoryDTO(boolean pOk, String pMensagem) {
		super(pOk, pMensagem);
	}
	
	public CategoryDTO(boolean pOk, List<Category> pLista) {
		super(pOk, pLista);
	}

	public CategoryDTO(boolean pOk, String pMensagem, List<Category> pLista) {
		super(pOk, pMensagem, pLista);
	}

}
