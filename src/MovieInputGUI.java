import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class MovieInputGUI extends JFrame implements ActionListener {

    private JTextField titleField, genreField, languageField, lengthField;
    private JButton submitButton;

    public MovieInputGUI() {
        super("Movie Input Form");

        // Create labels and text fields
        JLabel titleLabel = new JLabel("Title:");
        titleField = new JTextField(20);

        JLabel genreLabel = new JLabel("Genre:");
        genreField = new JTextField(20);

        JLabel languageLabel = new JLabel("Language:");
        languageField = new JTextField(20);

        JLabel lengthLabel = new JLabel("Length (mins):");
        lengthField = new JTextField(20);

        // Create submit button
        submitButton = new JButton("Submit");
        submitButton.addActionListener(this);

        // Arrange components in layout
        JPanel panel = new JPanel(new GridLayout(5, 2, 5, 5));
        panel.add(titleLabel);
        panel.add(titleField);
        panel.add(genreLabel);
        panel.add(genreField);
        panel.add(languageLabel);
        panel.add(languageField);
        panel.add(lengthLabel);
        panel.add(lengthField);
        panel.add(submitButton);

        add(panel);

        pack();
        setVisible(true);

        // Load MySQL driver
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error: MySQL Driver not found!");
            System.exit(1);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submitButton) {
            String title = titleField.getText();
            String genre = genreField.getText();
            String language = languageField.getText();
            int length = Integer.parseInt(lengthField.getText());

            // Database connection and insertion logic
            Connection connection = null;
            PreparedStatement statement = null;

            try {
                // Replace with your database credentials
                String url = "jdbc:mysql://localhost:3306/MovieRentalSystem";
                String user = "root";
                String password = "";

                connection = DriverManager.getConnection(url, user, password);
                String sql = "INSERT INTO Movie (title, genre, language, length) VALUES (?, ?, ?, ?)";
                statement = connection.prepareStatement(sql);
                statement.setString(1, title);
                statement.setString(2, genre);
                statement.setString(3, language);
                statement.setInt(4, length);
                statement.executeUpdate();

                JOptionPane.showMessageDialog(this, "Movie added successfully!");

                // Clear input fields
                titleField.setText("");
                genreField.setText("");
                languageField.setText("");
                lengthField.setText("");
            } catch (SQLException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
            } finally {
                try {
                    if (statement != null) {
                        statement.close();
                    }
                    if (connection != null) {
                        connection.close();
                    }
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        new MovieInputGUI();
    }
}
