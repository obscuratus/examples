package com.company;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class Runner {

  public static void main(String[] args) {
    List<Employee> employeeLinkedList = new LinkedList<>();
    addToList( new Employee("Sasha", "Petrov", 30, "AQA", POSITION.JUNIOR), employeeLinkedList );
    addToList( new Employee("Gleb", "Popov", 25, "AQA", POSITION.SENIOR), employeeLinkedList );
    addToList( new Employee("Ivan", "Petrov", 25, "AQA", 25000, POSITION.MIDDLE), employeeLinkedList );
    addToList( new Employee("Ivan", "Ivanov", 25, "AQA", 25000, POSITION.JUNIOR), employeeLinkedList );
    addToList( new Employee("Igor", "Astakhov", 45, "QML/JS Develop", POSITION.SENIOR), employeeLinkedList );

//    List<EmployeeThread> threads = new ArrayList<>();
//    for ( Employee employee : employeeLinkedList ){
//          threads.add( new EmployeeThread( employee ) );
//    }
//
//    for ( EmployeeThread thread : threads ){
//          thread.start();
////          try {
////            if ( thread.getEmployee().firstName.equals("Sasha") && thread.getEmployee().lastName.equals("Petrov")) {
////                 thread.join();
////            }
////          } catch (InterruptedException e) {
////            e.printStackTrace();
////          }
//    }
//
//    // 1..100
//    // 5 сотрудников
//    // 21 22 23 24
//    // 1..20 21..40 41..60 61..80 81..100
//    // 1 employee -> work(1..20)
//    // 2 employee -> work(21..40)
//
//
//
//    List<EmployeeCallable> callables = new ArrayList<>();
//    for ( Employee employee : employeeLinkedList ){
//          callables.add( new EmployeeCallable( employee ) );
//    }
//
//    List< FutureTask<Integer> > futureTasks = new ArrayList<>();
//    for ( EmployeeCallable callable : callables ){
//          FutureTask<Integer> futureTask = new FutureTask<>( callable );
//          futureTasks.add( futureTask );
//          Thread thread = new Thread( futureTask );
//          thread.start();
//    }
//
//    for ( FutureTask<Integer> futureTask : futureTasks ){
//           try {
//             System.out.println( futureTask.get() );
//           } catch (InterruptedException e) {
//             e.printStackTrace();
//           } catch (ExecutionException e) {
//             e.printStackTrace();
//           }
//    }

//    ExecutorService service = Executors.newFixedThreadPool( 2 );
//    for ( Employee employee : employeeLinkedList ) {
//          service.execute( employee::work );
//    }
//
//    service.shutdown();

    ExecutorService callableService = Executors.newFixedThreadPool(2 ); // создаем пул трэдов
    List< Future<Integer> > futureList = new ArrayList<>(); // лист для БУДУЩИХ результатов
    for ( Employee employee : employeeLinkedList ){ // бежим по списку сотрудников
          Future<Integer> future = callableService.submit( employee::compute ); // отдаем сервису наших сотрудников, которые compute()
          futureList.add( future ); // вносим в лист объекты БУДУЩИХ результатов
    }

    for ( Future<Integer> future : futureList ){
            try {

              System.out.println( future.get() );

            } catch (InterruptedException e) {
              e.printStackTrace();
            } catch (ExecutionException e) {
              e.printStackTrace();
            }
    }

    callableService.shutdown();


  }

  public static void addToList( Employee employee, List<Employee> employeeList ){
    if (!employeeList.contains(employee))
      employeeList.add(employee);
    else {
      System.out.println("Duplicate employee " + employee.firstName + " " + employee.lastName );
    }
  }

}
