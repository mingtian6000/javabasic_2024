package designPattern;

import net.sf.cglib.proxy.Enhancer;

public class CGLIBExample {
    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(RealSubject1.class);
        enhancer.setCallback(new DynamicProxy1());

        RealSubject1 proxySubject = (RealSubject1) enhancer.create();
        proxySubject.doSomething();
    }
}