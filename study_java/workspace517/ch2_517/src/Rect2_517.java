import javax.swing.JOptionPane;

public class Rect2_517 {
	public static void main(String[] args) {

		String lengthString = JOptionPane.showInputDialog("Please input length");
		String wideString = JOptionPane.showInputDialog("Please input length");
		
		double length = Double.parseDouble(lengthString);
		double wide = Double.parseDouble(wideString);

		double girth = (length + wide) * 2;
		double area = length * wide;

		JOptionPane.showConfirmDialog(null, "girth = " + girth + "\narea = " + area);

	}
}
