package netDemo;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class TCPlient {
	public static void main(string[] args) throws IOException {
		// * 1.����һ���ͻ��˶���Socket�����췽���󶨷�������IP��ַ�Ͷ˿ں�
		Socket socket = new Socket("10.18.65.193", 8889);

		// * 2.ʹ��Socket�����еķ���getOutputStream������ȡ�����ֽ������OutputStream����
		OutputStream outputStream = socket.getOutputStream();

		// * 3.ʹ�������ֽ������OutputStream�����еķ���write������������������
		outputStream.write("there is no choice but to learn".getBytes());

		// * 4.ʹ��Socket�����еķ���getInputStream()��ȡ�����ֽ�������InputStream����
		InputStream inputStream = socket.getInputStream();

		// * 5.ʹ�������ֽ�������InputStream�����еķ���read����ȡ��������д������
		byte[] bytes = new byte[1024];
		int len = inputStream.read(bytes);

		System.out.println(new String(bytes, 0, len));

		// * 6.�ͷ���Դ��Socket��

		socket.close();

	}

}
