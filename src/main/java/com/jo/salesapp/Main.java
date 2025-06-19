package com.jo.salesapp;

import java.util.List;

import com.jo.salesapp.controller.SalesController;
import com.jo.salesapp.model.Product;

import data.Datas;
import lombok.NonNull;

public class Main {

	public static void main(String[] args) {
		final SalesController app = SalesController.builder().build();
		
		final Datas datas = Datas.builder().build();
       
		displayResultConsole(app, datas.getFirstBasket());
		displayResultConsole(app, datas.getSecondBasket());
		displayResultConsole(app, datas.getThirdBasket());
  	}
	
	private static void displayResultConsole(@NonNull final SalesController app, @NonNull final List<Product> products) {
		String result = app.processBasket(products);
        System.out.println("\nReceipt:\n" + result);
	}
}
