package com.auditreport.Model;

import org.springframework.stereotype.Component;

import javax.persistence.*;

@Entity

public class StudentInfoReturn {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int student_database_ID;


    private int student_id;


    private String student_name;


    private String student_surname;


    private String student_email;


    private String student_password;

    public StudentInfoReturn(){


    }


    public StudentInfoReturn(String name, String surname, int student_id, String password, String email){

        this.student_name = name;
        this.student_surname = surname;
        this.student_id = student_id;
        this.student_email = email;
        this.student_password = password;

    }

    public String getName() {
        return student_name;
    }

    public void setName(String name) {
        this.student_name = name;
    }

    public String getSurname() {
        return student_surname;
    }

    public void setSurname(String surname) {
        this.student_surname = surname;
    }

    public int getStudent_id() {
        return student_id;
    }

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }

    public String getPassword() {
        return student_password;
    }

    public void setPassword(String password) {
        this.student_password = password;
    }

    public String getEmail() {
        return student_email;
    }

    public void setEmail(String email) {
        this.student_email = email;
    }


    @Override
    public String toString() {
        return "Student{" +
                "student_database_ID=" + student_database_ID +
                ", student_id=" + student_id +
                ", student_name='" + student_name + '\'' +
                ", student_surname='" + student_surname + '\'' +
                ", student_email='" + student_email + '\'' +
                ", student_password='" + student_password + '\'' +
                '}';
    }
}
