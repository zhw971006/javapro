package com.neuedu.test;

/**
 * Created by Daniel on 2020/2/3.
 */
public class Homework {
    public static void main(String[] args) {
       /*int sum = 0;
       for (int i=2;i<=100;i++){
           for (int j=2;j<=i;j++){
               if (i%j==0&&i!=j){
                   break;
               }
               if (i%j==0&&i==j){
                   System.out.println(i);
                   sum=sum+i;
               }
           }
       }
        System.out.println("100内所有质数的和为"+sum);
       int c = Dog.dog(2,1);
        System.out.println(c);
       //第一个问
        int i = 0;  //保存百位上的数
        int j = 0;  //保存十位上的数
        int k = 0;  //保存各位上的数
        int t = 0;  //保存数字个数
        for (i = 1; i <= 4; i++) {
            for (j = 1; j <= 4; j++) {
                for (k = 1; k <= 4; k++) {
                    if (i != j && j != k && i != k) {
                        t += 1;
                        System.out.println(i * 100 + j * 10 + k);
                    }
                }
            }
        }
        //第二个问题
        int a = 1;
        int sum = 0;
        for (a=1;a<=100;a++){
            if (a%2==0){
                sum=sum+a;
            }
        }
        System.out.println(sum);
        //第三个问题
        int m = 20;
        int n = 30;

       //第四个问题
        int a;
        int b;
        int c;
        for (int d=100;d<=999;d++){
            a=d/100;
            b=(d-100*a)/10;
            c=d%10;
            if (a*a*a+b*b*b+c*c*c==d){
                System.out.println(d);
            }
        }  */
       //第五个问题
        int a=12;
        int b=15;
        for (int x=1;x<=a;x++){
            if (a%x==0){
                System.out.println(x);
            }
        }
    }
}
