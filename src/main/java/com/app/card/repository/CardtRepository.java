package com.app.card.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.card.model.Card;


@Repository
public interface CardtRepository extends JpaRepository<Card, Long> {

}
