package com.bank.trading.services;

import com.bank.trading.algorithm.Algo;
import org.springframework.stereotype.Component;

@Component
public class SignalHandlerImpl implements SignalHandler {
    @Override
    public void handleSignal(int signal) {
        Algo algo = getAlgoInstance();
        switch (signal) {
            case 1:
                algo.setUp();
                algo.setAlgoParam(1, 60);
                algo.performCalc();
                algo.submitToMarket();
                break;
            case 2:
                algo.reverse();
                algo.setAlgoParam(1, 80);
                algo.submitToMarket();
                break;
            case 3:
                algo.setAlgoParam(1, 90);
                algo.setAlgoParam(2, 15);
                algo.performCalc();
                algo.submitToMarket();
                break;
            default:
                algo.cancelTrades();
                break;
        }
        algo.doAlgo();
    }

    protected Algo getAlgoInstance() {
        return new Algo();
    }
}
