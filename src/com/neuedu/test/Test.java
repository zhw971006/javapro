package com.neuedu.test;
public class Test{
    public static void main(String[] args) {
        /*Dog d1 = new Dog();
        d1.setAge(10);
        int age = d1.getAge();
        System.out.println(d1.getAge());
        d1.setSex('母');
        int sex = d1.getSex();
        System.out.println(d1.getSex());*/

        int year = 1990;
        if((year%4==0&&year%100 !=0)||(year%400 ==0)){
            System.out.println("是闰年");
        }else {
            System.out.println("不是闰年");
        }


    }
}
