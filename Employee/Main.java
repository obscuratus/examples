package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Main {


  public static void main(String[] args) {
//    Employee employee1 = new Employee("Ivan", "Ivanov",
//                                  25, "AQA", 25000, POSITION.JUNIOR);
    EmployeeNamePrinter namePrinter = new EmployeeNamePrinter();
//    namePrinter.print( employee1 );
//
    EmployeeSalaryPrinter salaryPrinter = new EmployeeSalaryPrinter();
//    salaryPrinter.print( employee1 );
//
//    Employee employee2 = new Employee("", "", 16,
//                                "AQA", -50000, POSITION.MIDDLE);
//    namePrinter.print( employee2 );
//    salaryPrinter.print( employee2 );
//
//    Employee employee3 = new Employee("Gleb", "Popov", 25, "AQA", POSITION.SENIOR);
//    namePrinter.print( employee3 );
//    salaryPrinter.print( employee3 );
//

//    Employee[] employees = new Employee[5];
//    employees[0] = new Employee("Sasha", "Petrov", 30, "AQA", POSITION.JUNIOR);
//    employees[1] = new Employee("Igor", "Astakhov", 45, "QML/JS Develop", POSITION.SENIOR);
//
//
//    for ( Employee employee : employees ) {
//          if ( employee != null ) {
//               namePrinter.print(employee);
//               salaryPrinter.print(employee);
//          }
//    }

    List<Employee> employeeList = new ArrayList<>();
//    employeeList.add( new Employee("Sasha", "Petrov", 30, "AQA", POSITION.JUNIOR) );
//    employeeList.add( new Employee("Igor", "Astakhov", 45, "QML/JS Develop", POSITION.SENIOR) );
//    employeeList.add( new Employee("Gleb", "Popov", 25, "AQA", POSITION.MIDDLE) );
//    employeeList.add( new Employee("Ivan", "Ivanov", 25, "AQA", 25000, POSITION.JUNIOR));
//    employeeList.add( new Employee("Ivan", "Ivanov", 25, "AQA", 25000, POSITION.MIDDLE));

    addToList( new Employee("Sasha", "Petrov", 30, "AQA", POSITION.JUNIOR), employeeList );
    addToList( new Employee("Ivan", "Ivanov", 25, "AQA", 25000, POSITION.JUNIOR), employeeList );
    addToList( new Employee("Ivan", "Ivanov", 25, "AQA", 25000, POSITION.MIDDLE), employeeList );

    for ( Employee employee : employeeList ) {
          namePrinter.print(employee);
          salaryPrinter.print(employee);
    }

    System.out.println( new Employee("Sasha", "Petrov", 30, "AQA", POSITION.JUNIOR) );


    // [0] [1] [2] [3] [4] [5] [6] -> ArrayList
    // [0] [1] [2] -> new array
    // [0] [1] [2] [7] -> new array
    // [0] [1] [2] [7] [3] [4] [5] [6] -> new array
    // [0] <-> [1] <-> [2] <-> [3] - LinkedList
    // [0] <-> [1] <-> [4] <-> [2] <-> [3]

    List<Employee> employeeLinkedList = new LinkedList<>();
    addToList( new Employee("Sasha", "Petrov", 30, "AQA", POSITION.JUNIOR), employeeLinkedList );
    addToList( new Employee("Gleb", "Popov", 25, "AQA", POSITION.SENIOR), employeeLinkedList );
    addToList( new Employee("Ivan", "Petrov", 25, "AQA", 25000, POSITION.MIDDLE), employeeLinkedList );
    addToList( new Employee("Ivan", "Ivanov", 25, "AQA", 25000, POSITION.JUNIOR), employeeLinkedList );
    addToList( new Employee("Igor", "Astakhov", 45, "QML/JS Develop", POSITION.SENIOR), employeeLinkedList );

    for ( Employee employee : employeeList ) {
          namePrinter.print(employee);
          salaryPrinter.print(employee);
    }

    int juniorCount = 0;
    int middleCount = 0;
    int seniorCount = 0;

    // JUNIOR -> juniorCount
    // MIDDLE -> middleCount
    // SENIOR -> seniorCount

    // [_ -> _]
    // [ position, 1 ] если позиции такой в мапе нет
    // [ position, position.count++ ]

    // [JUNIOR, 1]
    // [JUNIOR, 2]

    Map<POSITION, Integer> counter = new HashMap<>();

    counter.get("First name");

    for ( Employee employee : employeeLinkedList ){
          if ( !counter.containsKey( employee.position ) ){
                counter.put( employee.position, 1 );
          } else {
                counter.put( employee.position, counter.get( employee.position ) + 1 );
          }
    }

    System.out.println("============================================");
    // [ [JUNIOR], [1] ] key value
    for ( Map.Entry<POSITION, Integer> entry : counter.entrySet() ){
          System.out.println(" POSITION: " + entry.getKey() + " counts " + entry.getValue() );
    }

//    counter.remove( POSITION.JUNIOR );

    System.out.println("===========================");
    System.out.println( "POSITION COUNTER: " + counter );
    System.out.println( "SENIOR COUNT: " + counter.get( POSITION.SENIOR ) );
    System.out.println( "SENIOR COUNT: " + counter.get( POSITION.SENIOR_POMIDOR ) );

    for ( Employee employee : employeeLinkedList ){
          if ( employee.position == POSITION.JUNIOR ){
               juniorCount++;
          } else if ( employee.position == POSITION.MIDDLE ){
               middleCount++;
          } else {
               seniorCount++;
          }

    }

    System.out.println("Junior count " + juniorCount );
    System.out.println("Middle count " + middleCount );
    System.out.println("Senior count " + seniorCount );

//    for ( Employee employee : employeeLinkedList ){
//          if ( employee.firstName.equals("Ivan") && employee.lastName.equals("Ivanov")) {
//               employeeLinkedList.remove( employee );
//          }
//    }
//
//    System.out.println( employeeLinkedList );


    // JUNIOR, SENIOR, MIDDLE, JUNIOR -> JUNIOR, JUNIOR, MIDDLE, SENIOR
    // [JUNIOR, SENIOR] -> [JUNIOR, SENIOR]
    // [SENIOR, MIDDLE] -> [MIDDLE, SENIOR]

    System.out.println("==========================================");
    System.out.println( "[BEFORE SORT: ]" + employeeLinkedList );

    for (int i = 0; i < employeeLinkedList.size() - 1 ; i++ ) {
         for (int j = i; j < employeeLinkedList.size(); j++ ) {
           if (employeeLinkedList.get(i).position.ordinal() > employeeLinkedList.get(j).position.ordinal()) {
                Collections.swap(employeeLinkedList, i, j);
           }
         }
    }

    System.out.println( "[SORTED: ]" + employeeLinkedList );

    System.out.println("===================================================");
    for ( Employee employee : employeeLinkedList ){
          employee.work();
    }

  }

  public static void addToList( Employee employee, List<Employee> employeeList ){
    if (!employeeList.contains(employee))
         employeeList.add(employee);
    else {
         System.out.println("Duplicate employee " + employee.firstName + " " + employee.lastName );
    }
   }

}
