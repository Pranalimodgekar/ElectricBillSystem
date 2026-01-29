/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.electricbillsystem1;

/**
 *
 * @author DELL
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ElectricBillSystem1 extends JFrame {
    private JTextField customerName, unitsConsumed;
    private JComboBox<String> customerType;
    private JButton calculateButton;
    private JLabel resultLabel;

    public ElectricBillSystem1() {
        setLayout(new FlowLayout());

        add(new JLabel("Customer Name:"));
        customerName = new JTextField(20);
        add(customerName);

        add(new JLabel("Units Consumed:"));
        unitsConsumed = new JTextField(10);
        add(unitsConsumed);

        String[] types = {"Domestic", "Commercial"};
        customerType = new JComboBox<>(types);
        add(customerType);

        calculateButton = new JButton("Calculate Bill");
        calculateButton.addActionListener(new CalculateListener());
        add(calculateButton);

        resultLabel = new JLabel("");
        add(resultLabel);

        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private class CalculateListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                String name = customerName.getText();
                int units = Integer.parseInt(unitsConsumed.getText());
                String type = (String) customerType.getSelectedItem();
                double bill = calculateBill(units, type);
                resultLabel.setText(name + "'s bill: ₹" + bill);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Invalid input!");
            }
        }
    }

    private double calculateBill(int units, String type) {
        double rate = type.equals("Domestic") ? 5.0 : 10.0;
        return units * rate;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ElectricBillSystem1());
    }
}