package designPattern;
import net.bytebuddy.ByteBuddy;
import net.bytebuddy.implementation.MethodDelegation;
import net.bytebuddy.matcher.ElementMatchers;

public class ByteBuddyExample {
    public static void main(String[] args) throws Exception {
        Class<?> proxyClass = new ByteBuddy()
                .subclass(RealSubject1.class)
                .method(ElementMatchers.any())
                .intercept(MethodDelegation.to(DynamicProxy2.class))
                .make()
                .load(ByteBuddyExample.class.getClassLoader())
                .getLoaded();

        RealSubject1 proxySubject = (RealSubject1) proxyClass.getDeclaredConstructor().newInstance();
        proxySubject.doSomething();
    }
}