package homework.work.service;

import homework.work.pojo.Student;

import java.util.List;

/**
 * Created by Daniel on 2020/2/18.
 */
public interface IstudentService {
    List<Student>query();
    int add(Student student);
    int update(Student student);
    int del(Student student);
    Student queryOne (int id);
}
