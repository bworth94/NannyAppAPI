package com.NannyAppAPI.NannyAppAPI.repositories;

import java.util.List;


import org.springframework.data.repository.CrudRepository;

import com.NannyAppAPI.NannyAppAPI.domain.NannyApp;

public interface NannyAppRepository extends CrudRepository<NannyApp, Integer>{
	
	List<NannyApp> findByDay(String day);
	
	List<NannyApp> findByDayAndTime(String day, String time);
}