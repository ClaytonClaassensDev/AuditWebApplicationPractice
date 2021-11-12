package com.auditreport.Model;

import org.springframework.stereotype.Component;

import javax.persistence.*;

@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int student_database_ID;

    @Column(name = "Student_ID")
    private int student_id;

    @Column(name = "Name")
    private String student_name;

    @Column(name = "Surname")
    private String student_surname;

    @Column(name = "Email")
    private String student_email;

    @Column(name = "Password")
    private String student_password;

       public Student(int student_id, String password, String email){

        this.student_id = student_id;
        this.student_email = email;
        this.student_password = password;

    }

    public Student() {

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
