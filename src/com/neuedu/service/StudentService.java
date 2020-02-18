package com.neuedu.service;

import com.neuedu.dao.IstudentDao;
import com.neuedu.dao.StudentDao;
import com.neuedu.pojo.Student;

import java.util.List;

/**
 * Created by Neuedu on 2020/2/18.
 */
public class StudentService implements IstudentService {
    IstudentDao studentDao = new StudentDao();
    @Override
    public List<Student> query() {
        return studentDao.query();
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
