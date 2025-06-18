package com.jo.salesapp;

import java.util.List;

import data.Datas;
import lombok.NonNull;
import model.Product;

public class Main {

	public static void main(String[] args) {
		final SalesApplication app = SalesApplication.builder()
				.formatter(ReceiptFormatter.builder().build())
				.build();
		
		final Datas datas = Datas.builder().build();
       
		displayResultConsole(app, datas.getFirstBasket());
		displayResultConsole(app, datas.getSecondBasket());
		displayResultConsole(app, datas.getThirdBasket());
  	}
	
	private static void displayResultConsole(@NonNull final SalesApplication app, @NonNull final List<Product> products) {
		String result = app.processBasket(products);
        System.out.println("\nReceipt:\n" + result);
	}
}
