package com.company;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.LinkedList;

public class EmployeeInfoReader {

  public void read(){


    String info = "";
    byte[] data;
    try ( FileInputStream fis = new FileInputStream("./info.txt") ){
      data = new byte[ fis.available() ];
      fis.read( data );
      info = new String( data );
    } catch ( IOException ex ){

    }

    String[] employeeInfos = info.split("\r\n");
    LinkedList<Employee> employeeLinkedList = new LinkedList<>();
    Employee employee;
    for ( String employeeInfo : employeeInfos ){
          String[] employeeData = employeeInfo.split(" ");
          employee = new Employee(employeeData[0], employeeData[1], 34,
                            "Default team", POSITION.valueOf( employeeData[2] ) );
          employeeLinkedList.add( employee );

    }

    System.out.println();

  }

}
