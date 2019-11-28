package server;


import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class HttpWebServer {
	
	public HttpWebServer() {
        System.out.println("Webserver Started");
        try (ServerSocket serverSocket = new ServerSocket(80)) {
            while (true) {
                System.out.println("Waiting for client request");
                Socket remote = serverSocket.accept();
                System.out.println("Connection made");
                
                new Thread(new HttpClientHandler(remote)).start();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new HttpWebServer();

	}

}
