package SocketCommunication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
	
	public static void main(String[] args) throws UnknownHostException, IOException {
		Socket socket = new Socket("localhost", 10086);
		//��ȡ������������˷���Ϣ
		OutputStream out = socket.getOutputStream();
		PrintWriter pw = new PrintWriter(out);
		pw.write("����ʱ��");
		pw.flush();
		socket.shutdownOutput();
		
		//��ȡ����������ȡ���������͵���Ϣ
		InputStream in = socket.getInputStream();
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		String str = null;
		while((str = br.readLine()) != null){
			System.out.println("������˵  "+str);
		}
		//4���ر���Դ 
		br.close(); 
		in.close(); 
		pw.close(); 
		out.close(); 
		socket.close(); 
	}
}
