package server;

import java.net.*;
import java.util.*;

public class ChatHandlerServer {

	public static void main(String args[]) throws Exception {
		if (args.length != 1) {
			throw new IllegalArgumentException("Syntax : ChatServer [포트번호]");
		}
		int port = Integer.parseInt(args[0]);
		ServerSocket server = new ServerSocket(port);
		while (true) {
			Socket client = server.accept();
			ChatHandler handler = new ChatHandler(client);
			System.out.println("Client가" + client.getInetAddress().getHostAddress() + "으로 접속하였습니다.");
			handler.start();
		}
	}

}
