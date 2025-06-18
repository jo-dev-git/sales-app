package com.jo.salesapp;

import java.text.DecimalFormat;

import lombok.Builder;
import lombok.NonNull;
import model.Receipt;
import model.ReceiptItem;

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
        stringBuilder.append("Sales Taxes: ")
          .append(df.format(receipt.getTotalTax()))
          .append(" Total: ")
          .append(df.format(receipt.getTotalCost()));
        
        return stringBuilder.toString();
    }
}