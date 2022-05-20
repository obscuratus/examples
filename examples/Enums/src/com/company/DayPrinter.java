package com.company;

import java.util.Arrays;

public class DayPrinter {

    public enum Day {
        SUNDAY, MONDAY, TUESDAY, WEDNESDAY,
        THURSDAY, FRIDAY, SATURDAY
    }

    public void printDay(Day day){
        System.out.println("This is " + day);
    }

    public void printAllDays(){
        System.out.println("All days are: " + Arrays.toString( Day.values() ));
    }

    public static void main(String[] args) {
        DayPrinter dayPrinter = new DayPrinter();
        dayPrinter.printDay(Day.SATURDAY);
        dayPrinter.printAllDays();
    }
}
