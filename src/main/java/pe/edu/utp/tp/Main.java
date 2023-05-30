package pe.edu.utp.tp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class Main {

	private static JButton[] createOperationButtons(JFrame frame, JTextField n1, JTextField n2) {
		JButton[] buttons = {
				new JButton("+"),
				new JButton("-"),
				new JButton("*"),
				new JButton("/"),
				new JButton("^"),
				new JButton("sqrt"),
				new JButton("max()"),
				new JButton("min()"),
				new JButton("%"),
		};

		ActionListener operations = e -> {
			double num1 = Double.parseDouble(n1.getText());
			double num2 = Double.parseDouble(n2.getText());
			double result = 0;

			if (e.getSource() == buttons[0]) {
				result = num1 + num2;
			} else if (e.getSource() == buttons[1]) {
				result = num1 - num2;
			} else if (e.getSource() == buttons[2]) {
				result = num1 * num2;
			} else if (e.getSource() == buttons[3]) {
				result = num1 / num2;
			} else if (e.getSource() == buttons[4]) {
				result = Math.pow(num1, num2);
			} else if (e.getSource() == buttons[5]) {
				result = Math.pow(num1, 1/num2);
			} else if (e.getSource() == buttons[6]) {
				result = Math.max(num1, num2);
			} else if (e.getSource() == buttons[7]) {
				result = Math.min(num1, num2);
			} else {
				result = num1 % num2;
			}

			JOptionPane.showMessageDialog(frame, result);
		};

		for (JButton btn : buttons)
			btn.addActionListener(operations);

		return buttons;
	}

	public static void main(String[] args) {
		JFrame appFrame = new JFrame("Calculadora");
		appFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JTextField n1 = new JTextField(20);
		JTextField n2 = new JTextField(20);

		JButton[] buttons = createOperationButtons(appFrame, n1, n2);

		JPanel mainPanel = new JPanel();
		JPanel buttonsPanel = new JPanel();
		JPanel inputPanel = new JPanel();

		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		buttonsPanel.setLayout(new GridLayout(3,3));

		for ( JButton btn : buttons )
			buttonsPanel.add(btn);

		inputPanel.add(n1);
		inputPanel.add(n2);

		mainPanel.add(inputPanel);
		mainPanel.add(buttonsPanel);

		appFrame.getContentPane().add(mainPanel);
		appFrame.pack();
		appFrame.setVisible(true);
	}
}