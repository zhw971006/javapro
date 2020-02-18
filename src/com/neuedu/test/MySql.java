package com.neuedu.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by Daniel on 2020/2/18.
 */
public class MySql {
    public static void main(String[] args) {
    String url="jdbc:mysql://localhost:3306/derrick";
    String username="root";
    String password="123456";
    Connection con = null;
    PreparedStatement pstmt = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");

            con =DriverManager.getConnection(url,username,password);

            pstmt = con.prepareStatement("insert into student(Sno,Sname,Ssex,Sage,Sdept) values (4,'wuxie','nan',25,'kaoguxi')");

            // 6 执行sql语句 看结果
            // 如果是增删改查 则用 PreparedStatement对象调用  executeUpdate方法 返回int (受影响的行数)
            // 如果是查询 则用 PreparedStatement对象调用  executeQuery 返回ResultSet对象 (结果集)
            int i = pstmt.executeUpdate();
            System.out.println("受影响行数："+i);
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstmt !=null)
                     pstmt.close();
                if (con !=null)
                     con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
    }
}
