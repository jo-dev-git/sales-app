package data;

import java.util.ArrayList;
import java.util.List;

import lombok.Builder;
import model.Product;
import model.ProductCategory;


//Can use Factory, objects input, String...
@Builder
public class Datas {

	
	public List<Product> getFirstBasket() {
		final List<Product> products = new ArrayList<>();
		products.add(Product.builder()
				.isImported(false)
				.category(ProductCategory.BOOK)
				.name("book")
				.quantity(1d)
				.price(12.49d)
				.build());
		
		products.add(Product.builder()
				.isImported(false)
				.category(ProductCategory.DEFAULT)
				.name("music CD")
				.quantity(1d)
				.price(14.99d)
				.build());
		
		products.add(Product.builder()
				.isImported(false)
				.category(ProductCategory.FOOD)
				.name("chocolate bar")
				.quantity(1d)
				.price(0.85d)
				.build());
		return products;

	}
	
	public List<Product> getSecondBasket() {
		final List<Product> products = new ArrayList<>();
		products.add(Product.builder()
				.isImported(true)
				.category(ProductCategory.FOOD)
				.name("box of chocolates")
				.quantity(1d)
				.price(10.00d)
				.build());
		
		products.add(Product.builder()
				.isImported(true)
				.category(ProductCategory.DEFAULT)
				.name("bottle of perfume")
				.quantity(1d)
				.price(47.50d)
				.build());
		
		return products;
	}
	
	public List<Product> getThirdBasket() {
		final List<Product> products = new ArrayList<>();
		products.add(Product.builder()
				.isImported(true)
				.category(ProductCategory.DEFAULT)
				.name("bottle of perfume")
				.quantity(1d)
				.price(27.99d)
				.build());
		
		products.add(Product.builder()
				.isImported(false)
				.category(ProductCategory.DEFAULT)
				.name("bottle of perfume")
				.quantity(1d)
				.price(18.99d)
				.build());
		
		products.add(Product.builder()
				.isImported(false)
				.category(ProductCategory.MEDICAL)
				.name("packet of headache pills")
				.quantity(1d)
				.price(9.75d)
				.build());
		
		products.add(Product.builder()
				.isImported(true)
				.category(ProductCategory.FOOD)
				.name("box of chocolates")
				.quantity(1d)
				.price(11.25d)
				.build());
		
		return products;
	}
}
