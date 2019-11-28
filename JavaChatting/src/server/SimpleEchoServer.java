package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class SimpleEchoServer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Simple Echo Server");
		try {
			ServerSocket serverSocket = new ServerSocket(6000);
			Socket clientSocket = serverSocket.accept();
			System.out.println("Connection to Client....");
			try {
				BufferedReader br = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
				PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
				String inputLine;

				while ((inputLine = br.readLine()) != null) {
					System.out.println("Server: " + inputLine);
					out.println(inputLine);
				}

			} catch (IOException e) {
			}
		} catch (IOException e) {
			System.err.println("err" + e);
		}

	}
}
