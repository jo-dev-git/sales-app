package com.jo.salesapp.model;

import java.util.ArrayList;
import java.util.List;

import com.jo.salesapp.TaxCalculator;

import lombok.Builder;
import lombok.NonNull;
import lombok.Value;

@Value
@Builder
public class ShoppingBasket {
	@NonNull
	@Builder.Default
    List<Product> items = new ArrayList<>();
	
	@NonNull
	@Builder.Default
    TaxCalculator taxCalculator = TaxCalculator.builder().build();
    
    
	@NonNull
    public Receipt generateReceipt() {
        final List<ReceiptItem> lines = new ArrayList<>();
        double totalTax = 0.0;
        double totalCost = 0.0;
        
        for (final Product product : items) {
            final double tax = taxCalculator.calculate(product);
            final double priceWithTax = product.getTotalPrice() + tax;
            
            lines.add(ReceiptItem.builder()
            		.label(product.getReceiptLabel())
            		.price(priceWithTax)
            		.build());
            
            totalTax += tax;
            totalCost += priceWithTax;
        }
        
        return Receipt.builder()
        		.totalCost(totalCost)
        		.lines(ReceiptItems.builder().items(lines).build())
        		.totalTax(totalTax)
        		.build();
    }
}