package com.springboottsk6.Task6.Product;

import com.springboottsk6.Task6.ProductReview.ProductReview;
import com.springboottsk6.Task6.ProductVariant.ProductVariant;
import com.springboottsk6.Task6.ProductVariantAvailable.ProductVariantAvailable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;
    private String description;

    @OneToMany(mappedBy = "product")
    private List<ProductReview> productReviews;

    @OneToMany(mappedBy = "product")
    private List<ProductVariant> productVariants;

    @OneToMany(mappedBy = "product")
    private List<ProductVariantAvailable> productVariantsAvailable;

}
