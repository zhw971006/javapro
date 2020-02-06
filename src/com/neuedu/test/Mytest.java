package com.neuedu.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Daniel on 2020/2/6.
 */
public class Mytest {
    public static void main(String[] args) {
        List arrayList = new ArrayList();
        List linkedList = new LinkedList();
        Date startarray = new Date();   //开始的时候获取一下当前时间
        for(int i=0;i<100000;i++){
            arrayList.add(0,i);
        }
        Date endarray = new Date();     //结束的时候获取一下当前时间
        //结束时的时间-开始时的时间=添加用时  getTime()单位是毫秒
        System.out.println("ArrayList添加用时"+(endarray.getTime()-startarray.getTime()));


        Date startLinkedList = new Date();   //开始的时候获取一下当前时间
        for(int i=0;i<100000;i++){
            linkedList.add(0,i);
        }
        Date endLinkedList = new Date();     //结束的时候获取一下当前时间
        System.out.println("LinkedList添加用时"+(endLinkedList.getTime()-startLinkedList.getTime()));

        //读取array
        Date startreadarray = new Date();
        for(int i=0;i<arrayList.size();i++){
            Object obj = arrayList.get(i);
        }
        Date endreadarray = new Date();
        System.out.println("ArrayList读取用时"+(endreadarray.getTime()-startreadarray.getTime()));
        //读取linked
        Date startreadlinked = new Date();
        for(int i=0;i<linkedList.size();i++){
            Object obj = linkedList.get(i);
        }
        Date endreadLinked= new Date();
        System.out.println("LinkedList读取用时"+(endreadLinked.getTime()-startreadlinked.getTime()));

    }
}
