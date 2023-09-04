package com.bank.trading.domain;

public class StrategyConfig {
    private int signalId;
    private String strategyClass;

    public StrategyConfig() {
    }

    public StrategyConfig(int signalId, String strategyClass) {
        this.signalId = signalId;
        this.strategyClass = strategyClass;
    }

    public int getSignalId() {
        return signalId;
    }

    public void setSignalId(int signalId) {
        this.signalId = signalId;
    }

    public String getStrategyClass() {
        return strategyClass;
    }

    public void setStrategyClass(String strategyClass) {
        this.strategyClass = strategyClass;
    }
}
