package com.springboottsk6.Task6.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    private ProductRepository pRepo;

    @Autowired
    public ProductService(ProductRepository pRepo) {
        this.pRepo = pRepo;
    }


    public List<Product> getProducts(){
        List<Product>  plist = new ArrayList<>();
        pRepo.findAll().forEach(plist::add);
        return plist;
    }

    public Product addProduct(Product product){
        return pRepo.save(product);
    }
}
