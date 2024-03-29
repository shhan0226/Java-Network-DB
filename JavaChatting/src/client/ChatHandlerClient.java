package client;

import java.io.*;
import java.net.*;
import java.awt.*;
import java.awt.event.*;

public class ChatHandlerClient implements Runnable, WindowListener, ActionListener {
	private String host;
	private String userName;
	private int port;
	private Frame frm;
	private Panel pan;
	private TextArea taOutput;
	private Label lbName;
	private TextField tfInput;

	private DataInputStream dataIn;
	private DataOutputStream dataOut;
	private Thread listener;

	public ChatHandlerClient(String host, int port) {
		System.out.println("사용자 이름을 입력하세요 : ");
		InputStreamReader in = new InputStreamReader(System.in);
		BufferedReader out = new BufferedReader(in);

		try {
			userName = out.readLine();
		} catch (IOException e) {
			userName = "guest";
		}
		this.host = host;
		this.port = port;
		initComponent();
	}

	private void initComponent() {
		frm = new Frame("채팅 프로그램 [ " + host + ":" + port + "]");

		taOutput = new TextArea();
		taOutput.setEditable(false);

		tfInput = new TextField();
		pan = new Panel();
		lbName = new Label("입력 : ");
		frm.add("Center", taOutput);
		frm.add("South", pan);

		pan.setLayout(new BorderLayout());
		pan.add(lbName, BorderLayout.WEST);
		pan.add(tfInput, BorderLayout.CENTER);
		frm.pack();

		frm.addWindowListener(this);
		tfInput.addActionListener(this);
	}

	public String getUserName() {
		return this.userName;
	}

	synchronized public void start() throws IOException {
		if (listener == null) {
			Socket socket = new Socket(host, port);
			try {
				dataIn = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
				dataOut = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));
			} catch (IOException e) {
				socket.close();
				throw e;
			}
			listener = new Thread(this);
			listener.start();
			frm.setVisible(true);
		}
	}

	public void run() {
		System.out.println("메세지 수신 대기 중 \n");
		try {
			while (!Thread.interrupted()) {
				String line = dataIn.readUTF();
				taOutput.append(line + "\n");
				// test
				System.out.println("server>" + line + "\n");
			}
		} catch (IOException e) {
			handlerIOException(e);
		}
	}

	synchronized public void stop() throws IOException {
		if (listener != null) {
			listener.interrupt();
			listener = null;
			dataOut.close();
		}
		frm.setVisible(false);
		frm.dispose();
		System.exit(-1);
	}

	synchronized private void handlerIOException(IOException e) {
		if (listener != null) {
			tfInput.setVisible(false);
			frm.validate();
			if (listener != Thread.currentThread()) {
				listener.interrupt();
				listener = null;
				try {
					dataOut.close();
				} catch (IOException ex) {
				}
			}
		}
	}

	public void windowOpened(WindowEvent event) {
		tfInput.requestFocus();
	}

	public void windowClosing(WindowEvent event) {
		try {
			stop();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void windowClosed(WindowEvent event) {
	}

	public void windowIconified(WindowEvent event) {
	}

	public void windowDeiconified(WindowEvent event) {
	}

	public void windowActivated(WindowEvent event) {
	}

	public void windowDeactivated(WindowEvent event) {
	}

	public void actionPerformed(ActionEvent event) {
		try { // TextField로 부터 입력되면 서버로 send
			dataOut.writeUTF(getUserName() + ":" + event.getActionCommand());
			dataOut.flush();
			tfInput.setText("");
		} catch (IOException e) {
			handlerIOException(e);
		}
	}

	public static void main(String args[]) throws IOException {
		if ((args.length != 1) || (args[0].indexOf(':') < 0)) {
			System.out.println("잘못 입력했습니다.");
			throw new IllegalArgumentException("Input : [host IO]:[#port]");
		}

		int idx = args[0].indexOf(':');
		String host = args[0].substring(0, idx);
		int port = Integer.parseInt(args[0].substring(idx + 1));

		ChatHandlerClient client = new ChatHandlerClient(host, port);
		client.start();
	}
}
