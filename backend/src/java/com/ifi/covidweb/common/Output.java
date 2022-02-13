package com.ifi.covidweb.common;

public class Output {
    private String message;
    private int result = 1;

    public Output() {
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }
}
