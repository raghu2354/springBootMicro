package com.springmicro.services.web.model;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BeerDto{

	 UUID id;
	 String beerName;
	 String beerStyle;
	 Long upc;
	
	
}
