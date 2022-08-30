package com.springboottsk6.Task6.ProductVariant;

import com.springboottsk6.Task6.Product.Product;
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
@Table(name = "productvariants")
public class ProductVariant implements Serializable {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String description;


    @OneToMany(mappedBy = "productVariants")
    private List<ProductVariantAvailable> productVariantsAvailable;


    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    private Product product;
}
