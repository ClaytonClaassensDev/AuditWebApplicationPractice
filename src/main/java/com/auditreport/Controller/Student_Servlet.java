package com.auditreport.Controller;

import com.auditreport.Model.Lecturer;
import com.auditreport.Model.Student;
import com.auditreport.Services.DOA;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/createStudentAccount")
public class Student_Servlet extends HttpServlet {

    DOA doa = new DOA();


    public Student_Servlet() {

        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.getWriter().append("Served at: ").append(req.getContextPath());

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/web/createStudentAccount.jsp");
        requestDispatcher.forward(req, resp);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        int student_id = request.getIntHeader("student_id");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        Student student = new Student();
        student.setName(name);
        student.setSurname(surname);
        student.setStudent_id(student_id);
        student.setEmail(email);
        student.setPassword(password);


        try {
            doa.addUserToStudentRecordsTable(student);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
