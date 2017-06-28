package middleware.exchanger;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Exchanger;

public class ExchangerTest {

	public static void main(String[] args) {
		final Exchanger<List<Integer>> exchanger = new Exchanger<List<Integer>>();
		
		new Thread() {
			@Override
			public void run() {
				List<Integer> l = new ArrayList<Integer>(2);
				l.add(1);
				l.add(2);
				
				try {
					l = exchanger.exchange(l);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				System.out.println("Thread1 " + l);
			};
		}.start();
		
		new Thread() {
			@Override
			public void run() {
				List<Integer> l = new ArrayList<Integer>(2);
				l.add(3);
				l.add(4);
				
				try {
					l = exchanger.exchange(l);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				System.out.println("Thread2 " + l);
			};
		}.start();		
		// TODO Auto-generated method stub

	}

}
