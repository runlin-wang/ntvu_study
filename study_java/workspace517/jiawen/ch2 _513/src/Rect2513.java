import javax.swing.JOptionPane;
public class Rect2513{
  public static void main(String[] args){
     String changString=JOptionPane.showInputDialog("�����볤:");
     String kuanString=JOptionPane.showInputDialog("�������:");
     double chang=Double.parseDouble(changString);
     double kuan=Double.parseDouble(kuanString);
     double zhouchang=chang*2+kuan*2;
     double mianji=chang*kuan;
     JOptionPane.showMessageDialog(null,"�ܳ�:"+zhouchang+"���:"+mianji);
   }
}