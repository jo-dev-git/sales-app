package com.jo.salesapp.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

public class ReceiptTest {
	
	@Test
    void getEmptyLinesOnReceiptBuilder() {
		final ReceiptItems items = ReceiptItems.builder().build();
        final Receipt receipt = Receipt.builder()
        		.lines(items)
                .build();
        
        assertThat(receipt.getReceiptLines()).isEmpty();
    }
	
	@Test
    void getAllReceiptLines() {
		
		List<ReceiptItem> lines = new ArrayList<ReceiptItem>();
		lines.add(ReceiptItem.builder().label("food cat").price(5d).build());
		
		
		final ReceiptItems items = ReceiptItems.builder()
				.items(lines)
				.build();
        final Receipt receipt = Receipt.builder()
        		.lines(items)
                .build();
        
        assertThat(receipt.getReceiptLines()).containsAll(lines);
    }

}
