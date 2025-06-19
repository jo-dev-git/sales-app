package com.jo.salesapp.controller;

import java.util.List;

import com.jo.salesapp.model.Product;
import com.jo.salesapp.model.Receipt;
import com.jo.salesapp.model.ShoppingBasket;
import com.jo.salesapp.view.ReceiptFormatter;

import lombok.Builder;
import lombok.NonNull;

@Builder
public class SalesController {
	
    private final ReceiptFormatter formatter = ReceiptFormatter.builder().build();
    
    public String processBasket(@NonNull final List<Product> products) {
        final ShoppingBasket basket = ShoppingBasket.builder().items(products).build();
        final Receipt receipt = basket.generateReceipt();
        return formatter.formatReceipt(receipt);
    }
}