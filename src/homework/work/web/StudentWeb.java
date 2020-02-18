package homework.work.web;

import homework.work.pojo.Student;
import homework.work.service.IstudentService;
import homework.work.service.StudentService;

import java.util.List;
import java.util.Scanner;

/**
 * Created by Daniel on 2020/2/18.
 */
public class StudentWeb {
    IstudentService studentService = new StudentService();
    public void showmain(){
        System.out.println("—————————————————————————");
        System.out.println("1———————————————————————查询");
        System.out.println("2———————————————————————添加");
        System.out.println("3———————————————————————修改");
        System.out.println("4———————————————————————删除");
        System.out.println("其他——————————————————————退出");
        System.out.println("—————————————————————————");
    }
    public void input(){
        Scanner scanner = new Scanner(System.in);
        int i = scanner.nextInt();
        if (i==1){
            query();
        }else if(i==2){
            add(scanner);
        }else if(i==3){
            update(scanner);
        }else if(i==4){
            System.out.println("删除");
        }else{
            System.exit(0);
        }
    }
    public void query() {
        List<Student> list = studentService.query();
        for (Student student : list) {
            System.out.println(student);
        }
    }
    public void add(Scanner scanner){
        System.out.println("请输入要添加的序号");
        int Sno = scanner.nextInt();
        System.out.println("请输入要添加的名字");
        String Sname = scanner.next();
        System.out.println("请输入性别（男或女）");
        String Ssex = scanner.next();
        System.out.println("请输入要添加的年龄");
        int Sage = scanner.nextInt();
        System.out.println("请输入要添加的专业");
        String Sdept = scanner.next();
        Student student = new Student(Sno,Sname,Ssex,Sage,Sdept);
        //调用服务层 添加该数据
        studentService.add(student);
        //显示列表
        query();
    }
    public void update(Scanner scanner){
        System.out.println("请输入要修改的序号");
        int Sno = scanner.nextInt();
        System.out.println("请输入要修改的名字");
        String Sname = scanner.next();
        System.out.println("请输入要修改的性别（男或女）");
        String Ssex = scanner.next();
        System.out.println("请输入要修改的年龄");
        int Sage = scanner.nextInt();
        System.out.println("请输入要修改的专业");
        String Sdept = scanner.next();
        Student student = new Student(Sno,Sname,Ssex,Sage,Sdept);
        //调用服务层 添加该数据
        studentService.update(student);
        //显示列表
        query();

    }
}
