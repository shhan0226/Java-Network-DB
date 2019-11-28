package server;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class JavaServerSocket2 {
	public static void main(String[] args) {
		
		try {
			ServerSocket server = new ServerSocket(11001);
			System.out.println("서버 소켓이 만들어졌습니다. 포트 : 11001");
			
			while(true) {
				Socket aSocket = server.accept();
				System.out.println("클라이언트와 연결됨.");
				//클라이언트로부터 연결 요청 받음
				
				ObjectInputStream instream = new ObjectInputStream(aSocket.getInputStream());
				Object obj = instream.readObject();
				System.out.println("받은 데이터 : " + obj);
				//Object 데이터를 받음

				ObjectOutputStream outstream = new ObjectOutputStream(aSocket.getOutputStream());
				outstream.writeObject(obj + " from Server.");
				outstream.flush();
				System.out.println("보낸 데이터 : " + obj + " from Server.");
				//Object 데이터에 문자열을 붙여서 보냄
				
				aSocket.close();
				System.out.println("소켓 닫음.");
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
