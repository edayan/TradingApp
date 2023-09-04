package com.bank.trading.strategies;

import com.bank.trading.algorithm.Algo;
import com.bank.trading.services.SignalStrategy;

public class SignalStrategy3 implements SignalStrategy {

    @Override
    public void execute(Algo algo) {
        System.out.println("Executing SignalStrategy3");
        algo.setAlgoParam(1, 90);
        algo.setAlgoParam(2, 15);
        algo.performCalc();
        algo.submitToMarket();
        algo.doAlgo();
        System.out.println("---------");
    }
}
