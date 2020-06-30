package com.arpit.stock.input.bakend;

import com.arpit.stock.input.model.StockData;

public class ConsolBackendLoadService implements BackendLoadService {
    @Override
    public void load(StockData stockData) {
        System.out.println(stockData.getPrintableString());
    }
}
