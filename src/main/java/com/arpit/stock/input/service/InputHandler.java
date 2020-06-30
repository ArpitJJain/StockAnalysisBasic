package com.arpit.stock.input.service;

import com.arpit.stock.input.bakend.BackendLoadService;

public interface InputHandler {
    public void loadInput();
    public BackendLoadService getLoaderService();
}
