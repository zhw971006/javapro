package com.neuedu.test;

/**
 * Created by Neuedu on 2020/2/13.
 */
public class MyUtil {
    private static volatile MyUtil myUtil = null;
    private static Object lock = new Object();
    private MyUtil(){}
    public static MyUtil getInstance(){
        if(myUtil==null) {
            synchronized (lock) {
                if (myUtil == null)
                    myUtil = new MyUtil();
            }
        }
        return myUtil;
    }
    public int add(int a,int b){
        return a+b;
    }
}
