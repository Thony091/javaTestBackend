package com.duoc.usersRest.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.duoc.usersRest.modelo.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{
  
}
