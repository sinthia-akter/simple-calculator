package simple.calculator;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SimpleCalculator extends JFrame implements ActionListener {

    private final JTextField number1;
    private final JTextField number2;
    private final JTextField resultField;
    private final JButton addButton;
    private final JButton subtractButton;
    private final JButton multiplyButton;
    private final JButton divideButton;
    private final JButton clearButton;
    

    public SimpleCalculator() {
        setTitle("Simple Calculator");
        setSize(450, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        setLocationRelativeTo(null);

        JLabel titleLabel = new JLabel("edSlash Coding Hub Calculator");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        titleLabel.setBounds(90, 10, 300, 30);
        add(titleLabel);

        JLabel number1Label = new JLabel("Number 1:");
        number1Label.setBounds(50, 60, 100, 25);
        add(number1Label);

        number1 = new JTextField();
        number1.setBounds(150, 60, 200, 25);
        add(number1);

        JLabel number2Label = new JLabel("Number 2:");
        number2Label.setBounds(50, 100, 100, 25);
        add(number2Label);

        number2 = new JTextField();
        number2.setBounds(150, 100, 200, 25);
        add(number2);

        JLabel resultLabel = new JLabel("Result:");
        resultLabel.setBounds(50, 140, 100, 25);
        add(resultLabel);

        resultField = new JTextField();
        resultField.setBounds(150, 140, 200, 25);
        resultField.setEditable(false);
        add(resultField);

        addButton = new JButton("Add");
        addButton.setBounds(10, 200, 80, 30);
        addButton.addActionListener(this);
        add(addButton);

        subtractButton = new JButton("Subtract");
        subtractButton.setBounds(95, 200, 80, 30);
        subtractButton.addActionListener(this);
        add(subtractButton);

        multiplyButton = new JButton("Multiply");
        multiplyButton.setBounds(180, 200, 80, 30);
        multiplyButton.addActionListener(this);
        add(multiplyButton);

        divideButton = new JButton("Divide");
        divideButton.setBounds(265, 200, 80, 30);
        divideButton.addActionListener(this);
        add(divideButton);

        clearButton = new JButton("Clear");
        clearButton.setBounds(350, 200, 80, 30);
        clearButton.addActionListener(this);
        add(clearButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            if (e.getSource() == clearButton) {
                number1.setText("");
                number2.setText("");
                resultField.setText("");
                return;
            }

            double num1 = Double.parseDouble(number1.getText().trim());
            double num2 = Double.parseDouble(number2.getText().trim());
            double result = 0;

            if (e.getSource() == addButton) {
                result = num1 + num2;
            } else if (e.getSource() == subtractButton) {
                result = num1 - num2;
            } else if (e.getSource() == multiplyButton) {
                result = num1 * num2;
            } else if (e.getSource() == divideButton) {
                if (num2 == 0) {
                    JOptionPane.showMessageDialog(this, "Cannot be divided by zero", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                result = num1 / num2;
            }

            resultField.setText(String.valueOf(result));
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter valid number", "Input Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new SimpleCalculator().setVisible(true);
        });
    }
}