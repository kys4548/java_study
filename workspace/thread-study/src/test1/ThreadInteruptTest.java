package test1;

import javax.swing.JOptionPane;

public class ThreadInteruptTest {

	public static void main(String[] args) {
		Runnable r = new ThreadRunner();
		Thread th1 = new Thread(r);
		th1.start();

		String input = JOptionPane.showInputDialog("�ƹ� ���̳� �Է��ϼ���");
		System.out.println("�Է��Ͻ� ���� " + input + "�Դϴ�.");
		
		th1.interrupt();
		System.out.println("th1 - isInterrupted : " + th1.isInterrupted());
		System.out.println("main �����尡 ����Ǿ����ϴ�.");
	}
}
