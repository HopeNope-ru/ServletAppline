package ru.appline;

import java.io.PrintWriter;
import java.io.Serializable;

public class Calculator implements Serializable {
  private double  x, y;
  private String  operation;

  public Calculator(double x, double y, String operation) {
    this.x = x;
    this.y = y;
    this.operation = operation;
  }

  public double calculate() {
    // Надежда, что будет верная операция :)
    switch (operation) {
      case "+":
        return x + y;
      case "-":
        return x - y;
      case "*":
        return x * y;
      case "/":
        return x / y;
    }
    return 0.0;
  }
}
