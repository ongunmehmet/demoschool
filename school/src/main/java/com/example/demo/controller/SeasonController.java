package com.example.demo.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;

import com.example.demo.application.SeasonApplication;
import com.example.demo.entity.Season;

@RestController
@RequestScope
@RequestMapping("/season")
public class SeasonController {
	private SeasonApplication seasonApplication;

	public SeasonController(SeasonApplication seasonApplication) {
		this.seasonApplication = seasonApplication;
	}
	@PostMapping("/add")
	public Season addSeason(@RequestBody Season season) {
		return seasonApplication.add(season);
	}
	
}
