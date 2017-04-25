package client;

import javax.swing.*;
import java.awt.*;

public class ClientCall{
	public static void main(String[] args){

		JFrame frame=new JFrame("CALCULATOR");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.setLayout(new BorderLayout());
		JTextField screen=new JTextField();
		screen.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 24));
		frame.add(screen, BorderLayout.NORTH);
		
		JPanel buttonPane=new JPanel(new GridLayout(5,4));
		buttonPane.setSize(new Dimension(400,400));
		buttonPane.add(new JButton("C"));
		buttonPane.add(new JButton("/"));
		buttonPane.add(new JButton("X"));
		buttonPane.add(new JButton("Bsk"));
		
		buttonPane.add(new JButton("7"));
		buttonPane.add(new JButton("8"));
		buttonPane.add(new JButton("9"));
		buttonPane.add(new JButton("-"));

		buttonPane.add(new JButton("4"));
		buttonPane.add(new JButton("5"));
		buttonPane.add(new JButton("6"));
		buttonPane.add(new JButton("+"));
		
		buttonPane.add(new JButton("1"));
		buttonPane.add(new JButton("2"));
		buttonPane.add(new JButton("3"));
		buttonPane.add(new JButton("()"));

		buttonPane.add(new JButton("0"));
		buttonPane.add(new JButton("."));
		buttonPane.add(new JButton("+/-"));
		buttonPane.add(new JButton("="));

		frame.add(buttonPane, BorderLayout.CENTER);
		frame.pack();
		frame.setVisible(true);

		CalculatorImplService service=new CalculatorImplService();
		Operations port=service.getCalculatorImplPort();

		System.out.println("2+3="+port.add(2,3));



	}
}