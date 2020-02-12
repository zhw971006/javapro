package homework;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Daniel on 2020/2/12.
 */
public class MyBookMain {
    public static MyBook[] books = new MyBook[200];
    public static List<MyBook> list = new ArrayList<>();
    public static void main(String[] args) {
        inputData(list);
        print(list);
    }
    public static void inputData(List<MyBook> books){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i=1;i<=n;i++){
            MyBook myBook = new MyBook("书名"+i,Double.valueOf(String.valueOf(i)),"出版社"+i,"作者"+i,"ISBN"+i);
            books.add(myBook);
        }
    }
    public static void print(List<MyBook> books){
        for (int i=0;i<books.size();i++){
            System.out.println(books.get(i));
        }
    }
    public static void seachName(List<MyBook> books,String name){
        for (int i=0;i<books.size();i++){
            MyBook myBook = books.get(i);
            if (myBook.getName().equals(name)){
                System.out.println(myBook);
                break;
            }
        }
        System.out.println("此书不存在");
    }
}