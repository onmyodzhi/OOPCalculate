package view;

import controller.Div;
import controller.Multiply;
import controller.Sum;
import model.FileLogger;
import model.LogInFile;

import java.time.LocalDateTime;
import java.util.Scanner;

public class CalculateView {
    protected StringBuilder operationForLogger;

    protected Scanner scanner = new Scanner(System.in);

    public void run() {
        this.operationForLogger = new StringBuilder();
        operationForLogger.append(LocalDateTime.now()).append(" - program launch \n");

        double firstDigit = massageForDigit("Enter first digit");

        double nextDigit;
        String arphOper;

        while (true) {
            this.operationForLogger.append(firstDigit);
            arphOper = massageForArephmeticOperation();
            switch (arphOper) {
                case "+" -> {
                    this.operationForLogger.append(" + ");

                    nextDigit = massageForDigit("Enter next digit");
                    this.operationForLogger.append(nextDigit);

                    Sum sum = new Sum();
                    sum.sum(firstDigit, nextDigit);
                    firstDigit = sum.getResult();

                    System.out.println("result: " + firstDigit);
                    this.operationForLogger.append(" = ").append(firstDigit);
                    this.operationForLogger.append('\n');
                }
                case "*" -> {
                    this.operationForLogger.append(" * ");

                    nextDigit = massageForDigit("Enter next digit");
                    this.operationForLogger.append(nextDigit);

                    Multiply multiply = new Multiply();
                    multiply.multi(firstDigit, nextDigit);
                    firstDigit = multiply.getResult();

                    System.out.println("result  " + firstDigit);
                    this.operationForLogger.append(" = ").append(firstDigit);
                    this.operationForLogger.append('\n');
                }
                case "/" -> {
                    this.operationForLogger.append(" / ");

                    nextDigit = massageForDigit("Enter next digit");
                    this.operationForLogger.append(nextDigit);

                    Div div = new Div();
                    div.div(firstDigit, nextDigit);
                    firstDigit = div.getResult();

                    System.out.println("result: " + firstDigit);
                    this.operationForLogger.append(" = ").append(firstDigit);
                    this.operationForLogger.append('\n');
                }
                case "!" ->{
                    System.out.println("TY 4 use my calculator");

                    FileLogger fileLogger = new FileLogger();
                    fileLogger.setLogInformation(operationForLogger.toString());
                    fileLogger.createFile("CalculateLogger.txt");
                    fileLogger.log();

                    scanner.close();
                    return;
                }
                default -> System.err.println("Invalid operation.\nPlease enter a valid operation.");
            }
        }
    }

    private String massageForArephmeticOperation() {

        System.out.println("Enter operation");
        String operation = scanner.next();
        scanner.nextLine();


        return operation;
    }

    private double massageForDigit(String massage) {
        System.out.println(massage);

        double digit = scanner.nextDouble();
        scanner.nextLine();
        
        return digit;
    }
}
