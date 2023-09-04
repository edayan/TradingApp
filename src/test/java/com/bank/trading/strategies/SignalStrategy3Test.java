package com.bank.trading.strategies;

import com.bank.trading.algorithm.Algo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.verify;

public class SignalStrategy3Test {
    @Mock
    private Algo algo;

    private SignalStrategy3 signalStrategy3;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        signalStrategy3 = new SignalStrategy3();
    }

    @Test
    void execute_ShouldPerformStrategySteps() {
        signalStrategy3.execute(algo);

        // Verify that Algo methods were called in the correct order
        verify(algo).setAlgoParam(1, 90);
        verify(algo).setAlgoParam(2, 15);
        verify(algo).performCalc();
        verify(algo).submitToMarket();
        verify(algo).doAlgo();
    }
}
