package client;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Echo_C {

	public static void main(String args[]) {
		Socket theSocket = null;
		String host;
		InputStream is;
		BufferedReader reader, userInput;
		OutputStream os;
		BufferedWriter writer;
		String theLine;

		if (args.length > 0) {
			host = args[0];
		} else {
			host = "192.168.0.3";
		}

		try {
			theSocket = new Socket(host, 7020);

			is = theSocket.getInputStream();
			reader = new BufferedReader(new InputStreamReader(is));

			userInput = new BufferedReader(new InputStreamReader(System.in));

			os = theSocket.getOutputStream();
			writer = new BufferedWriter(new OutputStreamWriter(os));

			System.out.println("input the String.");

			while (true) {
				theLine = userInput.readLine();
				if (theLine.equals("quit"))
					break;
				writer.write(theLine + "\rn");
				writer.flush();
				System.out.println(reader.readLine());
			}

		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			System.out.println(args[0] + "host err");
		} catch (IOException e) {
			System.out.println(e);
		} finally {
			try {
				theSocket.close();
			} catch (IOException e) {
				System.out.println(e);
			}
		}

	}

}