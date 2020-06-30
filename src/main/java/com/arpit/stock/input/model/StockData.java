package com.arpit.stock.input.model;

import org.bson.Document;

public interface StockData {
    void print();
    String getPrintableString();
    Document getDocument();
}
