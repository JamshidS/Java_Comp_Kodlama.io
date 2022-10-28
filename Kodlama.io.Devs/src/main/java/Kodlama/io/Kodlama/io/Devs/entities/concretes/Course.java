package Kodlama.io.Kodlama.io.Devs.entities.concretes;

public class Course {

    private String courseName;
    private int courseID;
    public Course(int courseID, String courseName){
        this.courseID=courseID;
        this.courseName =courseName;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getCourseID() {
        return courseID;
    }

    public void setCourseID(int courseID) {
        this.courseID = courseID;
    }
}
