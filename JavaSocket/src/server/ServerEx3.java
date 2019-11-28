package server;

import java.net.InetAddress;
import java.net.UnknownHostException;

import java.io.IOException;
import java.net.ServerSocket;

import java.net.Socket;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ServerEx3 {
	
	public static void main(String[] args) {
		/*Port_connection*****************************************************ex3*/
		System.out.println("example 3");
		ServerSocket server_soc = null;
			try{
				server_soc= new ServerSocket(8000);
				System.out.println("Server Ready ....(port: 8000)");
				
				Socket soc = server_soc.accept();
				System.out.println("connect user: " + soc);		
			}catch(IOException ex){
				System.out.println(" port is already open");
				System.exit(-1);
			}
	}


}
