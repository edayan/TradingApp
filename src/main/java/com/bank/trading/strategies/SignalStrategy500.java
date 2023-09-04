package com.bank.trading.strategies;

import com.bank.trading.algorithm.Algo;
import com.bank.trading.services.SignalStrategy;

public class SignalStrategy500 implements SignalStrategy {
    @Override
    public void execute(Algo algo) {
        System.out.println("Executing SignalStrategy500");
        algo.submitToMarket();
        algo.reverse();
        algo.doAlgo();
        System.out.println("---------");
    }
}
