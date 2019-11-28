package network;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class LookPort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Socket socket;
		String host = "localhost";
		if (args.length == 1) {
			host = args[0];
		}

		for (int i = 1; i < 1024; i++) {
			try {
				socket = new Socket(InetAddress.getByName(host), i);
				System.out.println(host + "(host)" + i + "(port) used");

			} catch (UnknownHostException e) {
				// TODO Auto-generated catch block
				System.err.println(e);
				break;
				// e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				// e.printStackTrace();
			}

		}
		
		System.out.println("end.");
	}

}