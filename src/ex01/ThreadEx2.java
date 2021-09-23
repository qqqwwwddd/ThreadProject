package ex01;

class NewThread2 implements Runnable {
	
	@Override
	public void run() {
		
		for (int i = 1; i <21; i++) {
			System.out.println("새로운스레드:" + i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  // 1/1000초 
		}
		
	}
	
}



public class ThreadEx2 {

	//일꾼 하나 = 메인쓰레드
	// 일 = 최대 퍼포먼스
	public static void main(String[] args) {
		
		Thread t1 = new Thread(new NewThread2());
		t1.start(); // run()함수가 실행 --> 새로운 스레드를 시작 (run을 바로 떄리진 않음)
		
		
		for (int i = 1; i <11; i++) {
			System.out.println("메인스레드:" + i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  // 1/1000초 
		}
		
	}
}
