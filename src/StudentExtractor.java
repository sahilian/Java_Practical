import java.sql.*;

public class StudentExtractor {
    public static void main(String[] args) {
        // JDBC URL, username, and password
        String url = "jdbc:mysql://localhost:3306/StudentDb";
        String username = "root";
        String password = "";

        // SQL query to select students living in Kathmandu district
        String query = "SELECT name FROM student WHERE district = 'Kathmandu'";

        try {
            // Load and register the JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish connection to the database
            Connection connection = DriverManager.getConnection(url, username, password);

            // Create a statement
            Statement statement = connection.createStatement();

            // Execute the SQL query and get the ResultSet
            ResultSet resultSet = statement.executeQuery(query);

            // Process the ResultSet
            System.out.println("Names of students living in Kathmandu district:");
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                System.out.println(name);
            }

            // Close resources
            resultSet.close();
            statement.close();
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
