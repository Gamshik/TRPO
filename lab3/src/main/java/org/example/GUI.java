package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;

public class GUI {
    public GUI(){

    }

    public void ShowAndStartGui(){
        JFrame frame = new JFrame("Бинарный поиск");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 150);
        frame.setResizable(false);

        NumberFormat intFormat = NumberFormat.getIntegerInstance();
        intFormat.setGroupingUsed(false);
        intFormat.setMaximumFractionDigits(0);

        JTextField inputArrField = new JTextField(20);
        JFormattedTextField inputTargetField = new JFormattedTextField(intFormat);

        JLabel labelForInputArr = new JLabel("Массив");
        labelForInputArr.setLabelFor(inputArrField);

        JLabel labelForInputTarget = new JLabel("Искомое число");
        labelForInputTarget.setLabelFor(inputTargetField);

        JButton submitButton = new JButton("Ок");
        JButton closeButton = new JButton("Закрыть");


        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String inputText = inputArrField.getText();
                String[] inputValues = inputText.split(","); // Split by comma
                int[] array = new int[inputValues.length];

                for (int i = 0; i < inputValues.length; i++) {
                    array[i] = Integer.parseInt(inputValues[i].trim());
                }

                long targetValue = (long) inputTargetField.getValue();
                int target = (int) targetValue;

                int result = BinarySearch.binarySearch(array, target);

                if (result == -2)
                    JOptionPane.showMessageDialog(frame, "Массив не отсортирован!");
                else if (result == -1)
                    JOptionPane.showMessageDialog(frame, "Число отсутствует в массиве!");
                else
                    JOptionPane.showMessageDialog(frame, "Индекс: " + result);
            }
        });

        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });

        JPanel panel = new JPanel(new GridLayout(3, 2));
        panel.add(labelForInputArr);
        panel.add(inputArrField);
        panel.add(labelForInputTarget);
        panel.add(inputTargetField);
        panel.add(submitButton);
        panel.add(closeButton);

        frame.add(panel);
        frame.setVisible(true);
    }
}
