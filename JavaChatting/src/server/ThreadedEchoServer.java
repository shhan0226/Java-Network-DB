package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ThreadedEchoServer implements Runnable {

	private static Socket clientSocket;

	public ThreadedEchoServer(Socket clientSocket) {
		this.clientSocket = clientSocket;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Thread Echo server");
		try (ServerSocket serverSocket = new ServerSocket(6000)) {
			while (true) {
				System.out.println("Waiting for Connection ...");
				clientSocket = serverSocket.accept();
				ThreadedEchoServer tes = new ThreadedEchoServer(clientSocket);
				new Thread(tes).start();
			}

		} catch (IOException ex) {

		}

		System.out.println("Threaded Echo Server Termination");

	}

	public void run() {
		System.out.println("Connected to client usig [" + Thread.currentThread() + "]");

		try (BufferedReader br = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
				PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true)) {

			String inputLine;

			while ((inputLine = br.readLine()) != null) {
				System.out.println("Client request [" + Thread.currentThread() + "] " + inputLine);
				out.println(inputLine);
			}

			System.out.println("client [" + Thread.currentThread() + "connection terminated");

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
