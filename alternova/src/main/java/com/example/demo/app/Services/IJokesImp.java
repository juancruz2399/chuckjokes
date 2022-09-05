package com.example.demo.app.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.app.Dao.IJokesDao;
import com.example.demo.app.Entity.Jokes;

@Service
public class IJokesImp implements IJokesService{


	@Autowired
	IJokesDao JokesDao;
	
	@Override
	public List<Jokes> listJokes() {
		// TODO Auto-generated method stub
		return (List<Jokes>)JokesDao.findAll();
	}

	@Override
	public Jokes findOne(Long id) {
		// TODO Auto-generated method stub
		return JokesDao.findById(id).orElse(null);
	}

	@Override
	public void save(Jokes jokes) {
		// TODO Auto-generated method stub
		JokesDao.save(jokes);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		JokesDao.delete(findOne(id));
	}

}
