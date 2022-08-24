package com.springboottsk6.Task6.ProductVariant;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.springboottsk6.Task6.Product.Product;
import com.springboottsk6.Task6.ProductVariantAvailable.ProductVariantAvailable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "productvariants")
public class ProductVariant {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String description;


    @JsonProperty(value = "productVariantsAvailable")
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "product_variant_id")
    private List<ProductVariantAvailable> productVariantsAvailable;
}
