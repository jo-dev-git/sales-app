package com.jo.salesapp;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NonNull;
import model.Product;
import model.Receipt;
import model.ShoppingBasket;

@Builder
@AllArgsConstructor
public class SalesApplication {
	
    private final ReceiptFormatter formatter;
    
    public String processBasket(@NonNull final List<Product> products) {
        final ShoppingBasket basket = ShoppingBasket.builder().items(products).build();
        final Receipt receipt = basket.generateReceipt();
        return formatter.formatReceipt(receipt);
    }
}