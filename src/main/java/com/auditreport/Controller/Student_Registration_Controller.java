package com.auditreport.Controller;

import com.auditreport.Model.Student;
import com.auditreport.Model.StudentInfoReturn;
import com.auditreport.Services.RegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServlet;

@Controller
public class Student_Registration_Controller{



    public Student_Registration_Controller() {


    }

    @Autowired
    RegistrationRepository registration;

    @RequestMapping(value = "/createStudentAccount", method = RequestMethod.POST)
    public StudentInfoReturn createStudentAccount(@RequestBody Student student){

        StudentInfoReturn studentInfoReturn = new StudentInfoReturn();
        //registration.findStudentByStudent_id(student.getStudent_id());
        studentInfoReturn.setName(student.getName());
        studentInfoReturn.setSurname(student.getSurname());
        studentInfoReturn.setEmail(student.getEmail());
        studentInfoReturn.setStudent_id(student.getStudent_id());
        registration.save(student);

        return studentInfoReturn;
    }

}
