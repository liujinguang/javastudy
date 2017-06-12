package v1ch14.unsynchBank;

public class UnsynchBankTest {
	public static void main(String[] args) {
		Bank bank = new Bank(NACCOUNTS, INITIAL_BALANCE);
		for (int i = 0; i < NACCOUNTS; i++) {
			TransferRunnable r = new TransferRunnable(bank, i, INITIAL_BALANCE);
			Thread t = new Thread(r);
			t.start();
		}

	}

	public static final int NACCOUNTS = 100;
	public static final double INITIAL_BALANCE = 1000;
}
