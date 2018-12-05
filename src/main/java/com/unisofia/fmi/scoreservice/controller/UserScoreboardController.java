package com.unisofia.fmi.scoreservice.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.unisofia.fmi.scoreservice.dto.ScoreboardDTO;
import com.unisofia.fmi.scoreservice.exception.UserNotFoundException;
import com.unisofia.fmi.scoreservice.model.Status;
import com.unisofia.fmi.scoreservice.model.UserScoreboard;
import com.unisofia.fmi.scoreservice.repository.UserScoreboardRepository;

@RestController
@RequestMapping(value = "/scoreboard")
public class UserScoreboardController {
	
	@Autowired
	private UserScoreboardRepository userScoreboardRepository;
	
	private final static long INIT_TOTAL_GAMES = 1;
	
	@PostMapping(value = "/set")
	public Status setScore(@RequestBody ScoreboardDTO scoreDTO) {
		final Optional<UserScoreboard> scoreBoard = userScoreboardRepository.findByUserId(scoreDTO.getUserId());
		UserScoreboard scoreboard = null;
		if (scoreBoard.isPresent()) {
			scoreboard = (UserScoreboard) scoreBoard.get();
			scoreboard.incrementPoints(scoreDTO.getPoints());
		} else {
			scoreboard = new UserScoreboard();
			scoreboard.setTotalGames(INIT_TOTAL_GAMES);
			scoreboard.setTotalPoints(scoreDTO.getPoints());
			scoreboard.setUserId(scoreDTO.getUserId());
		}
		userScoreboardRepository.save(scoreboard);
		return new Status(true);
	}
	
	@GetMapping(value = "/get")
	public UserScoreboard getUser(@RequestParam Long userId) throws UserNotFoundException {
		return userScoreboardRepository.findByUserId(userId).orElseThrow(() -> new UserNotFoundException());
	}
	
	@GetMapping(value = "/getAll")
	public Iterable<UserScoreboard> getUsers() {
		return userScoreboardRepository.findAll();
	}

}
