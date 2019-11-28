package server;

import java.io.*;
import java.net.*;

public class JavaSocketServer {

	public static void main(String[] args) {
		try{
			
			int portNumber = 5001;
			
			//소켓 연결을 수신하기 위한 serverScoket 객체 생성
			System.out.println("Strart Java Sock SERVER...");
			ServerSocket aServerSocket = new ServerSocket(portNumber);
			System.out.println("Listen port "+portNumber+"...");
			
			while(true){ //클라 연결 대기
				// 클라 연결시 소켓 객체 참조
				Socket sock = aServerSocket.accept();
				InetAddress clientHost = sock.getLocalAddress();
				int clientPort = sock.getPort();
				System.out.println("A client connet host : "+ clientHost+ ", port: "+clientPort);
				
				//데이터 읽기를 위한 스트림 객체 만들고 데이터 읽기
				ObjectInputStream instream = new ObjectInputStream(sock.getInputStream());
				Object obj = instream.readObject();
				System.out.println("Client Message : " + obj);
				
				//데이터 쓰기를 위한 스트림 객체 만들고 데이터 쓰기
				ObjectOutputStream outstream = new ObjectOutputStream(sock.getOutputStream());
				outstream.writeObject(obj+" from Server");
				outstream.flush();
				sock.close();
			}
			
			
		}catch(Exception ex){
			ex.printStackTrace();
		}

	}

}