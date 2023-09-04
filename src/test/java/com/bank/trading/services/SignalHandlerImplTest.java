package com.bank.trading.services;

import com.bank.trading.algorithm.Algo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.verify;


public class SignalHandlerImplTest {

    @Mock
    private Algo mockedAlgo;

    @Mock
    private StrategyLoader strategyLoader;

    @Mock
    private SignalStrategy strategy;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void handleSignal_ValidSignal_ExecutesStrategy() {
        SignalHandlerImpl signalHandlerSpy = Mockito.spy(new SignalHandlerImpl(strategyLoader));
        Mockito.doReturn(mockedAlgo).when(signalHandlerSpy).getAlgoInstance();

        int signal = 1;
        Mockito.when(strategyLoader.getStrategy(signal)).thenReturn(strategy);

        signalHandlerSpy.handleSignal(signal);

        verify(strategyLoader).getStrategy(signal);
        verify(strategy).execute(mockedAlgo);
    }

    @Test
    void handleSignal_InvalidSignal_NoExecution() {
        SignalHandlerImpl signalHandlerSpy = Mockito.spy(new SignalHandlerImpl(strategyLoader));
        Mockito.doReturn(mockedAlgo).when(signalHandlerSpy).getAlgoInstance();
        int signal = 999; // Assuming this is an invalid signal
        Mockito.when(strategyLoader.getStrategy(signal)).thenReturn(null);

        signalHandlerSpy.handleSignal(signal);

        verify(strategyLoader).getStrategy(signal);
        // Verify that no strategy execution occurred
        Mockito.verifyNoInteractions(strategy);
    }
}
