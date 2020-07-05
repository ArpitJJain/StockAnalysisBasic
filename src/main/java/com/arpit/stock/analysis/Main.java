package com.arpit.stock.analysis;

import org.apache.log4j.PropertyConfigurator;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public void init(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("context.xml");

        try {
            TimeUnit.SECONDS.sleep(60);
//            context.close();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) throws IOException {
        Main main = new Main();
        PropertyConfigurator.configure("D:/dev/Ideaj/StockAnalysisBasic/src/main/resources/log4j.properties");
        main.init();
    }
}