package com.bank.trading.domain;

public class SignalRequest {
    public SignalRequest(int signal) {
        this.signal = signal;
    }

    public SignalRequest() {
    }

    private int signal;

    public int getSignal() {
        return signal;
    }

    public void setSignal(int signal) {
        this.signal = signal;
    }
}
