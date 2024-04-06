package com.arlspringboot.entity;

public class ProductEntity {
    private Long id;
    private String name;
    private String code;
    private Double price;

    //Empty construtor
    public ProductEntity() {
    }

    //constructor using all fields
    public ProductEntity(Long id, String name, String code, Double price) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.price = price;
    }

    //setter & getter
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Double getPrice() {
        return this.price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

}
