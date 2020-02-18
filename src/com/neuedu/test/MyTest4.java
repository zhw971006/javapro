package com.neuedu.test;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.*;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Neuedu on 2020/2/6.
 */
public class MyTest4 {
    public static AtomicInteger a = new AtomicInteger(0);
    public static Object lock = new Object();
    public static void main(String[] args) {
        /**
         *  1 Java 有多少种数据类型 -- 两种
         *      基本类型
         *          byte        1字节          -2^7~2^7-1                     Byte
         *          short       2字节          -2^15~2^15-1                   Short
         *          int         4字节          -2^31~2^31-1                   Integer
         *          long        8字节          -2^63~2^63-1                   Long
         *          float       4字节          1位正负号 8位指数  23位尾数      Float
         *          double      8字节          1位正负号 11位指数 52位尾数      Double
         *          boolean     1字节          0 false 非0 true                Boolean
         *          char        2字节          ASCLL码                         Character
         *        提示  float和double 这两种数据类型 只能用于存储 不能用于计算
         *        BigDecimal 来替代 float和double进行运算
         *        8种基本类型  对应着8种 包装类  包装类的作用？？
         *          1 泛型中 不能使用基本类型
         *          2 类中的属性不能使用基本类 要用包装类
         *        包装类 能不能用 == 号直接判断？不能
         *           8位以内 会指向常量池的相同地址 8位以上不会
         *           判断之前必须先做拆箱
         *      引用类型
         *          类       把具备相同属性的事物抽象出来 形成类  如果类和类之间又有了相同属性可以进行二次抽象 形成父类
         *          接口     规范了子类必须具备某些方法
         *          数组     在堆区中定义了一个连续的内存空间来储存多个变量
         *    合理的使用数据类型 减小内存开销
         *
         *   运算符
         *      1 数学运算符 用来对数字进行计算
         *          + - * / % ++ --
         *      2 关系运算符 用于比较 结果为boolean
         *          > < == != >= <=
         *      3 逻辑运算符  用于对boolean进行计算 结果还是boolean
         *          && & || | !
         *      4 位运算  2进制底层运算 速度最快
         *          & | ^ << >> >>>
         *
         * */
        /**
         *  数组
         *      定义数组的方式
         *      int[] a = new int[6];
                 int[] b = new int[]{1,2,3,4,5,6};
                 int[] c = {1,2,3,4,5};
         *  数组的缺点
         *      长度一旦定义无法更改
         *      假如我们定义了一个10个长度的数组 那么我们就只能放10个元素 如果有第11个元素的话 根本无法扩展
         *      要解决这一问题  就需要手动进行扩容了 方式 创建一个更大的数组  把原来的数组复制过来 然后继续向后添加内容
         *
         * 由于数组直接使用可以不太方便所以扩展出一个东西 Collection 集合
         *
         * Collection下包含两个子接口
         *  List 列表
         *      ArrayList
         *      LinkedList
         *      Vector
         *  Set  集合
         *      HashSet
         *      TreeSet
         *      LinkedHashSet
         *
         *      ArrayList 底层就是一个数组 elementData 为存放元素的数组
         *      一个参数的构造
         *          如果参数大于0 则把参数作为数组的初始长度
         *          如果参数等于0 赋值为 EMPTY_ELEMENTDATA 长度为0的数组
         *          如果小于0 抛出异常
         *      无参构造
         *          赋值为 DEFAULTCAPACITY_EMPTY_ELEMENTDATA 长度为0的数组
         *
         *      第一次添加的时候 无参构造 至少会把长度扩容到10
         *          是 new ArrayList(0) 最小长度是1
         *       思考  new ArrayList(0) 和  new ArrayList() 的区别
         *       add 传 size+1 数组应该有的最小长度
         *       如果 调用了无参构造  会在 10 和 size+1 之间取一个最大值
         *       如果一旦调用addAll 传另一个集合 那么 size+1 就不是1了
         *          另一个集合的长度+size
         *          判断最小长度(需要的长度)-数组的长度是否大于0
         *          如果大于0 意味着 数组的长度不够用了  就需要扩容了
         *          旧长度= 数组的长度
         *          新长度= 数组长度+数组长度右移1(/2的商)
         *          再次比较
         *              新长度-需要的长度 是否小于0
         *                  如果条件成立意味着 扩容之后长度还是不够用 新长度=需要的长度
         *
         *       new ArrayList(100);
         *      已经向一个ArrayList 放100万个元素 怎样做性能可以高一些
         *      new ArrayList(1000000)'
         *
         *      LinkedList 底层为双向链表
         *          LinkedList中 每一个元素都是一个Node对象
         *          linkedList 并不会记录每一个对象 只记录队首和队尾
         *          Node对象中有什么 存放的元素 上一个指针和下一个指针
         *          add方法 默认调用addlast 默认添加到最后一个
         *          取出原先的队尾
         *          创建一个新节点  上一个指向原先的队尾 把要存放的元素放进节点中
         *          把队尾指向到 新节点
         *          判断 原来的队尾是否是 null
         *              如果条件成立 意味着 是第一次添加 将队首也设置为新节点
         *              如果条件不成立 将原先队尾的下一个指向到新节点上
         *          链表没有容量的概念
         *          get 方法
         *          先判断 index 和 size/2 比较
         *              如果小于 则 从前开始找快
         *              如果大于 则 从后开始找快
         *
         *      ArrayList和Vector的区别
         *      ArrayList 非线程安全
         *      Vector 线程安全
         *      ArrayList和LinkedList的区别
         *      ArrayList 底层是数组
         *      LinkedList 底层是链表
         *      ArrayList和LinkedList 写性能
         *          尾部添加的时候 LinkedList比ArrayList 性能稍好 但是并不明显（差不多）
         *          中间插入的时候 LinkedList比ArrayList 性能好很多 差别很大
         *          ArrayList 读性能 高度LinkedList很多 (秒杀)
         *      String 底层 char数组  不可变 如果相变 无法改变该对象底层的char数组 只能重新创建String对象 重新指向
         *      String的储存
         *          String a = "abc" 代表 a 指向到 字符串常量池的 abc 指针上
         *          String b = "abc"
         *          String a = new String("abc"); 代表 该 String 在堆内存中创建对象
         *      为了安全 如果比较两个字符串的值是否相同 不能用 == 用 equals方法才可以
         *      字符串的拼接
         *        + 号拼接    项目中 绝对禁止
         *        StringBuffer    线程安全
         *        StringBuilder   非线程安全
         *        创建对象 调用append 方法拼接
         *
         *     Set  不可放入重复元素
         *      hashset  无序
         *      treeset  按照内容进行自然排序
         *      linkedHashSet 按照添加顺序进行排序
         *
         *   HashMap
         *      底层  数组+链表+红黑树
         *      通过key 拿出hashcode 用hashcode高16位于低16位进行按位异或运算 形成一个新的hashcode
         *      用新的hashcode 和  底层数字长度-1 进行按位与运算  这样得出的结果为 数组的下标
         *      如果下标中已经有元素 那么该下标中  的内容 会变成链表(单向) 如果该链表长度一旦到达了8 那么为了增加性能 会转成红黑树方式存储
         *      底层数组的初始长度为16  如果创建对象的时候传参数的话  那么默认长度为 大于等于该参数的 一个最小的 2的幂次方
         *      hashmap扩容因子为 0.75 也就是 数组使用了 3/4 将会扩容
         *
         *
         *   多线程
         *      创建线程的方式
         *          1 继承Thread类
         *          2 实现 Runnable接口
         *          3 线程池
         *      实际上 是线程在不断的抢占CPU的资源  由CPU对每一个线程进行调度
         *
         *      多线程操作同一个资源的时候 需要加线程同步  synchronized
         * */
        /*ArrayList arrayList = new ArrayList();
        LinkedList linkedList = new LinkedList();
        Date start_write_array = new Date();
        for(int i = 1;i<=100000;i++){
            arrayList.add(i);
        }
        Date end_write_array = new Date();
        Date start_write_linked = new Date();
        for(int i = 1;i<=100000;i++){
            linkedList.add(i);
        }
        Date end_write_linked = new Date();
        System.out.println("arrayList添加用时="+(end_write_array.getTime()-start_write_array.getTime()));
        System.out.println("linkedList添加用时="+(end_write_linked.getTime()-start_write_linked.getTime()));


        Date start_read_array = new Date();
        for(int i = 0;i<100000;i++){
            Object a =arrayList.get(i);
        }
        Date end_read_array = new Date();
        Date start_read_linked = new Date();
        for(int i = 0;i<100000;i++){
            Object a=linkedList.get(i);
        }
        Date end_read_linked = new Date();
        System.out.println("arrayList读取用时="+(end_read_array.getTime()-start_read_array.getTime()));
        System.out.println("linkedList读取用时="+(end_read_linked.getTime()-start_read_linked.getTime()));
       */

        /*StringBuilder builder = new StringBuilder("a");
        builder.append("b").append("c").append("d");
        System.out.println(builder);*/
        /*Set<Integer> set = new LinkedHashSet<>();
        set.add(1);
        set.add(10);
        set.add(100);
        set.add(50);
        set.add(30);
        set.add(70);
        for(int a:set){
            System.out.println(a);
        }*/
       /* Map<String,String> map = new HashMap<>(17);
        map.put("001","张三");
        map.put("002","李四");
        System.out.println(map.get("002"));*/
       // 数组的冒泡排序
        /*int[] array = {1,100,23,50,78,66,33,15,90,59};
        for(int i =0;i<array.length-1;i++){
            boolean flag = true;
            for(int j=0;j<array.length-1-i;j++){
                if(array[j]>array[j+1]) {
                    int tmp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = tmp;
                    flag = false;
                }
            }
            if(flag)
                break;
        }
        for(int a : array){
            System.out.println(a);
        }*/

        /**
         *  定义一个a初始值为0
         *  创建5000个线程 每一个线程都对a进行++操作
         *  我们观察a的结果
         *
         *  1 因为main本身就是一个线程  输出a并不会等待 上面的循环的a++全部执行完
         *      我们怎样保证 a++执行完5000次之后再去执行 输出a呢
         *      闭锁 CountDownLatch 可以解决这一问题
         *  2 线程安全
         *      线程同步
         *      信号量  Semaphroe
         *
         * */
        ExecutorService service = Executors.newCachedThreadPool();
        CountDownLatch countDownLatch = new CountDownLatch(5000);
       /* Semaphore semaphore = new Semaphore(1);*/
        /*for(int i=0;i<5000;i++){
            service.execute(()->{
                a.getAndIncrement();
                countDownLatch.countDown();
            });
        }
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(a.get());*/
       /* MyUtil myUtil = MyUtil.getInstance();
        myUtil.add(1,2);
        MyUtil myUtil2 = MyUtil.getInstance();
        myUtil2.add(1,2);
        System.out.println(myUtil==myUtil2);
        int a = 10;
        int b = 20;
        int c = a+b;*/
       /**
        *
        *   1  加载驱动   （反射）
        *   2  创建连接
        *   3 创建命令行 写sql语句
        *   4 执行sql语句  如果是增删改 返回int 受影响的行数   executeUpdate
        *       如果是查询 返回 ResultSet  executeQuery
        *
        *
        *
        * */


    }
}
