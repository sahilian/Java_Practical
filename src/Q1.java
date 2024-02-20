import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Q1 extends JFrame implements ActionListener {
    private JTextField inputField;
    private JLabel inputLabel;
    private JButton palindromeButton, reverseButton, vowelsButton;

    public Q1() {
        setTitle("String Operations");
        setLayout(new FlowLayout());

        inputLabel = new JLabel("Input any String: ");
        add(inputLabel);

        inputField = new JTextField(20);
        add(inputField);

        palindromeButton = new JButton("Check Palindrome");
        palindromeButton.addActionListener(this);
        add(palindromeButton);

        reverseButton = new JButton("Reverse");
        reverseButton.addActionListener(this);
        add(reverseButton);

        vowelsButton = new JButton("Find Vowels");
        vowelsButton.addActionListener(this);
        add(vowelsButton);

        setSize(300, 150);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public boolean isPalindrome(String str) {
        String reversedStr = new StringBuilder(str).reverse().toString();
        return str.equalsIgnoreCase(reversedStr);
    }

    public String reverse(String str) {
        return new StringBuilder(str).reverse().toString();
    }

    public String findVowels(String str) {
        String vowels = "";
        for (char c : str.toLowerCase().toCharArray()) {
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                vowels += c;
            }
        }
        return vowels;
    }

    public void actionPerformed(ActionEvent e) {
        String input = inputField.getText();
        if (e.getSource() == palindromeButton) {
            if (isPalindrome(input)) {
                JOptionPane.showMessageDialog(this, input + " is a palindrome.");
            } else {
                JOptionPane.showMessageDialog(this, input + " is not a palindrome.");
            }
        } else if (e.getSource() == reverseButton) {
            JOptionPane.showMessageDialog(this, "Reversed string: " + reverse(input));
        } else if (e.getSource() == vowelsButton) {
            JOptionPane.showMessageDialog(this, "Vowels in the string: " + findVowels(input));
        }
    }

    public static void main(String[] args) {
        new Q1();
    }
}