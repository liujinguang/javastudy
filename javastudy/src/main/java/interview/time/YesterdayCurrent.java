package interview.time;

import java.time.LocalDateTime;
import java.util.Calendar;

public class YesterdayCurrent {
	
	public static void printYesterdayCurrentTime() {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, -1);
		System.out.println(cal.getTime());
	}
	
	public static void printYesterdayCurrentTime8() {
		//only work for JAVA 8
		LocalDateTime today = LocalDateTime.now();
		LocalDateTime yesterday = today.minusDays(1);
		System.out.println(yesterday);
	}
	
	public static void main(String[] args) {
		printYesterdayCurrentTime();
		printYesterdayCurrentTime8(); //java 8
	}
}
