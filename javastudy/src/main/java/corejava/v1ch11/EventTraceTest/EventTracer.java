package v1ch11.EventTraceTest;

import java.awt.Component;
import java.beans.EventSetDescriptor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class EventTracer {
	public EventTracer() {
		handler = new InvocationHandler() {
			
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				System.out.println(method + ":" + args[0]);
				return null;
			}
		};
	}
	
	public void addListener(Component c, EventSetDescriptor eventSet) {
		
	}
	
	private InvocationHandler handler;
}
