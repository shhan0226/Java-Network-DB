package server;

import java.net.InetAddress;
import java.net.UnknownHostException;

import java.io.IOException;
import java.net.ServerSocket;

import java.net.Socket;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ServerEx2 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
	
		/*ProtScan************************************************************ex2*/
		System.out.println("example 2");
		ServerSocket server_soc = null;
		for(int n = 1; n<65536; ++n){
			try{
				server_soc= new ServerSocket(n);
				server_soc.close();
			}catch(IOException ex){
				System.out.println(n+" port is already open");
			}
		}
	}

}
