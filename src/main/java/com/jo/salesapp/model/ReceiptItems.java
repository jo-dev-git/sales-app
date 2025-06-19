package com.jo.salesapp.model;

import java.util.ArrayList;
import java.util.List;

import lombok.Builder;
import lombok.NonNull;
import lombok.Value;

@Value
@Builder
public class ReceiptItems {
	
	@NonNull
	@Builder.Default
	List<ReceiptItem> items = new ArrayList<ReceiptItem>();
}
