package com.gestion.course.model.entity;

import com.gestion.student.model.entity.Student;

import java.util.HashSet;
import java.util.Set;

public class Course {
    private String code;
    private String name;
    private Set<Student> studentSet;

    public Course(String name) {
        this.name = name;
    }

    public Course(String code, String name) {
        this.code = code;
        this.name = name;
        this.studentSet = new HashSet<>();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Student> getStudentSet() {
        return studentSet;
    }

    public void setStudentSet(Set<Student> studentSet) {
        this.studentSet = studentSet;
    }
}
