package com.andres.springboot.app.crudjpa.springboot_crud.repositories;

import org.springframework.data.repository.CrudRepository;

import com.andres.springboot.app.crudjpa.springboot_crud.models.Product;

public interface ProductRepository extends CrudRepository<Product, Long> {

}
