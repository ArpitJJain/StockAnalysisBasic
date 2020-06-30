package com.arpit.stock.input.model;

import org.bson.Document;

import static com.arpit.stock.utility.UtilityClass.*;

public strictfp class BSEEquityData implements StockData {

    /*record BSEEquityData(String securityCode, String securityName, String securityGroup, String open, String high, String low, String lowestTradingPrice, String shareTradeCount, String totalTurnOver, String tradesCount) {
    }*/
    String loadDate;
    String securityCode;
    String securityName;
    String securityGroup;
    Float open;
    Float high;
    Float low;
    Float lowestTradingPrice;
    Long shareTradeCount;
    Float totalTurnOver;
    Long tradesCount;

    public BSEEquityData(String securityCode, String securityName, String securityGroup, Float open, Float high, Float low, Float lowestTradingPrice, Long shareTradeCount, Float totalTurnOver, Long tradesCount) {
        this.loadDate = getStringValue(TOP_DAY_DATE);
        this.securityCode = getStringValue(securityCode);
        this.securityName = getStringValue(securityName);
        this.securityGroup = getStringValue(securityGroup);
        this.open = open;
        this.high = high;
        this.low = low;
        this.lowestTradingPrice = lowestTradingPrice;
        this.shareTradeCount = shareTradeCount;
        this.totalTurnOver = totalTurnOver;
        this.tradesCount = tradesCount;
    }

    public String getLoadDate() {
        return loadDate;
    }

    public String getSecurityCode() {
        return securityCode;
    }

    public String getSecurityName() {
        return securityName;
    }

    public String getSecurityGroup() {
        return securityGroup;
    }

    public Float getOpen() {
        return open;
    }

    public Float getHigh() {
        return high;
    }

    public Float getLow() {
        return low;
    }

    public Float getLowestTradingPrice() {
        return lowestTradingPrice;
    }

    public Long getShareTradeCount() {
        return shareTradeCount;
    }

    public Float getTotalTurnOver() {
        return totalTurnOver;
    }

    public Long getTradesCount() {
        return tradesCount;
    }

    @Override
    public String toString() {
        return "BSEEquityData{" +
                "loadDate=" + loadDate +
                ", securityCode='" + securityCode + '\'' +
                ", securityName='" + securityName + '\'' +
                ", securityGroup='" + securityGroup + '\'' +
                ", open=" + open +
                ", high=" + high +
                ", low=" + low +
                ", lowestTradingPrice=" + lowestTradingPrice +
                ", shareTradeCount=" + shareTradeCount +
                ", totalTurnOver=" + totalTurnOver +
                ", tradesCount=" + tradesCount +
                '}';
    }

    @Override
    public void print() {
        System.out.println();
    }

    @Override
    public String getPrintableString() {
        return toString();
    }

    @Override
    public Document getDocument() {
        Document document = new Document("loadDate", loadDate)
                .append("securityCode", securityCode)
                .append("securityName", securityName)
                .append("securityGroup", securityGroup)
                .append("open", open)
                .append("high", high)
                .append("low", low)
                .append("lowestTradingPrice", lowestTradingPrice)
                .append("shareTradeCount", shareTradeCount)
                .append("totalTurnOver", totalTurnOver)
                .append("tradesCount", tradesCount);
        return document;
    }
}