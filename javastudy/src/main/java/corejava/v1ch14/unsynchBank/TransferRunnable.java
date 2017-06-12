package v1ch14.unsynchBank;

public class TransferRunnable implements Runnable {
	
	public TransferRunnable() {
		
	}
	
	public TransferRunnable(Bank bank, int fromAccount, double maxAmount) {
		super();
		this.bank = bank;
		this.fromAccount = fromAccount;
		this.maxAmount = maxAmount;
	}

	public void run() {
		try {
			while(true) {
				int toAccount = (int) (bank.size() * Math.random());
				double amount = maxAmount * Math.random();
				bank.transfer(fromAccount, toAccount, amount);
				Thread.sleep((int)(DELAY * Math.random()));
			}
		} catch (InterruptedException e) {
			// TODO: handle exception
		}
		
	}



	private Bank bank;
	private int fromAccount;
	private double maxAmount;
	private final int DELAY = 10;
}
