package com.jo.salesapp.view;

import java.text.DecimalFormat;

import com.jo.salesapp.model.Receipt;
import com.jo.salesapp.model.ReceiptItem;

import lombok.Builder;
import lombok.NonNull;

@Builder
public class ReceiptFormatter {
	
    private final DecimalFormat df = new DecimalFormat("0.00");
    
    public String formatReceipt(@NonNull final Receipt receipt) {
        StringBuilder stringBuilder = new StringBuilder();
        
        //LINES
        for (final ReceiptItem item : receipt.getReceiptLines()) {
        	stringBuilder
        	  .append(item.getLabel())
              .append(" : ")
              .append(df.format(item.getPrice()))
              .append("\n");
        }
        
        //TOTAL TAX AND COST
        stringBuilder
          .append("Sales Taxes: ")
          .append(df.format(receipt.getTotalTax()))
          .append(" Total: ")
          .append(df.format(receipt.getTotalCost()));
        
        return stringBuilder.toString();
    }
}