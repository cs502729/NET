package udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class server {

	public static void main(String[] args) throws IOException {
		DatagramSocket socket = new DatagramSocket(9999);
		
		//�������ݰ������ܿͻ��˷���������
		byte[] data = new byte[1024];
		DatagramPacket packet = new DatagramPacket(data,data.length);
		socket.receive(packet);
		//��ȡ����
		String str = new String(data,0,data.length);
		System.out.println("���Ƿ���ˣ��ͻ���˵��"+ str);
		
		//��ͻ�����Ӧ����
		InetAddress address = packet.getAddress();
		int port = packet.getPort();
		byte[] send = "server".getBytes();
		DatagramPacket packet2 = new DatagramPacket(send,send.length,address,port);
		socket.send(packet2);
		socket.close();
	}
}
