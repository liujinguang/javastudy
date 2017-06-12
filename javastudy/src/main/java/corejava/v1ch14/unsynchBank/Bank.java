package v1ch14.unsynchBank;

public class Bank {

	/**
	 * Constructs the bank
	 * 
	 * @param n
	 * @param initialBalance
	 */
	public Bank(int n, double initialBalance) {
		accounts = new double[n];

		for (int i = 0; i < accounts.length; i++) {
			accounts[i] = initialBalance;
		}
	}

	/**
	 * Gets the sum of all account balances.
	 * 
	 * @return the total balance
	 */
	public double getTotalBalance() {
		double total = 0;

		for (int i = 0; i < accounts.length; i++) {
			total += accounts[i];
		}

		return total;
	}

	/**
	 * Transfers money from one account to another.
	 * 
	 * @param from
	 *            the account to transfer from
	 * @param to
	 *            the account to transfer to
	 * @param amount
	 *            the amount to transfer
	 */
	public void transfer(int from, int to, double amount) {
		if (accounts[from] < amount)
			return;
		
		System.out.print(Thread.currentThread());
		accounts[from] -= amount;
		System.out.printf(" %10.2f from %d to %d", amount, from, to);
		accounts[to] += amount;
		System.out.printf(" Total Balance: %10.2f%n", getTotalBalance());
	}

	/**
	 * Gets the number of accounts in the bank.
	 * 
	 * @return the number of accounts
	 */
	public int size() {
		return accounts.length;
	}

	private final double[] accounts;
}
