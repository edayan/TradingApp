package com.bank.trading.strategies;

import com.bank.trading.algorithm.Algo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.verify;

public class SignalStrategy500Test {
    @Mock
    private Algo algo;

    private SignalStrategy500 signalStrategy500;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        signalStrategy500 = new SignalStrategy500();
    }

    @Test
    void execute_ShouldPerformStrategySteps() {
        signalStrategy500.execute(algo);

        // Verify that Algo methods were called in the correct order
        verify(algo).submitToMarket();
        verify(algo).reverse();
        verify(algo).doAlgo();
    }
}
