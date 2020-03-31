import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseAccessTest {

        public static void main(String[] args) {

            try {

                Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            }
            catch(ClassNotFoundException cnfex) {

                System.out.println("Problem in loading or "
                        + "registering MS Access JDBC driver");
                cnfex.printStackTrace();
            }
            System.out.println("GETTING CONNECTION");
            String databaseURL = "jdbc:ucanaccess://C://Users//Clayton Claassens//Documents//CPUT IT//3rd Year//Application Development Practice 3//AuditReportWebApplication//src//main//resources//AuditReportWebApp.accdb";

            try (Connection connection = DriverManager.getConnection(databaseURL)) {

                System.out.println("CONNECTED");
                String sql = "insert into UserAccessTable(StudentNumber, Email, Password) values(?, ?, ?)";

                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setInt(1, 217299695);
                preparedStatement.setString(2, "rohnj@herbalife.com");
                preparedStatement.setString(3, "0919989998");

                int row = preparedStatement.executeUpdate();

                if (row > 0) {
                    System.out.println("A row has been inserted successfully.");
                }

                sql = "SELECT * FROM UserAccessTable";

                Statement statement = connection.createStatement();
                ResultSet result = statement.executeQuery(sql);

                while (result.next()) {
                    int studentNumber = result.getInt("StudentNumber");
                    String email = result.getString("Email");
                    String password = result.getString("Password");

                    System.out.println(studentNumber + ", " + email + ", " + password);
                }

            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

