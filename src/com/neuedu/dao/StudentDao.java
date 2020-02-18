package com.neuedu.dao;

import com.neuedu.pojo.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Neuedu on 2020/2/18.
 */
public class StudentDao implements IstudentDao {
    String url = "jdbc:mysql://192.168.80.131:3306/db1?useUnicode=true&characterEncoding=utf8";
    String username = "root";
    String password = "1234567";
    @Override
    public List<Student> query() {
        List<Student> list = new ArrayList<>();
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            // 加载驱动
            Class.forName("com.mysql.jdbc.Driver");
            // 创建连接
            con = DriverManager.getConnection(url,username,password);
            // 创建命令行 写sql语句
            pstmt = con.prepareStatement("select id,name,age,gender from student");
            // 执行sql语句
            // 如果是查询  调用 executeQuery方法 返回一个 ResultSet 结果集
            rs = pstmt.executeQuery();
           /*  ResultSet 每次调用 next()方法的时候 会做两件事
           *    1 看一下有没有下一行 如果没有返回fasle
           *    2 如果有 将游标推向下一行 返回true
           *
           *
           * */
           while(rs.next()){
               Student student = new Student();
               student.setId(rs.getInt("id"));
               student.setName(rs.getString("name"));
               student.setAge(rs.getInt("age"));
               student.setGender(rs.getInt("gender"));
               list.add(student);
           }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                if(rs != null)
                    rs.close();
                if(pstmt != null)
                    pstmt.close();
                if(con != null)
                    con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return list;
    }

    @Override
    public int add(Student student) {
        return 0;
    }

    @Override
    public int update(Student student) {
        return 0;
    }

    @Override
    public int del(int id) {
        return 0;
    }

    @Override
    public Student queryOne(int id) {
        return null;
    }
}
