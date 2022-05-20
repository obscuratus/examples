package com.company;

public class ExtendedCalc extends Calc implements ExtendedActions {

  ExtendedCalc(int x, int y) {
    super(x, y);
  }

  public void sub(){
    result = x - y;
  }

  public void mul(){
    result = x * y;
  }

}
