package com.example.mymathcalc;

public class MathCalc {
    String firstNum;
    String secondNum;
    String operator;


    public static String operation(String firstNum, String secondNum, String operator) {
        double result = 0.0;
        switch (operator) {
            case "+":
                result = Double.parseDouble(firstNum) + Double.parseDouble(secondNum);
                break;
            case "-":
                result = Double.parseDouble(firstNum) - Double.parseDouble(secondNum);
                break;
            case "/":
                if (!secondNum.matches("^-?[0]\\d*(\\.\\d+)?$")){
                    result = Double.parseDouble(firstNum) / Double.parseDouble(secondNum);
                } else { return "NaN";}
                break;
            case "*":
                result = Double.parseDouble(firstNum) * Double.parseDouble(secondNum);
                break;
        }
        return Double.toString(result);
    }
}

