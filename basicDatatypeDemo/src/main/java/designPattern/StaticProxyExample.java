package designPattern;


interface Subject {
    void doSomething();
}

class RealSubject implements Subject {
    @Override
    public void doSomething() {
        System.out.println("RealSubject is doing something.");
    }
}

class ProxySubject implements Subject {
    private RealSubject realSubject;

    public ProxySubject(RealSubject realSubject) {
        this.realSubject = realSubject;
    }

    @Override
    public void doSomething() {
        before();
        realSubject.doSomething();
        after();
    }

    private void before() {
        System.out.println("ProxySubject is doing something before RealSubject.");
    }

    private void after() {
        System.out.println("ProxySubject is doing something after RealSubject.");
    }
}

// 使用示例
public class StaticProxyExample {
    public static void main(String[] args) {
        RealSubject realSubject = new RealSubject();
        ProxySubject proxySubject = new ProxySubject(realSubject);
        proxySubject.doSomething();
    }
}
