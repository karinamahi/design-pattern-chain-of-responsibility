package com.khirata.chain.core;

public class Exchange<T> {

    private T data;
    private boolean stop = false;

    public Exchange(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public boolean shouldStop() {
        return stop;
    }

    public void stopProcessing() {
        this.stop = true;
    }
}
