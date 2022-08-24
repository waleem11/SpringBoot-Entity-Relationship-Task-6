package com.springboottsk6.Task6.Product;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.springboottsk6.Task6.ProductReview.ProductReview;
import com.springboottsk6.Task6.ProductVariant.ProductVariant;
import com.springboottsk6.Task6.ProductVariantAvailable.ProductVariantAvailable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String description;


    @JsonProperty(value = "productReviews")
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "product_id")
    private List<ProductReview> productReviews;

    @JsonProperty(value = "productVariants")
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "product_id")
    private List<ProductVariant> productVariants;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "product_id")
    @JsonIgnore
    private List<ProductVariantAvailable> productVariantsAvailable;
}
