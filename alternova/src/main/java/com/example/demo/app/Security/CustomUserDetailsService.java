package com.example.demo.app.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.app.Dao.IUserDao;
import com.example.demo.app.Entity.User;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	
	@Autowired
	private IUserDao UserDao;
	
	@Override
	public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
		User user = UserDao.findByName(name);
		return new CustomUserDetails(user);
	}

}
