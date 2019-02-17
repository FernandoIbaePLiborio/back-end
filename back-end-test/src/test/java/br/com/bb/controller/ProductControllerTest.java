package br.com.bb.controller;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import br.com.bb.Application;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@WebAppConfiguration
public class ProductControllerTest {

	@Autowired
    private WebApplicationContext webApplicationContext;

	private MockMvc mockMvc;

	@Before
    public void setup() throws Exception {
        this.mockMvc = webAppContextSetup(webApplicationContext).build();
	}
	
	@Test
	public void testSuccessfulRequisition() throws Exception {
		mockMvc.perform(get("/product/listByCategoryName/Ali")
			.contentType(MediaType.APPLICATION_JSON_VALUE))
			.andExpect(status().is(200));
	}

	@Test
    public void listByCategoryAlimentos() throws Exception {
        mockMvc.perform(get("/product/listByCategory/1"))
        	.andExpect(status().isOk())
	    	.andExpect(jsonPath("$.list", hasSize(2)))
	        .andExpect(jsonPath("$.list[0].id", is(1)))
	        .andExpect(jsonPath("$.list[0].name", is("Arroz")))
	        .andExpect(jsonPath("$.list[0].category.id", is(1)))
			.andExpect(jsonPath("$.list[0].category.category", is("Alimentos")))
	        .andExpect(jsonPath("$.list[1].id", is(2)))
	        .andExpect(jsonPath("$.list[1].name", is("Feijão")))
	        .andExpect(jsonPath("$.list[0].category.id", is(1)))
			.andExpect(jsonPath("$.list[0].category.category", is("Alimentos")));
    }

	@Test
	public void listByCategoryEletrodomesticos() throws Exception {
		mockMvc.perform(get("/product/listByCategory/2"))
			.andExpect(status().isOk())
			.andExpect(jsonPath("$.list", hasSize(3)))
			.andExpect(jsonPath("$.list[0].id", is(3)))
			.andExpect(jsonPath("$.list[0].name", is("Aspirador de pó")))
			.andExpect(jsonPath("$.list[0].category.id", is(2)))
			.andExpect(jsonPath("$.list[0].category.category", is("Eletrodomésticos")))
			.andExpect(jsonPath("$.list[1].id", is(4)))
			.andExpect(jsonPath("$.list[1].name", is("Batedeira")))
			.andExpect(jsonPath("$.list[0].category.id", is(2)))
			.andExpect(jsonPath("$.list[0].category.category", is("Eletrodomésticos")))
			.andExpect(jsonPath("$.list[2].id", is(5)))
			.andExpect(jsonPath("$.list[2].name", is("Liquidificador")))
			.andExpect(jsonPath("$.list[0].category.id", is(2)))
			.andExpect(jsonPath("$.list[0].category.category", is("Eletrodomésticos")));
	}

	@Test
	public void listByCategoryMoveis() throws Exception {
		mockMvc.perform(get("/product/listByCategory/3")
			.contentType(MediaType.APPLICATION_JSON_VALUE))
			.andExpect(status().isOk())
			.andExpect(jsonPath("$.list", hasSize(3)))
			.andExpect(jsonPath("$.list[0].id", is(6)))
			.andExpect(jsonPath("$.list[0].name", is("Sofá")))
			.andExpect(jsonPath("$.list[0].category.id", is(3)))
			.andExpect(jsonPath("$.list[0].category.category", is("Móveis")))
			.andExpect(jsonPath("$.list[1].id", is(7)))
			.andExpect(jsonPath("$.list[1].name", is("Mesa")))
			.andExpect(jsonPath("$.list[1].category.id", is(3)))
			.andExpect(jsonPath("$.list[1].category.category", is("Móveis")))
			.andExpect(jsonPath("$.list[2].id", is(8)))
			.andExpect(jsonPath("$.list[2].name", is("Estante")))
			.andExpect(jsonPath("$.list[2].category.id", is(3)))
			.andExpect(jsonPath("$.list[2].category.category", is("Móveis")));
	}
	
	@Test
	public void listByCategoryName() throws Exception {
		mockMvc.perform(get("/product/listByCategoryName/Ali")
			.contentType(MediaType.APPLICATION_JSON_VALUE))
			.andExpect(status().isOk())
			.andExpect(jsonPath("$.list", hasSize(2)))
			.andExpect(jsonPath("$.list[0].id", is(1)))
			.andExpect(jsonPath("$.list[0].name", is("Arroz")))
			.andExpect(jsonPath("$.list[0].category.id", is(1)))
			.andExpect(jsonPath("$.list[0].category.category", is("Alimentos")))
			.andExpect(jsonPath("$.list[1].id", is(2)))
			.andExpect(jsonPath("$.list[1].name", is("Feijão")))
			.andExpect(jsonPath("$.list[1].category.id", is(1)))
			.andExpect(jsonPath("$.list[1].category.category", is("Alimentos")));
	}
	
	@Test
	public void listByCategoryNameNotExist() throws Exception {
		mockMvc.perform(get("/product/listByCategoryName/tamara")
			.contentType(MediaType.APPLICATION_JSON_VALUE))
			.andExpect(status().isOk())
			.andExpect(jsonPath("$.ok", is(false)))
			.andExpect(jsonPath("$.message", is("Nenhum registro: 'tamara' foi encontrado")));
	}
	
}
