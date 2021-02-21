/**
 * 
 */
package com.app.card.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.app.card.model.SaveUser;
import com.app.card.repository.SaveUserRepository;

/**
 * @author ramamohan.gogula
 *
 */
@Service
public class UserService {
	@Autowired
	private SaveUserRepository repo;
	
	public void save(SaveUser user) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		user.setPassword(encoder.encode(user.getPassword()));
		user.setEnabled(true);
		repo.save(user);
	}
	
}
