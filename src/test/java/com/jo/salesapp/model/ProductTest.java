package com.jo.salesapp.model;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;


public class ProductTest {

    @Test
    void isTaxedReturnFalseForMedicalCategory() {
        final Product p = Product.builder()
                .name("pills")
                .category(ProductCategory.MEDICAL)
                .quantity(1d)
                .build();
        
        assertThat(p.isTaxed()).isFalse();
    }
    
    @Test
    void isTaxedReturnFalseForBookCategory() {
        final Product p = Product.builder()
                .name("book")
                .category(ProductCategory.BOOK)
                .quantity(1d)
                .build();
        
        assertThat(p.isTaxed()).isFalse();
    }
    
    @Test
    void isTaxedReturnFalseForFoodCategory() {
        final Product p = Product.builder()
                .name("salad")
                .category(ProductCategory.FOOD)
                .quantity(1d)
                .build();
        
        assertThat(p.isTaxed()).isFalse();
    }
    
    @Test
    void isTaxedReturnTrueForOtherCategory() {
        final Product p = Product.builder()
                .name("pen")
                .category(ProductCategory.OTHER)
                .quantity(3d)
                .build();
        
        assertThat(p.isTaxed()).isTrue();
    }
    
    @Test
    void isTaxedReturnTrueForProductBuilder() {
        final Product p = Product.builder().build();
        
        assertThat(p.isTaxed()).isTrue();
    }
    
    @Test
    void getTotalPriceShouldReturnZeroWithDefaultValues() {
        final Product product = Product.builder().build();
        final double totalPrice = product.getTotalPrice();
        assertThat(totalPrice).isEqualTo(0.0);
    }
    
    @Test
    void getTotalPriceWithPositiveValues() {
        final Product product = Product.builder().price(5d).quantity(2d).build();
        final double totalPrice = product.getTotalPrice();
        assertThat(totalPrice).isEqualTo(10.0);
    }
    
    @Test
    void getTotalPriceWithNegativesValues() {
        final Product product = Product.builder().price(-5d).quantity(2d).build();
        final double totalPrice = product.getTotalPrice();
        assertThat(totalPrice).isEqualTo(-10.0);
    }
    
    @Test
    void shouldContainsImportedInReceiptLabel() {
        final Product product = Product.builder().isImported(true).build();
        final String label = product.getReceiptLabel();
        assertThat(label).contains("imported");
    }
    
    @Test
    void shouldNotContainsImportedInReceiptLabel() {
        final Product product = Product.builder().isImported(false).build();
        final String label = product.getReceiptLabel();
        assertThat(label).doesNotContain("imported");
    }
}
