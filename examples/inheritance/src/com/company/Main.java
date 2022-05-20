package com.company;

public class Main {

    public static void main(String[] args) {
	      ExtendedCalc extendedCalc = new ExtendedCalc(10, 5);
	      extendedCalc.mul();
	      extendedCalc.printResult();
	      extendedCalc.divide();
	      extendedCalc.printResult();

	      Calc calc = new Calc(6,2);
	      calc.sum();
	      calc.printResult();
	      calc.divide();
	      calc.printResult();
    }
}
