package com.akki.crud.repository;

import com.akki.crud.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProductRepository extends JpaRepository<Product,Integer> {


    Product findByName(String name);


}
