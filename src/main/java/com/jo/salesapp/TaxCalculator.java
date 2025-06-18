package com.jo.salesapp;

import lombok.Builder;
import lombok.NonNull;
import model.Product;
import model.ProductCategory;

@Builder
public class TaxCalculator {
	
	private static final double BASIC_TAX = 0.10d;
    private static final double IMPORT_TAX = 0.05d;
    private static final double ROUNDING_VALUE = 0.05;
    
    public double calculate(@NonNull final Product product) {
        double tax = 0.0;
        
        if (product.isTaxed()) 
            tax += product.getTotalPrice() * BASIC_TAX;
        
        
        if (product.isImported())
            tax += product.getTotalPrice() * IMPORT_TAX;
        
        return roundUp(tax);
    }
    
    private double roundUp(final double value) {
        return Math.ceil(value / ROUNDING_VALUE) * ROUNDING_VALUE;
    }
}