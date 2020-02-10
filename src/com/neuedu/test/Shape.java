package com.neuedu.test;

/**
 * Created by Daniel on 2020/2/5.
 */
public abstract class Shape {
   public Shape(){

   }
   public double area;
   public double per;
   public String color;
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public abstract void getArea();
    public abstract void getPer();
    public abstract void getAll();
}
