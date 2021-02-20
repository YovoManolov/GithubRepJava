package com.lab1.demo;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.lab1.demo.beans.Player;
import com.lab1.demo.beans.Team;
import com.lab1.demo.repos.TeamRepository;

@SpringBootApplication
public class Lab1Application {

	@Autowired
	TeamRepository teamRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(Lab1Application.class, args);
	}
	
	@PostConstruct
	public void init() {
		
		List<Team> list = new ArrayList<>();

	  	Set<Player> set = new HashSet<>();
	  	set.add(new Player("Big Easy", "Showman"));
	  	set.add(new Player("Buckets", "Guard"));
	  	set.add(new Player("Dizzy", "Guard"));
	  	
	  	list.add(new Team("Harlem", "Globetrotters", set));
	  	
		set = new HashSet<>();
	  	set.add(new Player("Big Easy2", "Showman"));
	  	set.add(new Player("Buckets2", "Guard"));
	  	set.add(new Player("Dizzy2", "Guard"));
	  	
	  	list.add(new Team("Washington","Generals",set));

	  	teamRepository.saveAll(list);
	}

}
