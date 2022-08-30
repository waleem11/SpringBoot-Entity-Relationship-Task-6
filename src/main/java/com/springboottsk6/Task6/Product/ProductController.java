package com.springboottsk6.Task6.Product;

import com.springboottsk6.Task6.ProductReview.ProductReview;
import com.springboottsk6.Task6.ProductReview.ProductReviewRepository;
import com.springboottsk6.Task6.ProductVariant.ProductVariant;
import com.springboottsk6.Task6.ProductVariant.ProductVariantRepository;
import com.springboottsk6.Task6.ProductVariantAvailable.ProductVariantAvailable;
import com.springboottsk6.Task6.ProductVariantAvailable.ProductVariantAvailableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductReviewRepository productReviewRepository;

    @Autowired
    private ProductVariantRepository productVariantRepository;

    @Autowired
    private ProductVariantAvailableRepository productVariantAvailableRepository;

    @RequestMapping("/products")
    @PostMapping
    public ResponseEntity<?> product_request(@RequestBody ProductRequest productRequest){
        Product tempProduct = new Product();
        tempProduct.setName(productRequest.getName());
        tempProduct.setDescription(productRequest.getDescription());
        tempProduct.setProductReviews(productRequest.getProductReviews());
        tempProduct.setProductVariants(productRequest.getProductVariants());
        productRepository.save(tempProduct);

        for(ProductReview currentProductReviews : productRequest.getProductReviews()){
            currentProductReviews.setProduct(tempProduct);
            productReviewRepository.save(currentProductReviews);
        }

        for(ProductVariant currentProductVariants : productRequest.getProductVariants()){
            currentProductVariants.setProduct(tempProduct);
            productVariantRepository.save(currentProductVariants);
            for(ProductVariantAvailable currentProductVariantsAvailable : currentProductVariants.getProductVariantsAvailable()){
                currentProductVariantsAvailable.setProductVariants(currentProductVariants);
                currentProductVariantsAvailable.setProduct(tempProduct);
                productVariantAvailableRepository.save(currentProductVariantsAvailable);
            }
        }

        return ResponseEntity.ok("Data Saved");
    }
}
