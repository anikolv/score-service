package com.unisofia.fmi.scoreservice.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;

@JsonInclude(Include.NON_NULL)
public @Data class ScoreboardDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long userId;
	
	private Long points;	
}
