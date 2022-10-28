package Kodlama.io.Kodlama.io.Devs.webApi.controllers;


import Kodlama.io.Kodlama.io.Devs.business.abstracts.CourseService;
import Kodlama.io.Kodlama.io.Devs.entities.concretes.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/courses")
public class CoursesController {
    private CourseService courseService;
    @Autowired
    public CoursesController(CourseService courseService){
        this.courseService=courseService;
    }

    @PostMapping
    public void add(@RequestBody Course course) throws Exception {
        courseService.add(course);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable(name = "id")int id) throws Exception {
        courseService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable(name = "id")int id, @RequestBody Course course) throws Exception {
        courseService.update(course,id);
    }

    @GetMapping
    public List<Course> getAll(){
        return courseService.getAll();
    }


    @GetMapping("/{id}")
    public Course getByID(@PathVariable(name="id")int id) throws Exception{
        return courseService.getByID(id);
    }

}
