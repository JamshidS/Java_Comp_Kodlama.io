package Kodlama.io.Kodlama.io.Devs.dataAccess.abstracts;

import Kodlama.io.Kodlama.io.Devs.entities.concretes.Course;

import java.util.List;

public interface CourseRepository {
    List<Course> getAll();
    void add(Course course);
    void delete(int index);
    void update(Course course,int index);

    Course getByID(int id);

}
