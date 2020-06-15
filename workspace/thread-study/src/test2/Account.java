package test2;

class Account {
	private int balance;
	
	public Account(int balance) {
		this.balance = balance;
	}
	
	public int getBalance() {
		return balance;
	}
	
	public void addBalance(int addMoney) {
		balance += addMoney;
	}
	
	public synchronized void buy(int money) {
		if(balance == 0) {
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		if(balance < money) {
			return;
		}
		balance -= money;
	}
}
