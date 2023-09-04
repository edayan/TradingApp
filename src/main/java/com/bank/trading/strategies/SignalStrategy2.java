package com.bank.trading.strategies;

import com.bank.trading.algorithm.Algo;
import com.bank.trading.services.SignalStrategy;

public class SignalStrategy2 implements SignalStrategy {

    @Override
    public void execute(Algo algo) {
        System.out.println("Executing SignalStrategy2");
        algo.reverse();
        algo.setAlgoParam(1, 80);
        algo.submitToMarket();
        algo.doAlgo();
        System.out.println("---------");
    }
}
