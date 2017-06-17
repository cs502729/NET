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
		//获取输出流，向服务端发消息
		OutputStream out = socket.getOutputStream();
		PrintWriter pw = new PrintWriter(out);
		pw.write("现在时间");
		pw.flush();
		socket.shutdownOutput();
		
		//获取输入流，读取服务器发送的消息
		InputStream in = socket.getInputStream();
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		String str = null;
		while((str = br.readLine()) != null){
			System.out.println("服务器说  "+str);
		}
		//4、关闭资源 
		br.close(); 
		in.close(); 
		pw.close(); 
		out.close(); 
		socket.close(); 
	}
}
