package v1ch12;

public class Pair<T> {

	public T getFirst() {
		return first;
	}

	public void setFirst(T first) {
		this.first = first;
	}

	public T getSecond() {
		return second;
	}

	public void setSecond(T second) {
		this.second = second;
	}

	public Pair(T first, T second) {
		this.first = first;
		this.second = second;
	}
	
	public Pair() {
		
	}
	
	@Override
	public String toString() {
		return "first=" + first +", second=" + second;
	}

	private T first;
	private T second;
}
