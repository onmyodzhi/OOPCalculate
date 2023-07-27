package controller;

public class Multiply extends Operation implements MultiplyOperation{


    @Override
    public double multi(Number digit1, Number digit2) {
        super.result = Double.parseDouble(digit1.toString()) * Double.parseDouble(digit2.toString());
        return result;
    }
}
