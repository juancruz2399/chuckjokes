package com.example.demo.app.Services;

import java.util.List;
import java.util.Optional;

import com.example.demo.app.Entity.Jokes;


public interface IJokesService {

	public List<Jokes> listJokes();

	public Jokes findOne(Long id);
	public void save(Jokes jokes);
	public void delete(Long id);
}
