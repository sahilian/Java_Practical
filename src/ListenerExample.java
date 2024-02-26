import javax.swing.*;
import java.awt.event.*;

public class ListenerExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Listener Example");
        JButton button = new JButton("Click Me");
        JComboBox<String> comboBox = new JComboBox<>(new String[]{"Item 1", "Item 2", "Item 3"});

        // Button Click ActionListener
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("Button clicked");
            }
        });

        // Focus ActionListener
        button.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent e) {
                System.out.println("Button gained focus");
            }

            public void focusLost(FocusEvent e) {
                System.out.println("Button lost focus");
            }
        });

        // Mouse ActionListener for the frame
        frame.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                System.out.println("Mouse pressed on frame");
            }

            public void mouseReleased(MouseEvent e) {
                System.out.println("Mouse released on frame");
            }
        });

        // Item Listener
        comboBox.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    System.out.println("Selected: " + comboBox.getSelectedItem());
                }
            }
        });

        frame.getContentPane().add(button, "North");
        frame.getContentPane().add(comboBox, "South");
        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
