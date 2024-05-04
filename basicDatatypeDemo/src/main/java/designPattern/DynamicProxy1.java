package designPattern;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class DynamicProxy1 implements MethodInterceptor {
    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        before();
        Object result = proxy.invokeSuper(obj, args);
        after();
        return result;
    }

    private void before() {
        System.out.println("Dynamic Proxy (CGLIB) is doing something before RealSubject.");
    }

    private void after() {
        System.out.println("Dynamic Proxy (CGLIB) is doing something after RealSubject.");
    }
}