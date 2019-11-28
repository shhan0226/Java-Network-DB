package client;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;


public class JavaClientSocket2 {
	
	public static void main(String[] args) {

		try {
			Socket aSocket = new Socket("localhost", 11001);
			System.out.println("클라이언트 소켓이 만들어졌습니다. 호스트 : localhost, 포트 : 11001");
			//서버에 연결
			
			ObjectOutputStream outstream = new ObjectOutputStream(aSocket.getOutputStream());
			outstream.writeObject("Hello.");
			outstream.flush();
			System.out.println("보낸 데이터 : Hello.");
			//문자열을 Object 타입으로 보냄
			
			ObjectInputStream instream = new ObjectInputStream(aSocket.getInputStream());
			Object obj = instream.readObject();
			System.out.println("받은 데이터 : " + obj);
			//Object를 보냄
			
			aSocket.close();
			System.out.println("소켓 닫음.");

		} catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
}