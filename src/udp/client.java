package udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class client {

	public static void main(String[] args) throws IOException {
		InetAddress address = InetAddress.getByName("localhost");
		int port = 9999;
		byte[] data = "lkjasd".getBytes();
		//创建数据包，发送信息
		DatagramPacket packet = new DatagramPacket(data, data.length, address,port);
		//创建DatagramSocket对象
		DatagramSocket socket = new DatagramSocket();
		socket.send(packet);
		
		
		//接受服务器 响应数据
		//创建数据包接受服务器返回的数据
		byte[] reveive = new byte[1024];
		DatagramPacket receivePacket = new DatagramPacket(reveive,reveive.length);
		//接收服务器响应的数据
		socket.receive(receivePacket);
		String reply = new String(reveive, 0, receivePacket.getLength());
		System.out.println("我是客户端：服务端说"+ reply);
		socket.close();
	}
}
