package controller;

public class Div extends Operation implements  DivOperation{

    @Override
    public double div(Number digit1, Number digit2) {
        super.result = Double.parseDouble(digit1.toString()) / Double.parseDouble(digit2.toString());
        return result;
    }
}
