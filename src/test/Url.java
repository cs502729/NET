package test;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class Url {

	public static void main(String[] args) throws IOException {
		URL url = new URL("http://jingyan.baidu.com/article/647f01159e93ea7f2148a8fc.html");
		URLConnection uc = url.openConnection();
		InputStream is = uc.getInputStream();
		InputStream buffer = new BufferedInputStream(is);
		InputStreamReader ir = new InputStreamReader(buffer);
		int c;
		while((c = ir.read()) != -1){
			System.out.print((char)c);
		}
			
		
	}
}
