package com.example.demo.app.Dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.app.Entity.Jokes;

@Repository
public interface IJokesDao extends CrudRepository<Jokes, Long>{

	
	@Query("SELECT COUNT(j) from Jokes j")
    public int countAll();
	
	
}
