package com.gft.wineRepositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.gft.wine.Wine;

@Repository
@Transactional
public interface WineRepository extends JpaRepository <Wine,Integer> {
	
	@Query("select w from Wine w order by w.rating desc")
	List<Wine> getTop10();
	
}


