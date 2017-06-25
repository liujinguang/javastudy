package middleware.lock;

import java.util.concurrent.locks.ReentrantLock;

/*
 * A reentrant mutual exclusion Lock with the same basic behavior and semantics as the implicit 
 * monitor lock accessed using synchronized methods and statements, but with extended capabilities. 
 * 
 * A ReentrantLock is owned by the thread last successfully locking, but not yet unlocking it. 
 * A thread invoking lock will return, successfully acquiring the lock, when the lock is not owned 
 * by another thread. The method will return immediately if the current thread already owns the 
 * lock. This can be checked using methods isHeldByCurrentThread(), and getHoldCount(). 
 * The constructor for this class accepts an optional fairness parameter. When set true, 
 * under contention, locks favor granting access to the longest-waiting thread. Otherwise this 
 * lock does not guarantee any particular access order. Programs using fair locks accessed by many 
 * threads may display lower overall throughput (i.e., are slower; often much slower) than those 
 * using the default setting, but have smaller variances in times to obtain locks and guarantee 
 * lack of starvation. Note however, that fairness of locks does not guarantee fairness of thread 
 * scheduling. Thus, one of many threads using a fair lock may obtain it multiple times in succession 
 * while other active threads are not progressing and not currently holding the lock. Also note that 
 * the untimed tryLock method does not honor the fairness setting. It will succeed if the lock is 
 * available even if other threads are waiting. 
 * */
public class ReentrantLockTest {
	private final ReentrantLock lock = new ReentrantLock();

	public void m() {
		lock.lock(); // block until condition holds

		try {

		} finally {
			lock.unlock();
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
