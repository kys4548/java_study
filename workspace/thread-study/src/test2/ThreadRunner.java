package test2;

class ThreadRunner implements Runnable{
	
	Account acc = new Account(1000);
	
	public void accountMoneyUp(int money) {
		acc.addBalance(money);
	}
	
	public int getAccountBalance() {
		return acc.getBalance();
	}
	
	@Override
	public void run() {
		while(!Thread.currentThread().interrupted()) {
			int money = (int)(Math.random() * 3 + 1) * 100;
			acc.buy(money);
			System.out.println(Thread.currentThread() + "balance : "+ acc.getBalance());
		}
		System.out.println(Thread.currentThread() + "Á¾·á");
	}

}
