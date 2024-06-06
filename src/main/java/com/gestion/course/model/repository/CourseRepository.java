package com.gestion.course.model.repository;

import com.gestion.course.model.entity.Course;
import com.gestion.interfaces.IRepository;
import com.gestion.student.model.entity.Student;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CourseRepository implements IRepository <Course> {
    private List<Course> courseList;

    public CourseRepository() {
        this.courseList = new ArrayList<>();
    }

    @Override
    public void add(Course obj) {
        this.courseList.add(obj);
    }

    public void addStudent(Course course, Student student){
        course.getStudentSet().add(student);
    }

    @Override
    public Course search(String data) {
        for(Course courses : courseList){
            if(courses.getCode().equals(data)){
                return courses;
            }
        }
        return null;
    }

    public Student searchStudent(String data, Integer id){
        for(Course courses : courseList){
            if(courses.getCode().equals(data)){
                for(Student students : courses.getStudentSet()){
                    if(students.getId().equals(id)){
                        return students;
                    }
                }
            }
        }
        return null;
    }

    @Override
    public void update(Course objeto, Course actualizado) {
        objeto.setName(actualizado.getName());
    }

    public void updateStudent(Course objeto, Student actualizar, Student actualizado){
        objeto.getStudentSet().remove(actualizar);
        objeto.getStudentSet().add(actualizado);
    }

    @Override
    public void remove(Course obj) {
        this.courseList.remove(obj);
    }

    public void removeStudent(Course course, Student student){
        course.getStudentSet().remove(student);
    }
}
