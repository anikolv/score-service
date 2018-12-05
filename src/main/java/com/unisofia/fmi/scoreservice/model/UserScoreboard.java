package com.unisofia.fmi.scoreservice.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Data
@Table(name="users_scoreboard")
public class UserScoreboard {
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 @JsonIgnore
	 private Long id;
	 @JsonIgnore
	 private Long userId;
	 private Long totalGames;
	 private Long totalPoints;
	 
	 public void incrementPoints(Long points) {
		 totalPoints+=points;
	 }
	 
	 public void incrementGames() {
		 totalGames+=1;
	 }
}
