package com.app.card.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.app.card.model.Card;
import com.app.card.repository.CardtRepository;



@Service
public class CardServices {

	@Autowired
	private CardtRepository repo;
	
	public List<Card> listAll(){
		return repo.findAll();
	}
	
	public void save(Card card) {
		card.setCreatedBy(SecurityContextHolder.getContext().getAuthentication().getName());
		repo.save(card);
	}
	
	public Card get(Long id) {
		return repo.findById(id).get();
	}
	
	public void delete(Long id) {
		repo.deleteById(id);
	}

	public List<Card> listByCard(Card card) {
		Example<Card> example = Example.of(card);
		return repo.findAll(example);
	}
	
	
}
