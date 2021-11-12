<%@ page import="java.io.IOException" %>
<%@ page import="java.sql.Connection" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Create Student account</title>
    <link rel="stylesheet" type="text/css" href="createStudentAccount.css">

</head>

<body>

<div class="sign-up-form">

    <div class="heading-message">
        <h1>Welcome to the sign up page</h1>
    </div>

    <div class="sign-up-form">
        <form id="registration-form"  method="post" action="<%= request.getContextPath()%>/createStudentAccount"  >

            <ul class="list">
                <li>Name: <input type="text" id= "student_name" name="student_name" class="sign-up-form" placeholder="name_required"></li>
                <li>Surname: <input type = "text" id="student_surname" name="student_surname" class = "sign-up-form" placeholder= "surname_required" ></li>
                <li>Student Number <input type = "text" id="student_id" name= "student_id" class = "sign-up-form" placeholder="student_number"></li>
                <li>Email Address: <input type="text" id="student_email" name="student_email" class="sign-up-form" placeholder="your_email"></li>
                <li>Create Password: <input type="password" id="student_password" name="student_password" class="sign-up-form"  placeholder="create password"></li>
                <li>
                    <button type="submit" style="height:25px; width:175px; font-weight: bold" class="submit" onclick="SubmitRegistrationDetails()">SUBMIT
                    </button>
                </li>
                <li><p></p></li>
                <li><p></p></li>
            </ul>
        </form>
    </div>
    <div class="terms-message">
        <p>By signing up, you agree to the terms of the service.</p>
    </div>
</div>

</body>
</html>

<script>

    function SubmitRegistrationDetails() {
        debugger;
        var registrationDetails = {
            FirstName: document.getElementById("student_name").value,
            Surname: document.getElementById("student_surname").value,
            StudentID: document.getElementById("student_id").value,
            StudentEmail: document.getElementById("student_email").value,
            StudentPassword: document.getElementById("student_password").value
        };

        $.post("<%= request.getContextPath()%>/createStudentAccount", registrationDetails,response)


    }

</script>
