package com.wildcodeschool.fco.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wildcodeschool.fco.entity.Cart;

public interface CartRepository extends JpaRepository<Cart, Long>{
	public Cart getBySessionId(String sessionId);
}
