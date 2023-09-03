package com.bank.trading.services;

import com.bank.trading.algorithm.Algo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;


public class SignalHandlerImplTest {
    @Mock
    private Algo mockedAlgo;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testHandleSignalCase1() {
        SignalHandlerImpl signalHandlerSpy = Mockito.spy(new SignalHandlerImpl());
        Mockito.doReturn(mockedAlgo).when(signalHandlerSpy).getAlgoInstance();

        signalHandlerSpy.handleSignal(1);

        verify(mockedAlgo).setUp();
        verify(mockedAlgo).setAlgoParam(1, 60);
        verify(mockedAlgo).performCalc();
        verify(mockedAlgo).submitToMarket();
        verify(mockedAlgo).doAlgo();

        verifyNoMoreInteractions(mockedAlgo);
    }

    @Test
    public void testHandleSignalCase2() {
        SignalHandlerImpl signalHandlerSpy = Mockito.spy(new SignalHandlerImpl());
        Mockito.doReturn(mockedAlgo).when(signalHandlerSpy).getAlgoInstance();

        signalHandlerSpy.handleSignal(2);

        verify(mockedAlgo).reverse();
        verify(mockedAlgo).setAlgoParam(1, 80);
        verify(mockedAlgo).submitToMarket();
        verify(mockedAlgo).doAlgo();

        verifyNoMoreInteractions(mockedAlgo);
    }

    @Test
    public void testHandleSignalCase3() {
        SignalHandlerImpl signalHandlerSpy = Mockito.spy(new SignalHandlerImpl());
        Mockito.doReturn(mockedAlgo).when(signalHandlerSpy).getAlgoInstance();

        signalHandlerSpy.handleSignal(3);

        verify(mockedAlgo).setAlgoParam(1, 90);
        verify(mockedAlgo).setAlgoParam(2, 15);
        verify(mockedAlgo).performCalc();
        verify(mockedAlgo).submitToMarket();
        verify(mockedAlgo).doAlgo();

        verifyNoMoreInteractions(mockedAlgo);
    }

    @Test
    public void testHandleSignalDefault() {
        SignalHandlerImpl signalHandlerSpy = Mockito.spy(new SignalHandlerImpl());
        Mockito.doReturn(mockedAlgo).when(signalHandlerSpy).getAlgoInstance();

        signalHandlerSpy.handleSignal(999); // Any non-matching signal

        verify(mockedAlgo).cancelTrades();
        verify(mockedAlgo).doAlgo();

        verifyNoMoreInteractions(mockedAlgo);
    }
}
