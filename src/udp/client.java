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
		//�������ݰ���������Ϣ
		DatagramPacket packet = new DatagramPacket(data, data.length, address,port);
		//����DatagramSocket����
		DatagramSocket socket = new DatagramSocket();
		socket.send(packet);
		
		
		//���ܷ����� ��Ӧ����
		//�������ݰ����ܷ��������ص�����
		byte[] reveive = new byte[1024];
		DatagramPacket receivePacket = new DatagramPacket(reveive,reveive.length);
		//���շ�������Ӧ������
		socket.receive(receivePacket);
		String reply = new String(reveive, 0, receivePacket.getLength());
		System.out.println("���ǿͻ��ˣ������˵"+ reply);
		socket.close();
	}
}
