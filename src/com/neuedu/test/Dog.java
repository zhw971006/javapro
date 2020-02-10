package com.neuedu.test;

public class  Dog extends Animal{
    /**
     *private int age;
   public int getAge(){
        return age;
    }
   public void setAge(int age){
       if(age<0||age>30){
           System.out.println("年龄输入错误");
       }else {
           this.age = age;
       }
   }
   private char sex;
    public char getSex(){
        return sex;
    }
    public void setSex(char sex){
        if (sex=='公'||sex=='母'){
            this.sex = sex;
        }else{
            System.out.println("性别输入错误");
        }
    }*/
    public void name(){
        Dog d1 = new Dog();
        d1.setAge(10);
        System.out.println(d1.getAge());
    }
}
