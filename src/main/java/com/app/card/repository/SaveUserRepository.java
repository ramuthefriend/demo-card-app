package com.app.card.repository;

import org.springframework.data.repository.CrudRepository;

import com.app.card.model.SaveUser;

public interface SaveUserRepository extends CrudRepository<SaveUser, Long> {
	
}
