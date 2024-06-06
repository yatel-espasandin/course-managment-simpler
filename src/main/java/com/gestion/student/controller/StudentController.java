package com.gestion.student.controller;

import com.gestion.student.model.entity.Student;
import com.gestion.student.model.repository.StudentRepository;
import com.gestion.student.view.StudentView;

import java.util.EmptyStackException;

public class StudentController {
    private StudentRepository studentRepository;
    private StudentView studentView;

    public StudentController(StudentRepository studentRepository, StudentView studentView) {
        this.studentRepository = studentRepository;
        this.studentView = studentView;

        int lastId = getLastId();
        Student.setContador(lastId);
    }

    public StudentRepository getStudentRepository() {
        return studentRepository;
    }

    public StudentView getStudentView() {
        return studentView;
    }

    public Student newStudent() throws EmptyStackException {
        String name = studentView.getNameStudent();
        String email = studentView.getEmailStudent();
        if(name.isEmpty() || email.isEmpty()){
            throw new EmptyStackException();
        }else{
            return new Student(name, email);
        }
    }

    public void createStudent(){
        try{
            Student newStudent = newStudent();
            studentRepository.add(newStudent);
        }catch(EmptyStackException e){
            System.out.println(e.getMessage());
        }
    }

    public void update(){
        Student foundStudent = studentRepository.search(String.valueOf(studentView.getIdStudent()));
        if(foundStudent!=null) {
            try{
                String name = studentView.getNameStudent();
                String email = studentView.getEmailStudent();
                Integer id = foundStudent.getId();
                studentRepository.update(foundStudent, new Student(id, name, email));
            }catch(EmptyStackException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public Integer getLastId(){
        Integer last = 0;
        for(Student students : studentRepository.getStudentList()){
            if(last < students.getId()){
                last = students.getId();
            }
        }
        return last;
    }
}
