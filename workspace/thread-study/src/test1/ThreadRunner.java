package test1;

class ThreadRunner implements Runnable {

	@Override
	public void run() {
		int i = 10;
		while(i != 0 && !Thread.currentThread().interrupted()) {
			System.out.println(i--);
			for(long x=0; x<2500000000L; x++);
		}
		System.out.println("th1 쓰레드가 종료되었습니다.");
	}
}
