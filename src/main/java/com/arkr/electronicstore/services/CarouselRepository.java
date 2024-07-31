package com.arkr.electronicstore.services;

import org.springframework.data.jpa.repository.JpaRepository;

import com.arkr.electronicstore.models.Carousel;

public interface CarouselRepository extends JpaRepository<Carousel, Integer> {

}
