package com.springboottsk6.Task6.ProductVariantAvailable;

import com.springboottsk6.Task6.Product.Product;
import com.springboottsk6.Task6.ProductVariant.ProductVariant;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@AllArgsConstructor
@Data
@NoArgsConstructor
@Table(name = "productvariantsavailable")
public class ProductVariantAvailable implements Serializable {
    @Id
    @GeneratedValue
    private int id;

    private String sequence_number;


    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    private Product product;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "product_variant_id", referencedColumnName = "id")
    private ProductVariant productVariants;
}
