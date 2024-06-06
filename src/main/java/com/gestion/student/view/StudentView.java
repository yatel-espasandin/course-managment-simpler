package com.gestion.student.view;

import com.gestion.student.model.entity.Student;

import java.util.EmptyStackException;
import java.util.Scanner;

public class StudentView {

    Scanner scan = new Scanner(System.in);

    public String getNameStudent(){
        System.out.println("Nombre del estudiante: ");
        return scan.nextLine();
    }

    public String getEmailStudent(){
        System.out.println("Email del estudiante: ");
        return scan.nextLine();
    }

    public Integer getIdStudent(){
        System.out.println("Id del estudiante");
        Integer id = scan.nextInt();
        scan.nextLine();
        return id;
    }

    public void studentExistance(int i){
        switch(i){
            case 1:
                System.out.println("El alumno ya se encuentra en base de datos.");
                break;
            case 2:
                System.out.println("El alumno no existe.");
                break;
        }
    }
}
