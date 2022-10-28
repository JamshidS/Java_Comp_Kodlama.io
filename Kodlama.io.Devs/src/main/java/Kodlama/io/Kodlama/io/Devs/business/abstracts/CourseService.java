package Kodlama.io.Kodlama.io.Devs.business.abstracts;

import Kodlama.io.Kodlama.io.Devs.entities.concretes.Course;

import java.util.List;

public interface CourseService {
    void add(Course course) throws Exception;
    void delete(int  id)throws Exception;
    void update(Course course,int index) throws Exception;

    Course getByID(int id);

    List<Course> getAll();
}
