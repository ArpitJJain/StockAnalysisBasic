package com.arpit.stock.input.service;

import com.arpit.stock.utility.UtilityClass;
import org.bson.Document;
import org.springframework.messaging.support.GenericMessage;

public class DataTransformer {
    public GenericMessage<Document> bseEquityDataToDocument(GenericMessage<String> data){
        String[] tokens = data.getPayload().split(",");
        if(tokens.length < 10 || "Security Code".equals(tokens[0])){
            return new GenericMessage<Document>(new org.bson.Document());
        }
        Document document = new org.bson.Document("loadDate", UtilityClass.TOP_DAY_DATE)
                .append("securityCode", tokens[0])
                .append("securityName", tokens[1])
                .append("securityGroup", tokens[2])
                .append("open", Float.valueOf(tokens[3]))
                .append("high", Float.valueOf(tokens[4]))
                .append("low", Float.valueOf(tokens[5]))
                .append("lowestTradingPrice", Float.valueOf(tokens[6]))
                .append("shareTradeCount", Long.valueOf(tokens[7]))
                .append("totalTurnOver", Float.valueOf(tokens[8]))
                .append("tradesCount", Long.valueOf(tokens[9]));
        return new GenericMessage(document,data.getHeaders());
    }

    public void print(GenericMessage data){
        System.out.println(data.getPayload());
    }
}