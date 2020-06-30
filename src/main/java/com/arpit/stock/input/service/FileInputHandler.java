package com.arpit.stock.input.service;

import com.arpit.stock.input.bakend.BackendLoadService;
import com.arpit.stock.input.bakend.MongoBackendLoadService;
import com.arpit.stock.input.model.BSEEquityData;
import static com.arpit.stock.utility.UtilityClass.*;
import java.io.*;
import java.util.Scanner;

public class FileInputHandler implements InputHandler{

    @Override
    public void loadInput() {
        int headerCount = 1;
        File file = new File("C:\\Users\\arpit\\Downloads\\MarketWatch_"+TOP_DAY_FILE_SUFFIX+".csv");
        if(!file.exists()){
            System.out.println("File doesnt exist :" + file.getAbsolutePath());
        }
        FileReader fr = null;
        try {
            fr = new FileReader(file);
        } catch (FileNotFoundException e) {
            System.out.println("File doesnt exist");
        }
        Scanner scanner;
        int recordCount = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            scanner = new Scanner(br);
            while (scanner.hasNextLine()) {
                if (recordCount < headerCount) {
                    scanner.nextLine();
                    recordCount++;
                    continue;
                }
                String line = scanner.nextLine();
                if(line == null || line.isEmpty()){
                    continue;
                }
                String[] tokens = line.split(",");
                if(tokens.length < 10){
                    continue;
                }
                String securityCode = tokens[0];
                String securityName = tokens[1];
                String securityGroup = tokens[2];
                Float open = Float.valueOf(tokens[3]);
                Float high = Float.valueOf(tokens[4]);
                Float low = Float.valueOf(tokens[5]);
                Float lowestTradingPrice = Float.valueOf(tokens[6]);
                Long shareTradeCount = Long.valueOf(tokens[7]);
                Float totalTurnOver = Float.valueOf(tokens[8]);
                Long tradesCount = Long.valueOf(tokens[9]);
                BSEEquityData data = new BSEEquityData(securityCode, securityName, securityGroup, open, high, low, lowestTradingPrice, shareTradeCount, totalTurnOver, tradesCount);
                getLoaderService().load(data);
                recordCount++;
            }
        }catch(IOException e){

        }
        System.out.println(recordCount);
    }

    @Override
    public BackendLoadService getLoaderService() {
        return MongoBackendLoadService.getInstance();
    }
}
