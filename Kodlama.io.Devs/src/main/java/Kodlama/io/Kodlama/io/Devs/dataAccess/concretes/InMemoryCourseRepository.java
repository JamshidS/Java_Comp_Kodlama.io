package Kodlama.io.Kodlama.io.Devs.dataAccess.concretes;

import Kodlama.io.Kodlama.io.Devs.dataAccess.abstracts.CourseRepository;
import Kodlama.io.Kodlama.io.Devs.entities.concretes.Course;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class InMemoryCourseRepository implements CourseRepository {

    List<Course> courses = new ArrayList<>();

    public InMemoryCourseRepository(){
        courses.add(new Course(1,"Java"));
        courses.add(new Course(2,"Python"));
        courses.add(new Course(3,"C#"));
        courses.add(new Course(4,"C++"));
    }
    @Override
    public List<Course> getAll() {
        return courses;
    }

    @Override
    public void add(Course course) {
        courses.add(course);
    }

    @Override
    public void delete(int index) {
        courses.remove(getByID(index));
    }

    @Override
    public void update(Course course,int id) {
        Course course1= getByID(id);
        course1.setCourseName(course.getCourseName());
    }

    @Override
    public Course getByID(int id) {
        Course course1=courses.stream().filter(course -> course.getCourseID()==id).findFirst().get();
        course1.getCourseID();
        return course1;
    }
}
