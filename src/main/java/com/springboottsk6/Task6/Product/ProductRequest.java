package com.springboottsk6.Task6.Product;

import com.springboottsk6.Task6.ProductReview.ProductReview;
import com.springboottsk6.Task6.ProductVariant.ProductVariant;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ProductRequest {
    private String name;
    private String description;
    private List<ProductReview> productReviews;
    private List<ProductVariant> productVariants;
}
