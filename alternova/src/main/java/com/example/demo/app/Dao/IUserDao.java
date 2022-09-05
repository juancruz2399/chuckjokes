package com.example.demo.app.Dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.app.Entity.User;


@Repository
public interface IUserDao extends CrudRepository<User, Long> {

	@Query("SELECT COUNT(u) from User u")
    public int countAll();
	
	@Query("SELECT u FROM User u WHERE u.Nombre=?1")
    public User findByName(String name);
}
