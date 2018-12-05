package com.unisofia.fmi.scoreservice.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.unisofia.fmi.scoreservice.model.UserScoreboard;

public interface UserScoreboardRepository extends CrudRepository<UserScoreboard, Long> {
	
	public Optional<UserScoreboard> findByUserId(Long userId);
	
}
