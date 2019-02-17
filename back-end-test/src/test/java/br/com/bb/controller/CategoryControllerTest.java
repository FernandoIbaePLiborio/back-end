package br.com.bb.controller;

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

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@WebAppConfiguration
public class CategoryControllerTest {

	@Autowired
    private WebApplicationContext webApplicationContext;

	private MockMvc mockMvc;

	@Before
    public void setup() throws Exception {
        this.mockMvc = webAppContextSetup(webApplicationContext).build();
	}
	
	@Test
	public void testSuccessfulRequisition() throws Exception {
		mockMvc.perform(get("/category/listAll")
			.contentType(MediaType.APPLICATION_JSON_VALUE))
			.andExpect(status().is(200));
	}

	@Test
    public void listAll() throws Exception {
        mockMvc.perform(get("/category/listAll")
        	.contentType(MediaType.APPLICATION_JSON_VALUE))
	        .andExpect(status().isOk())
	    	.andExpect(jsonPath("$.list", hasSize(3)))
	        .andExpect(jsonPath("$.list[0].id", is(1)))
	        .andExpect(jsonPath("$.list[0].category", is("Alimentos")))
	        .andExpect(jsonPath("$.list[1].id", is(2)))
	        .andExpect(jsonPath("$.list[1].category", is("Eletrodomésticos")))
	        .andExpect(jsonPath("$.list[2].id", is(3)))
	        .andExpect(jsonPath("$.list[2].category", is("Móveis")));
    }
	
}
