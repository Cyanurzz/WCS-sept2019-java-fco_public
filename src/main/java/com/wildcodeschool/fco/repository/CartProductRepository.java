package com.wildcodeschool.fco.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wildcodeschool.fco.entity.CartProduct;

public interface CartProductRepository extends JpaRepository<CartProduct, Long> {
    public List<CartProduct> findByCartId(Long id);
}
