package network;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class SocketConection {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Socket socket1, socket2;
		String host1 = "www.dongguk.edu";
		String host2 = "210.94.185.166";

		int port1 = 80, port2 = 7;

		try {
			// host 연결 판단
			System.out.println("Host : " + host1 + " Port : " + port1 + " Conection ...");
			socket1 = new Socket(InetAddress.getByName(host1), port1);
			System.out.println("Conection Complete!");
			socket1.close();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			System.err.println("Host err");
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block\
			System.err.println("Socket err");
			e.printStackTrace();
		}

		try {
			// host 연결 판단
			System.out.println("Host : " + host2 + " Port : " + port1 + " Conection ...");
			socket1 = new Socket(InetAddress.getByName(host2), port1);
			System.out.println("Conection Complete!");
			socket1.close();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			System.err.println("Host err");
			// e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block\
			System.err.println("Socket err");
			// e.printStackTrace();
		}

		try {
			// host 연결 판단
			System.out.println("Host : " + host1 + " Port : " + port1 + " Conection ...");
			socket1 = new Socket(InetAddress.getByName(host1), port1);
			System.out.println("Conection Complete!");
			socket1.close();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			System.err.println("Host err");
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block\
			System.err.println("Socket err");
			e.printStackTrace();
		}

	}

}
