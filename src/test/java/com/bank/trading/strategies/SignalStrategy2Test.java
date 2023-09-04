package com.bank.trading.strategies;

import com.bank.trading.algorithm.Algo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.verify;

public class SignalStrategy2Test {
    @Mock
    private Algo algo;

    private SignalStrategy2 signalStrategy2;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        signalStrategy2 = new SignalStrategy2();
    }

    @Test
    void execute_ShouldPerformStrategySteps() {
        signalStrategy2.execute(algo);

        // Verify that Algo methods were called in the correct order
        verify(algo).reverse();
        verify(algo).setAlgoParam(1, 80);
        verify(algo).submitToMarket();
        verify(algo).doAlgo();
    }
}
