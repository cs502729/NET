package Socket;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Daytime {

	public Date getDateFromNet() throws IOException, Throwable{
		Socket socket = new Socket("localhost",10000);
		socket.setSoTimeout(15000);
		InputStream is = socket.getInputStream();
		
		BufferedInputStream bs = new BufferedInputStream(is);
		InputStreamReader isr = new InputStreamReader(bs);
		StringBuilder sb = new StringBuilder();
		int c;
		while(( c = isr.read())!= -1){
			sb.append((char) c);
		}
		return parseDate(sb.toString());
	}
	static  Date parseDate(String s) throws ParseException{
		String[] pieces = s.split(" ");
		String datetime = pieces[1] + " " + pieces[2] + " UTC";
		DateFormat formate = new SimpleDateFormat("yy-MM-dd hh:mm:ss z");
		return formate.parse(datetime);
	}
	public static void main(String[] args) throws IOException, Throwable {
		System.out.println(new Daytime().getDateFromNet());
	}
}
