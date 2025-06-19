package com.jo.salesapp;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.jo.salesapp.model.Product;
import com.jo.salesapp.model.ProductCategory;

public class TaxCalculatorTest {
	
	 private TaxCalculator calculator;
	    
	    @BeforeEach
	    void setUp() {
	        calculator = TaxCalculator.builder().build();
	    }

	 @Test
	    void calculateTaxForBookReturnZero() {
	       final Product product = Product.builder()
				.isImported(false)
				.category(ProductCategory.BOOK)
				.name("book")
				.quantity(1d)
				.price(12.49d)
				.build();
	        
	        double tax = calculator.calculate(product);
	        
	        assertEquals(0.0, tax , 0.01);
	    }
	 
	 @Test
	    void calculateTenPercentTaxForNonExemptProduct() {
	        final Product product = Product.builder()
				.isImported(false)
				.category(ProductCategory.OTHER)
				.name("music CD")
				.quantity(1d)
				.price(20.00d)
				.build();
	        
	        double tax = calculator.calculate(product);
	        
	        assertEquals(2.0, tax , 0.01);
	    }
	 
	 @Test
	    void calculateFivePercentTaxForImportedProduct() {
	        final Product product = Product.builder()
				.isImported(true)
				.category(ProductCategory.BOOK)
				.name("book")
				.quantity(1d)
				.price(12.49d)
				.build();
	        
	        double tax = calculator.calculate(product);
	        
	        assertEquals(0.65, tax , 0.01);
	    }
	 
	 @Test
	    void calculateCumulativeTaxForImportedAndTaxedProduct() {
	        final Product product = Product.builder()
				.isImported(true)
				.category(ProductCategory.OTHER)
				.name("pen")
				.quantity(1d)
				.price(10.00d)
				.build();
	        
	        double tax = calculator.calculate(product);
	        
	        assertEquals(1.5, tax , 0.01);
	    }
}
