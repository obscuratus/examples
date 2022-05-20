package com.company;

public class Main {

    public static void main(String[] args) {
	      Printer printer = new Printer() {
            @Override
            public void print() {
                System.out.println("Hello world from anonymous class");
            }
        };

	      printer.print();
    }
}
