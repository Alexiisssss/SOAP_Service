package org.example.soapclient.controller;

import org.example.soapclient.DiscriminantException;
import org.example.soapclient.client.QuadraticEquationClient;
import org.example.soapclient.SolveResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/calc")
public class CalculatorController {
    private final QuadraticEquationClient client;

    public CalculatorController() throws Exception {
        this.client = new QuadraticEquationClient();
    }

    @GetMapping
    public SolveResponse calculate(
            @RequestParam double a,
            @RequestParam double b,
            @RequestParam double c) throws DiscriminantException, DiscriminantException {
        return client.solve(a, b, c);
    }
}
