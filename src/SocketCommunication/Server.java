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
		ServerSocket serverSocket = new ServerSocket(10086);// 1024-65535的某个端口
		// 2、调用accept()方法开始监听，等待客户端的连接
		Socket socket = serverSocket.accept();
		// 3、获取输入流，并读取客户端信息
		InputStream in = socket.getInputStream();
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		String str = null;
		while((str = br.readLine())!= null){
			System.out.println("客户端："+str);
		}
		socket.shutdownInput();
	
		// 4、获取输出流，响应客户端的请求
		OutputStream out = socket.getOutputStream();
		PrintWriter pw = new PrintWriter(out);
		
		pw.write(new Date().toString());
		pw.flush();

		// 5、关闭资源
		pw.close();
		out.close();
		br.close();
		br.close();
		in.close();
		socket.close();
		serverSocket.close();

	}
}
