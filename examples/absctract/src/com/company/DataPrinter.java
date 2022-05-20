package com.company;

public class DataPrinter extends Printer {

    public static void main(String[] args) {
	      DataPrinter printer = new DataPrinter();
	      printer.print();
	      printer.sayHello();
    }

    @Override
    public void print() {
        System.out.println("Hello from override method");
    }
}
