package com.company;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
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

//    ExecutorService callableService = Executors.newFixedThreadPool(2 ); // создаем пул трэдов
//    List< Future<Integer> > futureList = new ArrayList<>(); // лист для БУДУЩИХ результатов
//    for ( Employee employee : employeeLinkedList ){ // бежим по списку сотрудников
//          Future<Integer> future = callableService.submit( employee::compute ); // отдаем сервису наших сотрудников, которые compute()
//          futureList.add( future ); // вносим в лист объекты БУДУЩИХ результатов
//    }
//
//    for ( Future<Integer> future : futureList ){
//            try {
//
//              System.out.println( future.get() );
//
//            } catch (InterruptedException e) {
//              e.printStackTrace();
//            } catch (ExecutionException e) {
//              e.printStackTrace();
//            }
//    }
//
//    callableService.shutdown();

//    EmployeeInfoWriter writer = new EmployeeInfoWriter();
//    for ( Employee employee : employeeLinkedList ) {
//          writer.write(employee);
//    }

    EmployeeInfoReader reader = new EmployeeInfoReader();
    reader.read();

    URL url = null;  // создаем переменную url
    try {
      url = new URL("http://google.com"); // записываем в нее объект гипер-ссылки
    } catch (MalformedURLException e) {
//      e.printStackTrace(); // выводим стектрейс, если что-то пошло не так
      throw new RuntimeException("URL is not valid");
    }

    StringBuilder stringBuilder = new StringBuilder();
    try ( BufferedInputStream bis = new BufferedInputStream(url.openStream())  ) {
          int data = bis.read(); // получаем следующий int из потока,
                                 // сюда могут прийти значения в диапозоне -1..255
                                 // по сути сюда приходит байт, но int нужен для того,
                                 // чтобы можно было отправлять -1, который является маркером конца потока
          while ( data > 0 ) { // проверяем, что там не конец потока (то есть значение пришло положительное),
                               // если пришел -1 - значит конец потока
            stringBuilder.append( (char) data ); // превращаем int в символ(char),
                                                 // так как у нас по сути прихоит байт,
                                                 // то в данном случае конвертация валидна
            data = bis.read();            // читаем следующий байт
          }
    } catch ( IOException ex ){
      throw new RuntimeException("Cannot read from URL");
    }

    System.out.println( stringBuilder );


  }

  public static void addToList( Employee employee, List<Employee> employeeList ){
    if (!employeeList.contains(employee))
      employeeList.add(employee);
    else {
      System.out.println("Duplicate employee " + employee.firstName + " " + employee.lastName );
    }
  }

}
