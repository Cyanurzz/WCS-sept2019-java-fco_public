package com.wildcodeschool.fco.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.wildcodeschool.fco.entity.Product;

@Repository
public interface ShopRepository extends JpaRepository<Product, Integer>{
	
	@Query("SELECT p FROM Product p WHERE p.quantity = null")
	public List<Product> findAllClothes();
	
	@Query("SELECT p FROM Product p WHERE p.quantity != null")
	public List<Product> findAllGoodies();
}
