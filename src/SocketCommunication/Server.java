package SocketCommunication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class Server {

	public static void main(String[] args) throws IOException {
		ServerSocket serverSocket = new ServerSocket(10086);// 1024-65535��ĳ���˿�
		// 2������accept()������ʼ�������ȴ��ͻ��˵�����
		Socket socket = serverSocket.accept();
		// 3����ȡ������������ȡ�ͻ�����Ϣ
		InputStream in = socket.getInputStream();
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		String str = null;
		while((str = br.readLine())!= null){
			System.out.println("�ͻ��ˣ�"+str);
		}
		socket.shutdownInput();
	
		// 4����ȡ���������Ӧ�ͻ��˵�����
		OutputStream out = socket.getOutputStream();
		PrintWriter pw = new PrintWriter(out);
		
		pw.write(new Date().toString());
		pw.flush();

		// 5���ر���Դ
		pw.close();
		out.close();
		br.close();
		br.close();
		in.close();
		socket.close();
		serverSocket.close();

	}
}
