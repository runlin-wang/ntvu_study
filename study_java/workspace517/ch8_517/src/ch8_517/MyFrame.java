package ch8_517;

import javax.swing.*;

import java.awt.*;

public class MyFrame {
	JFrame frame;
	JPanel panel1;
	JPanel panel2;
	@SuppressWarnings("deprecation")
	public MyFrame() {
		frame = new JFrame("FlowLayout");
		
		panel1 = new JPanel();
		for (int i = 0; i < 6; i++) {
			panel1.add(new JButton(String.valueOf(i)));
		}
		panel2 = new JPanel();
		for (int i = 6; i < 10; i++) {
			panel2.add(new JButton(String.valueOf(i)));
		}
		Container cp = frame.getContentPane();
		cp.setLayout(new FlowLayout());
		cp.add(panel1);
		cp.add(panel2);
		
		frame.setSize(300,350);
		frame.show();
	}
	public static void main(String[] args) {
		new MyFrame();
	}
}
