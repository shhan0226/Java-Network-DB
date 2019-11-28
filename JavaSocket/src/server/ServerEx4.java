package server;

import java.net.InetAddress;
import java.net.UnknownHostException;

import java.io.IOException;
import java.net.ServerSocket;

import java.net.Socket;

import java.io.BufferedReader;
import java.io.InputStreamReader;


public class ServerEx4 {
	
	public static void main(String[] args) {
		/*Buffer Reader*******************************************************ex4*/
		System.out.println("example 4");
		ServerSocket server_soc = null;
		try{
			server_soc= new ServerSocket(8000);
			System.out.println("Server Ready ....(port: 8000)");
			
			Socket soc = server_soc.accept();
			System.out.println("connect user: " + soc);	
			
			
			//클라이언트에서 데이터 입력 받기
			BufferedReader in = new BufferedReader(new InputStreamReader(soc.getInputStream()));
			String data = in.readLine();
			System.out.println("recev data: " + data);
						
			soc.shutdownInput();  //입력 스트림 닫기
			soc.close();
			server_soc.close();
					
		}catch(IOException ex){
			System.out.println(" port is already open");
			System.exit(-1);
		}
	}

}
