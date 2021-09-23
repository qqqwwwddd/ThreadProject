package ex03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;


//소켓 서버 = StateFul
public class MyServerSocket {
	
	private ServerSocket serverSocket;
	private Socket socket;
	
	
	
	public MyServerSocket() {
		try {
			serverSocket = new ServerSocket(10000);

			//while을 안달면 밑에 t.start 를 실행하고 서버가 멈춘다. 서버소켓이므로 계쏙 돌아가야함
			while(true) {  //메인스레드 = 데몬스레드

			System.out.println("클라이언트로 부터 접속 대기중");
			socket = serverSocket.accept(); // 클라이언트가 접속할 때 까지 락이 걸림.
			// listener가 accept를 호출함.
			
			System.out.println("클라이언트 연결 완료");
			
			Thread t = new Thread(new InnerThread(socket) );
			t.start();
			//여기서 멈추면 안되므로
			}
			
		} catch (IOException e) {
			System.out.println("클라이언트와의 연결이 실패");
			//e.printStackTrace();
		}
		
	}
	
	//내부클래스로 Thread 생성
	class InnerThread implements Runnable {
	
		private Socket socket;
		
		public InnerThread(Socket socket) {
			this.socket=socket;
		}
		
		
		private BufferedReader br;
		
		@Override
		public void run() {
			
			try {
				br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				
				String input = null;
				
				while((input=br.readLine()) !=null) {
					System.out.println("클라이언트: " + input);
				}
				
				
			} catch (Exception e) {
				System.out.println("클라이언트와의 메시지 통신 연결 종료");
				try {
					socket.close();
					br.close();
					
				} catch (Exception e2) {
					System.out.println("메모리 릭이 발생");
				}
				
			}
			
			
		}
		
	}
	
	
	
	public static void main(String[] args) {
		new MyServerSocket();
	}
}
