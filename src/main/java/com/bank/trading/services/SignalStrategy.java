package com.bank.trading.services;

import com.bank.trading.algorithm.Algo;

public interface SignalStrategy {

    void execute(Algo algo);
}
