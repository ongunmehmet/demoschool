package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Season;

public interface SeasonRepository extends JpaRepository<Season, Integer> {

}
