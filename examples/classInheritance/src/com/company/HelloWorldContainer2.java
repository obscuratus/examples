package com.company;

public class HelloWorldContainer2 extends TextContainer{

  HelloWorldContainer2(){
    this.text = "Hello world";
  }

  public void printData(){
    System.out.println( text + " from override method");
  }

}
