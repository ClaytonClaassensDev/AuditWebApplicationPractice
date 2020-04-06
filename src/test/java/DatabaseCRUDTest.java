import org.junit.Assert;

import java.sql.*;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class DatabaseCRUDTest {

    String databaseURL = "jdbc:ucanaccess://C://Users//Clayton Claassens//Documents//CPUT IT//3rd Year//Application Development Practice 3//AuditReportWebApplication//src//main//resources//AuditReportWebApp.accdb";

    DatabaseCRUD databaseCRUD = new DatabaseCRUD();

    int expected_studentNumber = 123456789;
    String expected_password = "thisIsTheTestingPassword!@#$%";
    String expected_email = "987654321@testEmail.com";

    User user = new User(expected_studentNumber, expected_password, expected_email);


    @org.junit.Before
    public void setUp() throws Exception {

    }

    @org.junit.Test
    public void addUserToStudentRecordsTableTest() {

        User returnedUser = null;

        try(Connection connection = DriverManager.getConnection(databaseURL)){

            databaseCRUD.addUserToStudentRecordsTable(user);

            String sql = "SELECT StudentNumber, Password, Email FROM StudentRecordsTable WHERE StudentNumber = "+user.getStudentNumber()+"";

            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(sql);

            int studentNumberReturned = 0;
            String passwordReturned = "";
            String emailReturned = "";


            while(resultSet.next()){

                studentNumberReturned = resultSet.getInt("StudentNumber");
                passwordReturned = resultSet.getString("Password");
                emailReturned = resultSet.getString("Email");

                returnedUser = new User(studentNumberReturned, passwordReturned, emailReturned);

            }

            Assert.assertEquals(user.getStudentNumber(), returnedUser.getStudentNumber());

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @org.junit.Test
    public void addUserToStudentLoginVerificationTableTest() {

        DatabaseCRUD databaseCRUD = new DatabaseCRUD();

        try(Connection connection = DriverManager.getConnection(databaseURL)){

            databaseCRUD.addUserToStudentLoginVerificationTable(expected_studentNumber, expected_password);

            String sql = "Select * from StudentLoginVerificationTable where StudentNumber = "+expected_studentNumber+"";

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            int studentNumberReturned = 0;
            String passwordReturned = "";

            while(resultSet.next()){

                studentNumberReturned = resultSet.getInt("StudentNumber");
                passwordReturned = resultSet.getString("Password");

            }

            Assert.assertTrue(expected_studentNumber == studentNumberReturned);
            Assert.assertTrue(expected_password == passwordReturned);

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @org.junit.Test
    public void deleteUserFromStudentRecordsTableTest() {

        DatabaseCRUD databaseCRUD = new DatabaseCRUD();

        User returnedUser = null;

        ArrayList<User> userList = new ArrayList<>();

        try(Connection connection = DriverManager.getConnection(databaseURL)){

            databaseCRUD.deleteUserFromStudentRecordsTable(user.getStudentNumber());

            String sql = "Select * from StudentRecordsTable";

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while(resultSet.next()){

                int returnedStudentNumber = resultSet.getInt(1);
                String returnedPassword = resultSet.getString(2);
                String returnedEmail = resultSet.getString(3);

                returnedUser = new User(returnedStudentNumber, returnedPassword, returnedEmail);

                userList.add(returnedUser);
            }

            boolean result = false;

            if(userList.contains(user)){
                result = true;
            }

            Assert.assertEquals(false, result);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @org.junit.Test
    public void deleteUserFromStudentLoginVerificationTableTest() {

        DatabaseCRUD databaseCRUD = new DatabaseCRUD();

        User returnedUser = null;

        ArrayList userList = new ArrayList<>();

        try(Connection connection = DriverManager.getConnection(databaseURL)){

            databaseCRUD.deleteUserFromStudentLoginVerificationTable(user.getStudentNumber());

            String sql = "Select * from StudentLoginVerificationTable";

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while(resultSet.next()){

                int returnedStudentNumber = resultSet.getInt(1);
                String returnedPassword = resultSet.getString(2);

                userList.add(returnedStudentNumber, returnedPassword);
            }

            boolean result = false;

            if(userList.contains(user.getStudentNumber())){
                result = true;
            }

            Assert.assertEquals(false, result);

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @org.junit.Test
    public void searchUserInStudentRecordsTable() {
    }

    @org.junit.Test
    public void displayAllStudents() {
    }
}