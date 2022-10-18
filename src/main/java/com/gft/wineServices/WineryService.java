package com.gft.wineServices;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gft.wine.Winery;
import com.gft.wineRepositories.WineryRepository;

@Service
public class WineryService {

	@Autowired
	private WineryRepository wineryRepository;
	
	
	//Find All 	
	public List<Winery> findAllWineries() {			
		return wineryRepository.findAll();
		}

	//Find by ID
	public Winery findOneWinery(Integer id) {		
		return wineryRepository.findById(id).get();
	}
	
	//Create - POST
	public	Winery newWinery (Winery winery) {
		return wineryRepository.save(winery);
	}
	
	//Modify - PUT
	public Winery changeWinery(Winery winery, Integer id) {
		
		Winery changedWinery = wineryRepository.findById(id).get();		
		
		changedWinery.setId(winery.getId());
		changedWinery.setName(winery.getName());
		
		return wineryRepository.save(changedWinery);		
		
	}		
		
	//Delete - DELETE
		
	public  Winery deleteMyWinery(Integer id) {
		Winery winery = wineryRepository.findById(id).get();
		wineryRepository.deleteById(id);
		return winery;
	}

		
	
}
