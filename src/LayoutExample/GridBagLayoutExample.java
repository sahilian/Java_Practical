package LayoutExample;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

public class GridBagLayoutExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("GridBagLayout Example");
        frame.setLayout(new GridBagLayout());
        frame.setSize(300, 200);

        GridBagConstraints constraints = new GridBagConstraints();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                constraints.gridx = j;
                constraints.gridy = i;
                frame.add(new JButton("Button " + (i * 3 + j + 1)), constraints);
            }
        }

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
