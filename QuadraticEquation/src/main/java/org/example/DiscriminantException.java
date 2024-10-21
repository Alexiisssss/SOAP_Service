package org.example;


import jakarta.xml.ws.WebFault;

@WebFault(name = "DiscriminantException")
public class DiscriminantException extends Exception {
    private final SolveResponse faultInfo;


    public DiscriminantException(String message, SolveResponse faultInfo) {
        super(message);
        this.faultInfo = faultInfo;
    }

    public SolveResponse getFaultInfo() {
        return faultInfo;
    }
}
