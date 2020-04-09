package com.auditreport.Model;

import org.springframework.stereotype.Component;

@Component
public class Student {

    private int student_id;
    private String name, surname;
    private String email;
    private String password;

    public Student(){


    }


    public Student(String name, String surname, int student_id, String password, String email){

        this.name = name;
        this.surname = surname;
        this.student_id = student_id;
        this.password = password;
        this.email = email;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getStudent_id() {
        return student_id;
    }

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "com.auditreport.Model.Student{" +
                "studentNumber=" + student_id +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }



}
