package client;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

import javax.imageio.ImageIO;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

import java.util.*;

public class ClientEx3 {
	
	public static void main(String[] args) {
		/*server_connection**************************************************/
		
		InetAddress remote_addr=null;
		Socket soc = null;
		
		try{
			remote_addr = InetAddress.getLocalHost();
			soc = new Socket(remote_addr, 8000);
			System.out.println("compelete connect!");
			
		}catch(IOException ex){
			System.out.println("server error :"+ex.getLocalizedMessage());
			System.exit(-1);
			
		}
		
	}

}
