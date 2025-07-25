package com.andres.springboot.app.crudjpa.springboot_crud.models;

import com.andres.springboot.app.crudjpa.springboot_crud.validation.isRequired;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @isRequired(message = "{IsRequired.product.name}")
    @Size(min=3, max=20)
    private String name;

    @Min(500)
    @NotNull(message = "{NotNull.product.price}")
    private Integer price;


    @isRequired
    // @NotEmpty(message = "{NotEmpty.product.name}")
    private String description;
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Integer getPrice() {
        return price;
    }
    public void setPrice(Integer price) {
        this.price = price;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }



}
