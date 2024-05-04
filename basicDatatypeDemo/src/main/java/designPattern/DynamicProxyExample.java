package designPattern;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;


class DynamicProxy implements InvocationHandler {
    private Object target;

    public DynamicProxy(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();
        Object result = method.invoke(target, args);
        after();
        return result;
    }

    private void before() {
        System.out.println("Dynamic Proxy is doing something before RealSubject.");
    }

    private void after() {
        System.out.println("Dynamic Proxy is doing something after RealSubject.");
    }
}

// 使用示例
public class DynamicProxyExample {
    public static void main(String[] args) {
        RealSubject realSubject = new RealSubject();
        InvocationHandler handler = new DynamicProxy(realSubject);

        Subject proxySubject = (Subject) Proxy.newProxyInstance(
                realSubject.getClass().getClassLoader(),
                realSubject.getClass().getInterfaces(),
                handler
        );

        proxySubject.doSomething();
    }
}