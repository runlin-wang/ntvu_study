import javax.swing.JOptionPane;
public class MyFirst {
	public static void main(String args[]) {
		String nStr = JOptionPane.showInputDialog("输入第一个数："); /*打开输入对话框*/
		String mStr = JOptionPane.showInputDialog("输入第二个数：");//打开输入对话框
		int m = Integer.parseInt(mStr);//将数字文本转换成整数
		int n = Integer.parseInt(nStr);
		JOptionPane.showMessageDialog(null, "和 = " + (n + m) + ",差 = " + (n - m) + ",积 = " + n * m + ",商 = " + n / m,"结果",JOptionPane.PLAIN_MESSAGE);
		System.exit(0);
	}
}
