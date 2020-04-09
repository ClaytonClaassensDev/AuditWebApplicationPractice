/*import com.auditreport.Services.DOA;
import com.auditreport.Model.Student;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.sql.*;
import java.util.ArrayList;

public class DOATest {

    String databaseURL = "jdbc:ucanaccess://C://Users//Clayton Claassens//Documents//CPUT IT//3rd Year//Application Development Practice 3//AuditReportWebApplication//src//main//resources//AuditReportWebApp.accdb";

    DOA databaseCRUD = new DOA();

    int expected_studentNumber = 123456789;
    String expected_password = "thisIsTheTestingPassword!@#$%";
    String expected_email = "987654321@testEmail.com";

    Student student = new Student(expected_studentNumber, expected_password, expected_email);


    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void addUserToStudentRecordsTableTest() {

        Student studentReturned = null;

        try(Connection connection = DriverManager.getConnection(databaseURL)){

            databaseCRUD.addUserToStudentRecordsTable(student);

            String sql = "SELECT StudentNumber, Password, Email FROM StudentRecordsTable WHERE StudentNumber = "+student.getStudentNumber()+"";

            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(sql);

            int studentNumberReturned = 0;
            String passwordReturned = "";
            String emailReturned = "";


            while(resultSet.next()){

                studentNumberReturned = resultSet.getInt("StudentNumber");
                passwordReturned = resultSet.getString("com.auditreport.Password");
                emailReturned = resultSet.getString("Email");

                studentReturned = new Student(studentNumberReturned, passwordReturned, emailReturned);

            }

            Assert.assertEquals(student.getStudentNumber(), studentReturned.getStudentNumber());

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void addUserToStudentLoginVerificationTableTest() {

        DOA databaseCRUD = new DOA();

        try(Connection connection = DriverManager.getConnection(databaseURL)){

            databaseCRUD.addUserToStudentLoginVerificationTable(expected_studentNumber, expected_password);

            String sql = "Select * from StudentLoginVerificationTable where StudentNumber = "+expected_studentNumber+"";

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            int studentNumberReturned = 0;
            String passwordReturned = "";

            while(resultSet.next()){

                studentNumberReturned = resultSet.getInt("StudentNumber");
                passwordReturned = resultSet.getString("com.auditreport.Password");

            }

            Assert.assertTrue(expected_studentNumber == studentNumberReturned);
            Assert.assertTrue(expected_password == passwordReturned);

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void deleteUserFromStudentRecordsTableTest() {

        DOA databaseCRUD = new DOA();

        Student studentReturned = null;

        ArrayList<Student> userList = new ArrayList<>();

        try(Connection connection = DriverManager.getConnection(databaseURL)){

            databaseCRUD.deleteUserFromStudentRecordsTable(student.getStudentNumber());

            String sql = "Select * from StudentRecordsTable";

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while(resultSet.next()){

                int returnedStudentNumber = resultSet.getInt(1);
                String returnedPassword = resultSet.getString(2);
                String returnedEmail = resultSet.getString(3);

                studentReturned = new Student(returnedStudentNumber, returnedPassword, returnedEmail);

                userList.add(studentReturned);
            }

            boolean result = false;

            if(userList.contains(student)){
                result = true;
            }

            Assert.assertEquals(false, result);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void deleteUserFromStudentLoginVerificationTableTest() {

        DOA databaseCRUD = new DOA();

        Student studentReturned = null;

        ArrayList userList = new ArrayList<>();

        try(Connection connection = DriverManager.getConnection(databaseURL)){

            databaseCRUD.deleteUserFromStudentLoginVerificationTable(student.getStudentNumber());

            String sql = "Select * from StudentLoginVerificationTable";

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while(resultSet.next()){

                int returnedStudentNumber = resultSet.getInt(1);
                String returnedPassword = resultSet.getString(2);

                userList.add(returnedStudentNumber, returnedPassword);
            }

            boolean result = false;

            if(userList.contains(student.getStudentNumber())){
                result = true;
            }

            Assert.assertEquals(false, result);

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void searchUserInStudentRecordsTable() {
    }

    @Test
    public void displayAllStudents() {
    }
}

 */