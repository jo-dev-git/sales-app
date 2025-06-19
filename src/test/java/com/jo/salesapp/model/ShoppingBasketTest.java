package com.jo.salesapp.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;


public class ShoppingBasketTest {
	
	@Test
    void shouldReturnCorrectReceipt() {
		
		final ShoppingBasket shopping = ShoppingBasket.builder().build();
		final Receipt receipt = shopping.generateReceipt();
    
        assertThat(receipt).isEqualTo(Receipt.builder().build());
    }
}
