package Socket;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class DaytimeServer {

	public static void main(String[] args) throws IOException {
		ServerSocket server = new ServerSocket(10000);
		System.out.println(server.getInetAddress().getHostName()+"Æô¶¯");
		Socket con = null;
		try{
			while(true){
				con = server.accept();
				Writer out = new OutputStreamWriter(con.getOutputStream());
				out.write(new Date().toString()+"   ");
				out.flush();
			}
		}
		catch(IOException e){
			e.printStackTrace();
		}
		finally{
			if(con != null)
				con.close();
		}
	}
}
