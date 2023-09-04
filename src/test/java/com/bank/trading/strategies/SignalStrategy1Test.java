package com.bank.trading.strategies;

import com.bank.trading.algorithm.Algo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.verify;

public class SignalStrategy1Test {
    @Mock
    private Algo algo;

    private SignalStrategy1 signalStrategy1;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        signalStrategy1 = new SignalStrategy1();
    }

    @Test
    void execute_ShouldPerformStrategySteps() {
        signalStrategy1.execute(algo);

        // Verify that Algo methods were called in the correct order
        verify(algo).setUp();
        verify(algo).setAlgoParam(1, 60);
        verify(algo).performCalc();
        verify(algo).submitToMarket();
        verify(algo).doAlgo();
    }
}
