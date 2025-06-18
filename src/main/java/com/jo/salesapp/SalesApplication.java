package com.jo.salesapp;

import java.util.List;

import lombok.Builder;
import lombok.NonNull;
import model.Product;
import model.Receipt;
import model.ShoppingBasket;

@Builder
public class SalesApplication {
	
    private final ReceiptFormatter formatter = ReceiptFormatter.builder().build();
    
    public String processBasket(@NonNull final List<Product> products) {
        final ShoppingBasket basket = ShoppingBasket.builder().items(products).build();
        final Receipt receipt = basket.generateReceipt();
        return formatter.formatReceipt(receipt);
    }
}