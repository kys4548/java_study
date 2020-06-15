package test2;

public class App {
	public static void main(String[] args) {
		System.out.println(Thread.currentThread());
		ThreadRunner r = new ThreadRunner();
		Thread th1 = new Thread(r);
		Thread th2 = new Thread(r);
		th1.start();
		th2.start();
		
		for(int i=0; i<3; i++) {
			try {
				Thread.sleep(1500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			System.out.println((i+1) + "월 월급 추가" );
			
			r.accountMoneyUp(1000);
		}
		
		while(r.getAccountBalance() > 0) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		System.out.println(th1.isInterrupted() + " " + th2.isInterrupted());
		System.out.println(Thread.currentThread()+ " 종료");
	}
}
