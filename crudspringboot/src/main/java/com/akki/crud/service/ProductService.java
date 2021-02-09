package com.akki.crud.service;

import com.akki.crud.entity.Product;
import com.akki.crud.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    public Product saveProduct(Product product){
        return repository.save(product);
    }

    public List<Product> saveProducts(List<Product> products){
        return repository.saveAll(products);
    }

    public List<Product> getProducts(){
        return repository.findAll();
    }

    public Product getProductById(int id) {
        return repository.findById(id).orElse(null);
    }

    public Product getProductByName(String name){
        return repository.findByName(name);
    }
    public String deleteProductById(int id){
        repository.deleteById(id);
        return "Product with id "+id+" Deleted Successfully !!";
    }
    public Product updateProduct(Product product) {
        Product existingProduct = repository.findById(product.getId()).orElse(null);
        existingProduct.setName(product.getName());
        existingProduct.setQuantity(product.getQuantity());
        existingProduct.setTotal_price(product.getTotal_price());
        existingProduct.setUnit_price(product.getUnit_price());
        existingProduct.setType(product.getType());
        return repository.save(existingProduct);
    }
}
