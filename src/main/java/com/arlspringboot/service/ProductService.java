package com.arlspringboot.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.arlspringboot.entity.ProductEntity;
import com.arlspringboot.utils.RandomNumber;

@Service
public class ProductService {
    // Product diambil dari model entity (ProductEntity.java)
    // products nama listnya
    private static List<ProductEntity> products = new ArrayList<ProductEntity>() {

        {
            // 1L => karena type data di model entity nya Long
            // function RandomNumber.getRandom diambil dari utils
            add(new ProductEntity(RandomNumber.getRandom(1000,9999), "001", "Product 001", 1000.0));
            add(new ProductEntity(RandomNumber.getRandom(1000,9999), "002", "Product 002", 2000.0));
            add(new ProductEntity(RandomNumber.getRandom(1000,9999), "003", "Product 003", 3000.0));
            add(new ProductEntity(RandomNumber.getRandom(1000,9999), "004", "Product 004", 4000.0));

        }

    };

    // Function findAll untuk me return List products diatas
    public List<ProductEntity> findAll() {
        return products;
    }

    public static void addProduct(ProductEntity product) {
        product.setId(RandomNumber.getRandom(1000,9999));
        products.add(product);
    }

    public static Optional<ProductEntity> findById(long id){
        return products.stream().filter(p -> p.getId() == id).findFirst();
        // return repo.findById(id);
    }

    public static void updateProduct(ProductEntity product){
        //ini hanya contoh karena data static
        //kalau pake database menggunakan query seperti JPA atau ODBC
        deleteByid(product.getId());
        products.add(product);
        //repo.save(product);
    }

    public static void deleteByid(long id){
         products.removeIf(p -> p.getId() == id);
        //repo.deleteById(id);
    }
}
