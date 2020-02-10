package com.neuedu.test;

/**
 * Created by Daniel on 2020/2/5.
 */
public class Text {
    public static void main(String[] args) {
       /* Circle c1 = new Circle(50,"红色");
        c1.getArea();
        c1.getPer();
        c1.getAll();
        Rectangle r1 = new Rectangle(6,5,"绿色");
        r1.getArea();
        r1.getPer();
        r1.getAll();
        Circle circle = new Circle();
        method(circle);
    }
    public static void method(Shape shape){

    }*/
       /**
        *
        * 继承父类是extends加父类名字
        * 实现（继承）接口implements加接口名
        *
        * 传参多态
        *   参数如果是父类 所有子类的对象都可以传递
        * */
        I3 i3 = new I3();
        I5 i5 = new I5();
        I7 i7 = new I7();
        MyBoard myBoard = new MyBoard();
       //setCpu 参数需要传Cpu类型
        //i3 i5 i7 只要是cpu的子类就可以传递
        myBoard.setCpu(i5);
        myBoard.method();
    }
}
