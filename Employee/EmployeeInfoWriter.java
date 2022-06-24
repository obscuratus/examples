package com.company;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class EmployeeInfoWriter {


  public EmployeeInfoWriter(){
  }

  public void write(Employee employee){


    try ( FileOutputStream fos = new FileOutputStream("./info.txt", true) ) {
      fos.write( employee.toString().getBytes(StandardCharsets.UTF_8));
    } catch ( IOException ex ){
      System.out.println("Cannot write to file");
      ex.printStackTrace();
    }
  }

}
