package org.example;


import jakarta.jws.WebService;

@WebService(endpointInterface = "org.example.QuadraticEquationService")
public class QuadraticEquationServiceImpl implements QuadraticEquationService {

    public QuadraticEquationServiceImpl() {
    }
    @Override
    public SolveResponse solveQuadraticEquation(double a, double b, double c) throws DiscriminantException {
        SolveResponse response = new SolveResponse();
        String formula = a + "x^2 + " + b + "x + " + c + " =0";
        response.setFormula(formula);

        double D = b * b - 4 * a * c;
        response.setD(D);

        if (D < 0) {
            throw new DiscriminantException("Дискриминант отрицательный, реальных корней не существует", response);
        } else if (D == 0) {
            double x = -b / (2 * a);
            response.setX1(x);
        } else {
            double sqrtD = Math.sqrt(D);
            double x1 = (-b + sqrtD) / (2 * a);
            double x2 = (-b - sqrtD) / (2 * a);
            response.setX1(x1);
            response.setX2(x2);
        }
        return response;
    }
}
