package ex03;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class MyClientSocket {
	
	private Socket socket;
	private BufferedWriter bw;
	//private PrintWriter pw;
	
	public MyClientSocket() {
		try {
			socket = new Socket("localhost", 10000);
			
			bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
		//	pw = new PrintWriter(socket.getOutputStream());
			
			Scanner sc = new Scanner(System.in);
			
			while(true) {
				String keyboardInput = sc.nextLine(); //락걸림
				bw.write(keyboardInput+ "\n");
				bw.flush();
			}
			
			
			
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new MyClientSocket();
	}
	
	
}
