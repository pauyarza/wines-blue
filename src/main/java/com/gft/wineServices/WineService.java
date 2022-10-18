package com.gft.wineServices;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import com.gft.wine.Wine;
import com.gft.wineRepositories.WineRepository;


@Service
public class WineService {
	@Autowired
	private WineRepository wineRepository;	
	
	
	

	//Find All -GET
				
	public List<Wine> findAllWines() {			
		return wineRepository.findAll();
	}	
	
	//Find by ID -GET
	public Wine findOneWine (Integer id) {		
		return wineRepository.findById(id).get();
	}

	//Create - POST
	public	Wine newWine (Wine wine) {
		return wineRepository.save(wine);
	}
	
	//Modify - PUT
	public Wine changeWine(Wine wine, Integer id) {
		
		Wine changedWine = wineRepository.findById(id).get();		
		
		changedWine.setId(wine.getId());
		changedWine.setName(wine.getName());
		changedWine.setYear(wine.getYear());
		changedWine.setRating(wine.getRating());
		changedWine.setNum_reviews(wine.getNum_reviews());
		changedWine.setPrice(wine.getPrice());
		changedWine.setBody(wine.getBody());
		changedWine.setAcidity(wine.getAcidity());
		changedWine.setWinery(wine.getWinery());
		changedWine.setType(wine.getType());
		changedWine.setRegion(wine.getRegion());
		
		return wineRepository.save(changedWine);		
		
	}
	
	//Delete - DELETE
	
	public  Wine deleteMyWine(Integer id) {
		Wine wine = wineRepository.findById(id).get();
		wineRepository.deleteById(id);
		return wine;
	}
	
	//Recommendations - GET
	
	
	public List<Wine> top10Rated() {
		
		List<Wine> topG = wineRepository.getTop10().subList(0, 10);
		return topG;
	}
		
		
		
		
		
}
