package com.springmicro.services.web.service.impl;

import java.util.Random;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.springmicro.services.web.model.BeerDto;
import com.springmicro.services.web.service.BeerService;

@Service
public class BeerServiceImpl implements BeerService {

	@Override
	public BeerDto getBeerById(UUID beerId) {
		
		return	BeerDto.builder().id(UUID.randomUUID())
		.beerName("Galaxy cat")
		.beerStyle("Pale Ale")
		.upc(new Random().nextLong())
		.build();
		
		 
	}

	@Override
	public BeerDto saveBeer(BeerDto beerDto) {
		// TODO Auto-generated method stub
		return BeerDto.builder()
				.id(UUID.randomUUID())
				.build();
	}

	@Override
	public void updateBeer(UUID beerId, BeerDto beerDto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteBeer(UUID beerId) {
		// TODO Auto-generated method stub
		
	}

}
