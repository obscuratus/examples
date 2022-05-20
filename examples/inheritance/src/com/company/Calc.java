package com.company;

public class Calc implements Actions, Printer{

  int x;
  int y;
  float result;

  Calc(int x, int y){
    this.x = x;
    this.y = y;
  }

  @Override
  public void sum() {
    result = x + y;
  }

  @Override
  public void divide() {
    result = (float) x/y;
  }

  @Override
  public void printResult() {
    System.out.println(result);
  }
}
