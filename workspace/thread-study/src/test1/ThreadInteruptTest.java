package test1;

import javax.swing.JOptionPane;

public class ThreadInteruptTest {

	public static void main(String[] args) {
		Runnable r = new ThreadRunner();
		Thread th1 = new Thread(r);
		th1.start();

		String input = JOptionPane.showInputDialog("아무 값이나 입력하세요");
		System.out.println("입력하신 값은 " + input + "입니다.");
		
		th1.interrupt();
		System.out.println("th1 - isInterrupted : " + th1.isInterrupted());
		System.out.println("main 쓰레드가 종료되었습니다.");
	}
}
