package udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class server {

	public static void main(String[] args) throws IOException {
		DatagramSocket socket = new DatagramSocket(9999);
		
		//创建数据包，接受客户端发来的数据
		byte[] data = new byte[1024];
		DatagramPacket packet = new DatagramPacket(data,data.length);
		socket.receive(packet);
		//读取数据
		String str = new String(data,0,data.length);
		System.out.println("我是服务端，客户端说："+ str);
		
		//向客户端响应数据
		InetAddress address = packet.getAddress();
		int port = packet.getPort();
		byte[] send = "server".getBytes();
		DatagramPacket packet2 = new DatagramPacket(send,send.length,address,port);
		socket.send(packet2);
		socket.close();
	}
}
