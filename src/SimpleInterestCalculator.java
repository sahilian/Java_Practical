import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SimpleInterestCalculator extends JFrame implements ActionListener {

    private JLabel principalLabel, rateLabel, timeLabel, siLabel;
    private JTextField principalField, rateField, timeField, siField;
    private JButton calculateButton;

    public SimpleInterestCalculator() {
        super("Simple Interest Calculator");

        // Create labels
        principalLabel = new JLabel("Principal:");
        rateLabel = new JLabel("Rate (%):");
        timeLabel = new JLabel("Time (years):");
        siLabel = new JLabel("Simple Interest:");

        // Create text fields
        principalField = new JTextField(10);
        rateField = new JTextField(10);
        timeField = new JTextField(10);
        siField = new JTextField(10);
        siField.setEditable(false); // Set output field to non-editable

        // Create button
        calculateButton = new JButton("Calculate");
        calculateButton.addActionListener(this);

        // Arrange components in layout
        JPanel panel = new JPanel(new GridLayout(5, 2, 5, 5));
        panel.add(principalLabel);
        panel.add(principalField);
        panel.add(rateLabel);
        panel.add(rateField);
        panel.add(timeLabel);
        panel.add(timeField);
        panel.add(siLabel);
        panel.add(siField);
        panel.add(calculateButton);

        add(panel);

        pack();
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == calculateButton) {
            try {
                double principal = Double.parseDouble(principalField.getText());
                double rate = Double.parseDouble(rateField.getText());
                double time = Double.parseDouble(timeField.getText());

                double si = (principal * rate * time) / 100;

                siField.setText(String.format("%.2f", si)); // Format output with 2 decimal places
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Invalid input! Please enter valid numbers.");
            }
        }
    }

    public static void main(String[] args) {
        new SimpleInterestCalculator();
    }
}
