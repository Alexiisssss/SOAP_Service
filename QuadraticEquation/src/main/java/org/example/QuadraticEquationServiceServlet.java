package org.example;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.xml.ws.Endpoint;


public class QuadraticEquationServiceServlet extends HttpServlet {
    private Endpoint endpoint;

    @Override
    public void init() throws ServletException {
        super.init();
        String url = "http://localhost:8083/QuadraticEquationService/QuadraticEquationService";
        endpoint = Endpoint.publish(url, new QuadraticEquationServiceImpl());
        System.out.println("Service is published at http://localhost:8083/QuadraticEquationService/QuadraticEquationService");
    }

    @Override
    public void destroy() {
        if (endpoint != null) {
            endpoint.stop();
        }
        super.destroy();
    }
}
