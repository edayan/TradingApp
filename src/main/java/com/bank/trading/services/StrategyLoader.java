package com.bank.trading.services;

public interface StrategyLoader {
    SignalStrategy getStrategy(int signalId);
}
