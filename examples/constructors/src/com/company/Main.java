package com.company;

public class Main {

    Integer veryUsefulData = 0;

    public Main(){
        System.out.println("Hello from constructor with no args");
    }

    public Main(Integer veryUsefulData){
        this.veryUsefulData = veryUsefulData;
        System.out.println("Hello from constructor with one argument" );
    }

    public void print(){
        System.out.println("Useful data is " + this.veryUsefulData);
    }

    public static void main(String[] args) {
	      Main main = new Main();
	      main.print();
	      Main main2 = new Main(5);
	      main2.print();
    }
}
