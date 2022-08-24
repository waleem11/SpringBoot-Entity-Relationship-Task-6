package com.springboottsk6.Task6.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService pService;

    @GetMapping()
    public List<Product> getAllProducts(){
        return pService.getProducts();
    }

    @PostMapping()
    public Product addProduct(@RequestBody Product product){
        System.out.println(product.toString());
        return  pService.addProduct(product);
    }
}
