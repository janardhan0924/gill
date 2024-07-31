package com.arkr.electronicstore.services;

import org.springframework.data.jpa.repository.JpaRepository;

import com.arkr.electronicstore.models.Product;


public 	interface  ProductRepository extends JpaRepository<Product, Integer> {


}
