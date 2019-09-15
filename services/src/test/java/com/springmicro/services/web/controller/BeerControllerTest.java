package com.springmicro.services.web.controller;


import static org.hamcrest.CoreMatchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Random;
import java.util.UUID;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.springmicro.services.web.model.BeerDto;
import com.springmicro.services.web.service.BeerService;



@RunWith(SpringRunner.class)
@WebMvcTest(BeerController.class)
public class BeerControllerTest {

	@MockBean
	BeerService beerService;

	@Autowired
	MockMvc mockmvc;

	@Autowired
	ObjectMapper objectMapper;

	BeerDto validbeer;

	@Before
	public void setUp() {

		validbeer=BeerDto.builder().id(UUID.randomUUID())
				.beerName("Beer1")
				.beerStyle("pale_ale")
				.upc(new Random().nextLong())
				.build();

	}

	@Test
	public void getBeer() throws Exception{
		given(beerService.getBeerById(any(UUID.class))).willReturn(validbeer);
		
		mockmvc.perform(get("/api/v1/beer/" + validbeer.getId().toString()).accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
        .andExpect(jsonPath("$.id", is(validbeer.getId().toString())))
        .andExpect(jsonPath("$.beerName", is("Beer1")));
	}
	
	@Test
	public void postBeer() throws Exception{
		BeerDto beerDto=validbeer;
		beerDto.setId(null);
		BeerDto saveDto=BeerDto.builder().id(UUID.randomUUID()).beerName("New Beer").build();
		String beerDtoJson=objectMapper.writeValueAsString(beerDto);
		
		given(beerService.saveBeer(any())).willReturn(saveDto);
		
		mockmvc.perform(post("api/v1/beer")
				.contentType(MediaType.APPLICATION_JSON)
				.content(beerDtoJson)).andExpect(status().isCreated());
	}


}
