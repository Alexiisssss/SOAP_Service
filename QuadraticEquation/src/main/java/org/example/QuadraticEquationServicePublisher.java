package org.example;

import jakarta.xml.ws.Endpoint;

public class QuadraticEquationServicePublisher {
    public static void main(String[] args) {
        Endpoint.publish("http://localhost:8080/QuadraticEquationService", new QuadraticEquationServiceImpl());
        System.out.println("Service is published at http://localhost:8080/QuadraticEquationService");
    }
}
