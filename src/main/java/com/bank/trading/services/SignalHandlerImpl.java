package com.bank.trading.services;

import com.bank.trading.algorithm.Algo;
import org.springframework.stereotype.Component;

@Component
public class SignalHandlerImpl implements SignalHandler {

    private final StrategyLoader strategyLoader;

    public SignalHandlerImpl(StrategyLoader strategyLoader) {
        this.strategyLoader = strategyLoader;
    }

    @Override
    public void handleSignal(final int signal) {
        SignalStrategy strategy = strategyLoader.getStrategy(signal);
        Algo algo = getAlgoInstance();
        if (strategy != null) {
            strategy.execute(algo);
        } else {
            System.out.println("Executing default strategy");
            algo.cancelTrades();
            algo.doAlgo();
            System.out.println("---------");
        }
    }

    protected Algo getAlgoInstance() {
        return new Algo();
    }

}
