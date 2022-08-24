package com.springboottsk6.Task6.ProductVariantAvailable;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.springboottsk6.Task6.Product.Product;
import com.springboottsk6.Task6.ProductVariant.ProductVariant;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Table(name = "productvariantsavailable")
public class ProductVariantAvailable {
    @Id
    @GeneratedValue
    private int id;
    private String sequence_number;

//    @JsonBackReference
//    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "product_id", referencedColumnName = "id")
//    @JsonIgnore
//    private Product product;

    public ProductVariantAvailable(String sequence_number, Product product) {
        this.sequence_number = sequence_number;
//        this.product = product;
    }

    public void setSequence_number(String sequence_number) {
        this.sequence_number = sequence_number;
    }

    public int getId() {
        return id;
    }

    public String getSequence_number() {
        return sequence_number;
    }

//    public Product getProduct() {
//        return product;
//    }
//    @JsonIgnore
//    @JsonProperty(value = "productVariants")
//    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn("product_id")
//    private ProductVariant productVariants;
}
