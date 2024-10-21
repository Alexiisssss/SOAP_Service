package org.example.soapclient.client;

import jakarta.xml.ws.Service;
import org.example.soapclient.DiscriminantException;
import org.example.soapclient.QuadraticEquationService;
import org.example.soapclient.SolveResponse;

import java.net.URL;
import javax.xml.namespace.QName;

public class QuadraticEquationClient {
    private final QuadraticEquationService service;

    public QuadraticEquationClient() throws Exception {
        URL wsdlURL = new URL("http://localhost:8083/QuadraticEquationService/QuadraticEquationService?wsdl");
        QName qname = new QName("http://example.org/", "QuadraticEquationServiceImplService");
        Service wsService = Service.create(wsdlURL, qname);
        service = wsService.getPort(QuadraticEquationService.class);
    }

    public SolveResponse solve(double a, double b, double c) throws DiscriminantException {
        return service.solveQuadraticEquation(a, b, c);
    }
}
