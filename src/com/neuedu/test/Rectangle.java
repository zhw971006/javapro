package com.neuedu.test;

/**
 * Created by Daniel on 2020/2/6.
 */
public class Rectangle extends Shape{
    int width;
    int height;
    public Rectangle(){

    }
    public Rectangle(int width,int height,String color){
        this.width = width;
        this.height = height;
        this.color = color;
    }

    @Override
    public void getPer() {
        per=(width+height)*2;
    }

    @Override
    public void getArea() {
        area=height*width;
    }

    @Override
    public void getAll() {
        System.out.println("矩形面积"+area+"矩形周长"+per+"矩形颜色"+color);
    }
}
