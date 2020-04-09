<%@ page import="javax.annotation.processing.Generated" %><%--
  Created by IntelliJ IDEA.
  User: racha
  Date: 2020/04/01
  Time: 13:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Main Page</title>
    <link rel="stylesheet" type="text/css" href="index.css">
  </head>

<body>


  <div class="form-container">
    <div class = "user"></div>
    <h1>Welcome to Cape Peninsula University of Technology Ticket System</h1>
    <ul class ="list">
    <li><a href='http://localhost:8080/AuditReportWebApplication_war_exploded/login.jsp'><button class="loginButton">Login</button></a></li>
    <li><a href='http://localhost:8080/AuditReportWebApplication_war_exploded/createStudentAccount.jsp'><button class="StudentAccountButton">Create Student account</button></a></li>
    <li><a href='http://localhost:8080/AuditReportWebApplication_war_exploded/createLecturerAccount.jsp'><button class="LecturerAccountButton">Create Lecturer account</button></a></li>
    <li><a href='http://localhost:8080/AuditReportWebApplication_war_exploded/forgotPassword.jsp'><button class="forgotPassButton">Forgot Password</button></a></li>
    </ul>
  </div>



  </body>
</html>

