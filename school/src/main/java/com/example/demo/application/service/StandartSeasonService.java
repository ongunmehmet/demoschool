package com.example.demo.application.service;

import org.springframework.stereotype.Service;

import com.example.demo.application.SeasonApplication;
import com.example.demo.entity.Season;
import com.example.demo.repository.SeasonRepository;
@Service
public class StandartSeasonService implements SeasonApplication{
	
	private  SeasonRepository seasonRepository;

	public StandartSeasonService(SeasonRepository seasonRepository) {
		this.seasonRepository = seasonRepository;
	}

	@Override

	public Season add(Season season) {
		// TODO Auto-generated method stub
		return seasonRepository.save(season) ;
	}

}
