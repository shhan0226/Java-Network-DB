package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

public class DayTime_C {

	public static void main(String args[]) {
		Socket theSocket;
		String host;
		InputStream is;
		BufferedReader reader;

		if (args.length > 0) {
			host = args[0];
		} else {
			host = "localhost";
		}

		try {
			theSocket = new Socket(host, 13);
			is = theSocket.getInputStream();
			reader = new BufferedReader(new InputStreamReader(is));
			String theTime = reader.readLine();
			System.out.println("Host time: " + theTime);

		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}