package com.jo.salesapp.controller;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import data.Datas;

public class SalesControllerTest {

	private SalesController controller;
	private Datas datas;

	@BeforeEach
	void setUp() {
		controller = SalesController.builder().build();
		datas = Datas.builder().build();
	}

	@Test
	void processFirstBasket() {
		String result = controller.processBasket(datas.getFirstBasket());

		assertTrue(result.contains("Sales Taxes: 1,50 Total: 29,83"));
	}

	@Test
	void processSecondBasket() {
		String result = controller.processBasket(datas.getSecondBasket());

		assertTrue(result.contains("Sales Taxes: 7,65 Total: 65,15"));
	}

	@Test
	void processThirdBasket() {
		String result = controller.processBasket(datas.getThirdBasket());

		assertTrue(result.contains("Sales Taxes: 6,70 Total: 74,68"));
	}
}
