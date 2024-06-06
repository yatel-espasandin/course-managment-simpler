package com.gestion.course.view;

import java.util.Scanner;

public class CourseView {

    Scanner scan = new Scanner(System.in);

    public String getCode(){
        System.out.println("Codigo del curso: ");
        return scan.nextLine();
    }

    public String getName(){
        System.out.println("Nombre del curso: ");
        return scan.nextLine();
    }

    public void courseExistance(int i){
        switch(i){
            case 1:
                System.out.println("El curso ya se encuentra en base de datos.");
                break;
            case 2:
                System.out.println("El curso no existe.");
                break;
        }
    }
}
