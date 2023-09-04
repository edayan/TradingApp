package com.bank.trading.strategies;

import com.bank.trading.algorithm.Algo;
import com.bank.trading.services.SignalStrategy;

public class SignalStrategy1 implements SignalStrategy {

    @Override
    public void execute(Algo algo) {
        System.out.println("Executing SignalStrategy1");
        algo.setUp();
        algo.setAlgoParam(1, 60);
        algo.performCalc();
        algo.submitToMarket();
        algo.doAlgo();
        System.out.println("---------");
    }
}
