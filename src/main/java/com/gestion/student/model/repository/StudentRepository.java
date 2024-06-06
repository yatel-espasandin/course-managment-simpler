package com.gestion.student.model.repository;

import com.gestion.interfaces.IRepository;
import com.gestion.student.model.entity.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentRepository implements IRepository <Student> {
    private List<Student> studentList;

    public StudentRepository() {
        this.studentList = new ArrayList<>();
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    @Override
    public void add(Student obj) {
        this.studentList.add(obj);
    }

    @Override
    public Student search(String data) {
        for(Student students : studentList){
            if(students.getId().equals(data)){
                return students;
            }
        }
        return null;
    }

    @Override
    public void update(Student objeto, Student actualizado) {
        objeto.setName(actualizado.getName());
        objeto.setEmail(actualizado.getEmail());
    }

    @Override
    public void remove(Student obj) {
        this.studentList.remove(obj);
    }
}
