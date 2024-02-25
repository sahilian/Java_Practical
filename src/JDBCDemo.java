import java.sql.*;

public class JDBCDemo {
    public static void main(String[] args) {
        // JDBC URL, username, and password
        String url = "jdbc:mysql://localhost:3306/movierentalsystem";
        String username = "root";
        String password = "";

        // SQL query
        String query = "SELECT * FROM movie";

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
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("Title");
                String genre = resultSet.getString("Genre");
                String title = resultSet.getString("Title");
                int length = resultSet.getInt("Length");
                System.out.println("ID: " + id + ", Name: " + name + ", Salary: " + length + " min");
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
