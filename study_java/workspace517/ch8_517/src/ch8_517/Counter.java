package ch8_517;

import javax.swing.*;

import java.awt.*; 

public class Counter {
	JFrame frame;
	JPanel line1;
	JPanel line2;
	JPanel line3;
	JPanel line4;
	@SuppressWarnings("deprecation")
	public Counter() {
		frame = new JFrame("计算器");
		int i;
		line1 = new JPanel();
		line2 = new JPanel();
		line3 = new JPanel();
		line4 = new JPanel();
		
		for (i = 1; i <= 3; i++) {
			line1.add(new JButton(String.valueOf(i)));
		}
		
		for (i = 4; i <= 6; i++) {
			line2.add(new JButton(String.valueOf(i)));
		}
		
		for (i = 7; i <= 9; i++) {
			line3.add(new JButton(String.valueOf(i)));
		}
		
		line1.add(new JButton("+"));
		line2.add(new JButton("-"));
		line3.add(new JButton("*"));
		
		line4.add(new JButton("0"));
		line4.add(new JButton("."));
		line4.add(new JButton("="));
		line4.add(new JButton("/"));
		
		Container cp = frame.getContentPane();
		cp.setLayout(new FlowLayout());
		cp.add(line1);
		cp.add(line2);
		cp.add(line3);
		cp.add(line4);
		
		frame.setSize(300,350);
		frame.show();
	}
	public static void main(String[] args) {
		new MyFrame();
	}
}
