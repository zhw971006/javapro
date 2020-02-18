package homework.work.service;

import homework.work.dao.IstudentDao;
import homework.work.dao.StudentDao;
import homework.work.pojo.Student;

import java.util.List;

/**
 * Created by Daniel on 2020/2/18.
 */
public class StudentService implements IstudentService{
    IstudentDao studentDao = new StudentDao();
    @Override
    public List<Student> query() {
        return studentDao.query();
    }

    @Override
    public int add(Student student) {
        return studentDao.add(student);
    }

    @Override
    public int update(Student student) {

        return studentDao.update(student);
    }

    @Override
    public int del(Student student) {
        return 0;
    }

    @Override
    public Student queryOne(int id) {
        return null;
    }
}
