package model;

import lombok.Builder;
import lombok.NonNull;
import lombok.Value;

@Value
@Builder
public class Product {
	
	@NonNull
	@Builder.Default
	String name = "";
	
	@Builder.Default
	double quantity = 1d;
	
	@Builder.Default
	double price = 0d;
	
	@Builder.Default
	boolean isImported = false;
	
	@NonNull
	@Builder.Default
	ProductCategory category = ProductCategory.DEFAULT;
	
	public double getTotalPrice() {
		return price * quantity;
	}
	
	public String getReceiptLabel() { 
        final StringBuilder stringBuilder = new StringBuilder();

        stringBuilder
		 .append(format(quantity))
         .append("  ")
         .append(isImported()? "imported " : "")
         .append(name);
        
        return stringBuilder.toString();
	}
	
    public boolean isTaxed() {
        return category == ProductCategory.DEFAULT;
    }
	
   public String format(double value) {
        if(value == (long)value) 
             return String.format("%d", (long) value);
        else
             return String.format("%s", value);
   }
}
