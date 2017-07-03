package middleware.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

//http://haolloyin.blog.51cto.com/1177454/333257/

public class DynamicProxy {
	public static void main(String[] args) {
		Calculator calculator = new CalculatorImp();

		LogHandler lh = new LogHandler(calculator);

		Calculator proxy = (Calculator)Proxy.newProxyInstance(calculator.getClass().getClassLoader(),
				calculator.getClass().getInterfaces(), lh);
		proxy.add(1, 1);
	}
}

class LogHandler implements InvocationHandler {

	public LogHandler(Object obj) {
		this.obj = obj;
	}

	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		doBefore();

		Object o = method.invoke(obj, args);

		doAfter();
		return o;
	}

	public void doBefore() {
		System.out.println("do this before");
	}

	public void doAfter() {
		System.out.println("do this after");
	}

	Object obj;
}