package com.bank.trading.controllers;

import com.bank.trading.domain.SignalRequest;
import com.bank.trading.services.SignalHandler;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;

public class SignalControllerTest {

    private SignalController signalController;

    @Mock
    private SignalHandler signalHandler;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        signalController = new SignalController(signalHandler);
    }

    @Test
    public void testHandleSignal() {
        int signalValue = 123;
        SignalRequest signalRequest = new SignalRequest();
        signalRequest.setSignal(signalValue);

        ResponseEntity<String> response = signalController.handleSignal(signalRequest);

        // Assert
        assertEquals(ResponseEntity.ok("Signal handled successfully"), response);
        verify(signalHandler).handleSignal(signalValue);
    }

}
