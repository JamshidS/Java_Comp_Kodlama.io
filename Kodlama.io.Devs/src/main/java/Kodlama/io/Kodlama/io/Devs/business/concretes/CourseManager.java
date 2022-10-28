package Kodlama.io.Kodlama.io.Devs.business.concretes;

import Kodlama.io.Kodlama.io.Devs.business.abstracts.CourseService;
import Kodlama.io.Kodlama.io.Devs.dataAccess.abstracts.CourseRepository;
import Kodlama.io.Kodlama.io.Devs.entities.concretes.Course;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class CourseManager implements CourseService {

    private CourseRepository courseRepository;
    public CourseManager(CourseRepository courseRepository){
        this.courseRepository=courseRepository;
    }

    private boolean isThereCourse(Course course) throws Exception {
       List<Course> courses1 = courseRepository.getAll();
        for(int i=0;i<courses1.size();i++){
            if(courses1.get(i).getCourseName().equals(course.getCourseName())){
                return true;
            }
        }

        return false;
    }

    private boolean isThereId(int id) throws Exception {

        for(Course course:courseRepository.getAll()){
            if(course.getCourseID()==id){
                return true;
            }
        }

        return false;
    }
    @Override
    public void add(Course course) throws Exception {
        if(isThereCourse(course)){
            throw new Exception("There is a course with this name");
        }
        if(isThereId(course.getCourseID())){
            throw new Exception("There is a course with this ID");
        }
        courseRepository.add(course);
    }

    @Override
    public void delete(int id) throws Exception {
       if(!isThereId(id)) throw new Exception("The id is not exists ");
        courseRepository.delete(id);
    }

    @Override
    public void update(Course course,int id) throws Exception {
        if(isThereCourse(course)) throw new Exception("There is a course exists with the same name");
        if(!isThereId(id)) throw new Exception("The id is not exists ");
        courseRepository.update(course,id);

    }

    @Override
    public Course getByID(int id) {
        return courseRepository.getByID(id);
    }

    @Override
    public List<Course> getAll() {
        return courseRepository.getAll();
    }
}
