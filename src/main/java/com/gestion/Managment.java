package com.gestion;

import com.gestion.course.controller.CourseController;
import com.gestion.course.model.entity.Course;
import com.gestion.course.model.repository.CourseRepository;
import com.gestion.course.view.CourseView;
import com.gestion.student.controller.StudentController;
import com.gestion.student.model.entity.Student;
import com.gestion.student.model.repository.StudentRepository;
import com.gestion.student.view.StudentView;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

public class Managment {
    private static final String FILE_PATH = "src/main/resources/managment.json";
    private Gson gson = new Gson();
    private Map<String, Course> courseMap;

    private StudentRepository studentRepository;
    private StudentView studentView;
    private StudentController studentController;
    private CourseRepository courseRepository;
    private CourseView courseView;
    private CourseController courseController;

    public Managment(StudentRepository studentRepository, StudentView studentView,
                     StudentController studentController, CourseRepository courseRepository,
                     CourseView courseView, CourseController courseController) {
        this.studentRepository = studentRepository;
        this.studentView = studentView;
        this.studentController = studentController;
        this.courseRepository = courseRepository;
        this.courseView = courseView;
        this.courseController = courseController;
        loadFormJson();
    }

    public void loadFormJson(){
        try(Reader reader = new FileReader(FILE_PATH)){
            Type mapType = new TypeToken<Map<String, Course>>() {}.getType();
            courseMap = gson.fromJson(reader, mapType);
            if(courseMap==null){
                courseMap = new HashMap<>();
            }else{
                loadColection();
            }
        }catch(FileNotFoundException e){
            courseMap = new HashMap<>();
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
    }

    public void loadColection(){
        for(Map.Entry<String, Course> entry : courseMap.entrySet()){
            Course course = entry.getValue();
            if(!course.getStudentSet().isEmpty()){
                courseMap.put(entry.getKey(), course);
                courseRepository.add(course);
                for(Student students : course.getStudentSet()){
                    studentRepository.add(students);
                }
            }
        }
    }


    public void saveToJson(){
        try(Writer writer = new FileWriter(FILE_PATH)){
            gson.toJson(courseMap, writer);
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
    }


}
