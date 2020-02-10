package com.neuedu.test;

/**
 * Created by Daniel on 2020/2/5.
 */
public class Circle extends Shape{;
    int radius;
    public Circle(){

    }
    public Circle(int radius,String color){
        this.radius=radius;
        this.color=color;
    }

    @Override
    public void getArea() {
        area=radius*radius*3.14;
    }

    @Override
    public void getPer() {
        per=2*radius*3.14;
    }

    @Override
    public void getAll() {
        System.out.println("圆面积"+area+"圆周长"+per+"园颜色"+color);
    }
}
