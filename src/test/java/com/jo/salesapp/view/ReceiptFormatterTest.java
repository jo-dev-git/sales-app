package com.jo.salesapp.view;

import static org.assertj.core.api.Assertions.assertThat;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.jo.salesapp.model.Receipt;
import com.jo.salesapp.model.ReceiptItem;
import com.jo.salesapp.model.ReceiptItems;


public class ReceiptFormatterTest {
	
    private DecimalFormat df;
    private ReceiptFormatter formatter;
	    
	    @BeforeEach
	    void setUp() {
	    	df = new DecimalFormat("0.00");
	    	formatter = ReceiptFormatter.builder().build();
	    }
	
    
	    @Test
	    void getFormattedReceipt() {
	    	List<ReceiptItem> lines = new ArrayList<ReceiptItem>();
			lines.add(ReceiptItem.builder().label("Food cat").price(5d).build());
			
			
			final ReceiptItems items = ReceiptItems.builder()
					.items(lines)
					.build();
	       
	        final Receipt receipt = Receipt.builder()
	              .lines(items)
	              .totalCost(10.00d)
	              .totalTax(5.00d)
	              .build();
	        
	        final String result = formatter.formatReceipt(receipt);
	        System.out.println(result);
	        
	        assertThat(result).contains("Food cat : 5,00\n"
	        		+ "Sales Taxes: 5,00 Total: 10,00");
	    }
}