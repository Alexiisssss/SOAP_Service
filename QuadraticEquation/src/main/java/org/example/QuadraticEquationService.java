package org.example;

import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;

@WebService
public interface QuadraticEquationService {

    @WebMethod
    SolveResponse solveQuadraticEquation(
            @WebParam(name = "a") double a,
            @WebParam(name = "b") double b,
            @WebParam(name = "c") double c) throws DiscriminantException;
}
