package com.gestion.course.controller;

import com.gestion.course.model.entity.Course;
import com.gestion.course.model.repository.CourseRepository;
import com.gestion.course.view.CourseView;
import com.gestion.exception.EmptyFieldException;
import com.gestion.student.controller.StudentController;
import com.gestion.student.model.entity.Student;

public class CourseController {
    private CourseRepository courseRepository;
    private CourseView courseView;
    private StudentController studentController;

    public CourseController(CourseRepository courseRepository, CourseView courseView, StudentController studentController) {
        this.courseRepository = courseRepository;
        this.courseView = courseView;
        this.studentController = studentController;
    }

    public CourseRepository getCourseRepository() {
        return courseRepository;
    }

    public CourseView getCourseView() {
        return courseView;
    }

    public Course newCourse() throws EmptyFieldException {
        String code = courseView.getCode();
        String name = courseView.getName();
        if(code.isEmpty() || name.isEmpty()){
            throw new EmptyFieldException();
        }else{
            return new Course(code, name);
        }
    }

    public void createCourse(){
        try{
            Course toAdd = newCourse();
            Course foundCourse = courseRepository.search(toAdd.getCode());
            if(foundCourse==null){
                courseRepository.add(toAdd);
            }else{
                courseView.courseExistance(1);
            }
        }catch(EmptyFieldException e){
            System.out.println(e.getMessage());
        }
    }

    public void addStudent(Course course){
        if(course==null){
            course = newCourse();
        }
        Student foundStudent = studentController.getStudentRepository().search(String.valueOf(studentController.getStudentView().getIdStudent()));
        if(foundStudent!=null){
            course.getStudentSet().add(foundStudent);
        }else{
            Student toAdd = studentController.newStudent();
            course.getStudentSet().add(toAdd);
        }
    }

    public void updateCoruse(){
        Course foundCourse = courseRepository.search(courseView.getCode());
        if(foundCourse!=null) {
            String name = courseView.getName();
            courseRepository.update(foundCourse, new Course(name));
        }else{
            courseView.courseExistance(2);
        }
    }

    public void removeCourse(){
        Course foundCourse = courseRepository.search(courseView.getCode());
        if(foundCourse!=null) {
            courseRepository.remove(foundCourse);
        }else{
            courseView.courseExistance(2);
        }
    }

    public void removeStudent(Course course){
        try{
            Student foundStudent = courseRepository.searchStudent(course.getCode(), studentController.getStudentView().getIdStudent());
            if(foundStudent !=null){
                courseRepository.removeStudent(course, foundStudent);
            }else{
                studentController.getStudentView().studentExistance(2);
            }
        }catch(NullPointerException e){
            System.out.println(e.getMessage());
        }
    }
}
