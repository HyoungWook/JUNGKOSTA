package jungkosta.commons.util;

public class BidThread extends Thread {
	

	

	@Override
	public void run() {
		
		System.out.println("경매 관리 Thread 시작!....");

		while (true) {
			try {
				
				
				
				
				sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}

	}

}
