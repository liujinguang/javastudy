package v1ch14.synchBank;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

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
		
		lock = new ReentrantLock();
		condition = lock.newCondition();
	}

	/**
	 * Gets the sum of all account balances.
	 * 
	 * @return the total balance
	 */
	public double getTotalBalance() {
		lock.lock();
		try {
			double total = 0;

			for (int i = 0; i < accounts.length; i++) {
				total += accounts[i];
			}

			return total;
		} finally {
			lock.unlock();
		}

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
	 * @throws InterruptedException 
	 */
	public void transfer(int from, int to, double amount) throws InterruptedException {
		lock.lock();
		try {
			while (accounts[from] < amount) {
				condition.await();
			}
			
			System.out.print(Thread.currentThread());
			accounts[from] -= amount;
			System.out.printf(" %10.2f from %d to %d", amount, from, to);
			accounts[to] += amount;
			System.out.printf(" Total Balance: %10.2f%n", getTotalBalance());
			
			condition.signalAll();
		} finally {
			lock.unlock();
		}

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
	private Lock lock;
	private Condition condition;
}
