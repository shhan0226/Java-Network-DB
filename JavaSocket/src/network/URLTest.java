package network;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class URLTest {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			
			//URL °´Ã¼ »ý¼º
			URL home = new URL("http://ucloud-lab.dongguk.edu");
			BufferedReader br;
			String line;
			
			System.out.println("Port: " + home.getPort());
			System.out.println("Protocol: " + home.getProtocol());
			System.out.println("HostName: " + home.getHost());
			System.out.println("File: " + home.getFile());
			System.out.println("Ref: " + home.getRef());
			
			br = new BufferedReader(new InputStreamReader(home.openStream()));
			
			while( (line = br.readLine()) != null) {
				System.out.println(line);
			}
			br.close();
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Exception : " + e);
		}

	}

}
