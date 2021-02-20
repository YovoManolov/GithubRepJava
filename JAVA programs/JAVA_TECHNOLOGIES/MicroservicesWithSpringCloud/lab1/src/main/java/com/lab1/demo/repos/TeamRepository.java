package com.lab1.demo.repos;

import org.springframework.data.repository.CrudRepository;

import com.lab1.demo.beans.Team;

public interface TeamRepository extends CrudRepository<Team, Long> {

}
