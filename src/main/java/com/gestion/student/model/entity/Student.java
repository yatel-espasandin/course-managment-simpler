package com.gestion.student.model.entity;

import java.util.Objects;

public class Student {
    private static Integer contador = 0;
    private Integer id;
    private String name;
    private String email;

    public Student(String name, String email) {
        this.id = ++contador;
        this.name = name;
        this.email = email;
    }

    public Student(Integer id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public static Integer getContador() {
        return contador;
    }

    public static void setContador(Integer contador) {
        Student.contador = contador;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(id, student.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
