package server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class Echo_S {

	public static void main(String args[]) {
		ServerSocket theServer;
		Socket theSocket = null;
		InputStream is;
		BufferedReader reader;
		OutputStream os;
		BufferedWriter writer;
		String theLine;

		try {
			theServer = new ServerSocket(7);
			theSocket = theServer.accept(); // 서버 소멧을 생성

			is = theSocket.getInputStream();
			reader = new BufferedReader(new InputStreamReader(is));

			os = theSocket.getOutputStream();
			writer = new BufferedWriter(new OutputStreamWriter(os));

			while ((theLine = reader.readLine()) != null) {
				System.out.println(theLine);

				writer.write(theLine + '\r' + '\n');
				writer.flush();
			}

		} catch (UnknownHostException e) {
			System.out.println(e);
		} catch (IOException e) {
			System.out.println(e);
		} finally {
			if (theSocket != null) {
				try {
					theSocket.close();
				} catch (IOException e) {
					System.out.println(e);
				}
			}
		}
	}
}
