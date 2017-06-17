package Socket;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

public class client {

	static Socket server;  
	  
    public static void main(String[] args) throws Exception {  
    	server = new Socket(InetAddress.getLocalHost(), 7777);  
        BufferedReader br = new BufferedReader(new InputStreamReader(server.getInputStream()));  
        
        PrintWriter out = new PrintWriter(server.getOutputStream());  
        BufferedReader wt = new BufferedReader(new InputStreamReader(System.in));  
        while (true) {  
            String str = wt.readLine();  
            out.println("客户端： "+str);  
            out.flush();  
            if (str.equals("end")) {  
                break;  
            }  
            System.out.println("服务端："+br.readLine());  
        }  
        server.close();  
    }  
}
