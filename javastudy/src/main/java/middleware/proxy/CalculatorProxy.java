package middleware.proxy;

interface Calculator {
	int add(int x, int y);
}

class CalculatorImp implements Calculator {

	public int add(int x, int y) {
		return x + y;
	}

}

public class CalculatorProxy implements Calculator {
	private Calculator calculator;
	
	public CalculatorProxy(Calculator calculator) {
		this.calculator = calculator;
	}

	public int add(int x, int y) {
		return calculator.add(x, y);
	}
}
