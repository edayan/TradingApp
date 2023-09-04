package com.bank.trading.controllers;

import com.bank.trading.domain.SignalRequest;
import com.bank.trading.services.SignalHandler;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/signals")
public class SignalController {
    private final SignalHandler signalHandler;

    public SignalController(SignalHandler signalHandler) {
        this.signalHandler = signalHandler;
    }


    @PostMapping("/handle")
    public ResponseEntity<String> handleSignal(@RequestBody SignalRequest signalRequest) {
        signalHandler.handleSignal(signalRequest.getSignal());
        return ResponseEntity.ok("Signal handled successfully");
    }
}
