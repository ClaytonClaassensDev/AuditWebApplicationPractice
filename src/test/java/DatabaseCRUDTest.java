import org.junit.Assert;

import java.sql.*;

import static org.junit.Assert.*;

public class DatabaseCRUDTest {

    String databaseURL = "jdbc:ucanaccess://C://Users//Clayton Claassens//Documents//CPUT IT//3rd Year//Application Development Practice 3//AuditReportWebApplication//src//main//resources//AuditReportWebApp.accdb";

    DatabaseCRUD databaseCRUD = new DatabaseCRUD();

    @org.junit.Before
    public void setUp() throws Exception {


    }

    @org.junit.Test
    public void addUserToStudentRecordsTableTest() {

        try(Connection connection = DriverManager.getConnection(databaseURL)){

            int studentNumber = 123456789;
            String password = "thisIsTheTestingPassword!@#$%";
            String email = "987654321@testEmail.com";

            User user = new User(studentNumber, password, email);

            databaseCRUD.addUserToStudentRecordsTable(user);

            String sql = "SELECT StudentNumber, Email FROM StudentRecordsTable WHERE StudentNumber = "+studentNumber+"";

            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(sql);

            int studentNumberReturned = 0;
            String emailReturned = "";


            while(resultSet.next()){

                studentNumberReturned = resultSet.getInt("StudentNumber");
                emailReturned = resultSet.getString("Email");

            }

            Assert.assertTrue(studentNumber == studentNumberReturned);
            Assert.assertTrue(email == emailReturned);


        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @org.junit.Test
    public void addUserToStudentLoginVerificationTable() {
    }

    @org.junit.Test
    public void deleteUserFromStudentRecordsTable() {
    }

    @org.junit.Test
    public void deleteUserFromStudentLoginVerificationTable() {
    }

    @org.junit.Test
    public void searchUserInStudentRecordsTable() {
    }

    @org.junit.Test
    public void displayAllStudents() {
    }
}