package com.jo.salesapp.model;

import lombok.Builder;
import lombok.NonNull;
import lombok.Value;

@Value
@Builder
public class ReceiptItem {
	
	@NonNull
	@Builder.Default
    String label = "";
    
	@Builder.Default
    double price = 0d;
	
	@Builder.Default
    double quantity = 1d;
}