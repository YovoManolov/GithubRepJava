package com.lab1.demo.repos;

import javax.annotation.Resource;

import org.springframework.data.repository.CrudRepository;

import com.lab1.demo.beans.Player;

public interface PlayerRepository extends CrudRepository<Player, Long> {

}
