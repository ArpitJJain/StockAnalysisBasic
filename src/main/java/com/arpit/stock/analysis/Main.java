package com.arpit.stock.analysis;

import com.arpit.stock.input.service.FileInputHandler;
import com.arpit.stock.input.service.InputHandler;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class Main {

    InputHandler handler = new FileInputHandler();

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.handler.loadInput();

    }
}