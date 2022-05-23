package com.company;
import java.util.Arrays;

public class DayPrinter {

    public enum Day {
        MONDAY(1),
        TUESDAY(2),
        WEDNESDAY(3),
        THURSDAY(4),
        FRIDAY(5),
        SATURDAY(6),
        SUNDAY(7);

        private final int dayNumber;

        Day(int dayNumber){
            this.dayNumber = dayNumber;
        }
    }



    public void printDay(Day day){
        System.out.println("This is " + day);
        System.out.println("This is " + day.dayNumber + " day in a week");
        System.out.println("Day ordinal " + day.ordinal());
    }

    public void printAllDays(){
        System.out.println("All days are: " + Arrays.toString( Day.values() ));
    }

    public static void main(String[] args) {
        DayPrinter dayPrinter = new DayPrinter();
        dayPrinter.printDay(Day.SUNDAY);
        dayPrinter.printAllDays();
    }
}