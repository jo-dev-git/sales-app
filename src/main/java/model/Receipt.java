package model;

import java.util.List;

import lombok.Builder;
import lombok.NonNull;
import lombok.Value;

@Builder
@Value
public class Receipt {
	
	@NonNull
	@Builder.Default
    ReceiptItems lines = ReceiptItems.builder().build();
	
	@Builder.Default
    double totalTax = 0d;
	
	@Builder.Default
    double totalCost = 0d;
	
	@NonNull
	public List<ReceiptItem> getReceiptLines() {
		return lines.getItems();
	}
}