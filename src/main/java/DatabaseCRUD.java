import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;

public class DatabaseCRUD {

    String databaseURL = "jdbc:ucanaccess://C://Users//Clayton Claassens//Documents//CPUT IT//3rd Year//Application Development Practice 3//AuditReportWebApplication//src//main//resources//AuditReportWebApp.accdb";

    User user;

    public DatabaseCRUD(){



    }


    public void addUserToStudentRecordsTable(User user){

        try (Connection connection = DriverManager.getConnection(databaseURL)) {

            String sql = "insert into StudentRecordsTable(StudentNumber, Password, Email) values(?, ?, ?)";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, user.getStudentNumber());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getEmail());

            //addUserToStudentLoginVerificationTable(user.getStudentNumber(), user.getPassword());

            int row = preparedStatement.executeUpdate();

            if (row > 0) {
                System.out.println("A row has been inserted successfully.");
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void addUserToStudentLoginVerificationTable(int studentNumber, String password) {

        try (Connection connection = DriverManager.getConnection(databaseURL)) {

            String sql = "insert into StudentLoginVerificationTable(StudentNumber, Password) values(?, ?)";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, studentNumber);
            preparedStatement.setString(2, password);

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

        public void deleteUserFromStudentRecordsTable(int studentNumber){


        try(Connection connection = DriverManager.getConnection(databaseURL)){

            String sql = "DELETE FROM StudentRecordsTable WHERE StudentNumber = "+studentNumber+"";

            Statement statement = connection.createStatement();

            statement.executeUpdate(sql);

            deleteUserFromStudentLoginVerificationTable(studentNumber);

            System.out.println("User deleted successfully");

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void deleteUserFromStudentLoginVerificationTable(int studentNumber){


        try(Connection connection = DriverManager.getConnection(databaseURL)){

            String sql = "DELETE FROM StudentLoginVerificationTable WHERE StudentNumber = "+studentNumber+"";

            Statement statement = connection.createStatement();

            statement.executeUpdate(sql);

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    public void searchUserInStudentRecordsTable(int studentNumber){

        int studentNum = 0;
        String email = "";
        try(Connection connection = DriverManager.getConnection(databaseURL)){

            String sql = "SELECT StudentNumber, Email FROM StudentRecordsTable WHERE StudentNumber = "+studentNumber+"";

            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(sql);

            while(resultSet.next()){

                studentNum = resultSet.getInt(1);
                email = resultSet.getString(3);

            }

            JOptionPane.showMessageDialog(null, "User: "+ studentNum + ", " + email);


        } catch (SQLException e) {
            e.printStackTrace();
        }

    }




    public ArrayList displayAllStudents(){

        ArrayList studentList = new ArrayList();

        try(Connection connection = DriverManager.getConnection(databaseURL)){

            String sql = "Select * From StudentRecordsTable";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){

                int studentNumber = resultSet.getInt("StudentNumber");
                String email = resultSet.getString("Email");

                studentList.add(studentNumber+" "+email);

            }


        } catch (SQLException e) {
            e.printStackTrace();
        }

        Collections.sort(studentList);
        System.out.println(studentList);

        return studentList;

    }



}
