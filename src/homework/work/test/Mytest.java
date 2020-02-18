package homework.work.test;

import homework.work.pojo.Student;
import homework.work.web.StudentWeb;

/**
 * Created by Daniel on 2020/2/18.
 */
public class Mytest {
    public static void main(String[] args) {
        StudentWeb studentWeb = new StudentWeb();
        studentWeb.showmain();
        studentWeb.input();
    }
}
