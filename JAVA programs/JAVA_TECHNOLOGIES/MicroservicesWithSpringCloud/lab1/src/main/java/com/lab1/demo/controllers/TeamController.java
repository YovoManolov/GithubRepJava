package com.lab1.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lab1.demo.beans.Team;
import com.lab1.demo.repos.TeamRepository;

@RestController
public class TeamController {
	
	@Autowired
	TeamRepository teamRepository;
	
	@RequestMapping(value="/teams",
			produces = { "application/json", "application/xml" },
			 method = RequestMethod.GET)
	public Iterable<Team> getTeams(){
		return teamRepository.findAll();
	}
	
	@RequestMapping(value="team/{id}",
				produces = { "application/json", "application/xml" },
				 method = RequestMethod.GET)
	public Team returnTeamById(@PathVariable Long id) {
		return teamRepository.findById(id).get();
	}
	
}