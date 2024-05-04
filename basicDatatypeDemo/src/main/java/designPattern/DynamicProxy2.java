package designPattern;

import net.bytebuddy.implementation.bind.annotation.AllArguments;
import net.bytebuddy.implementation.bind.annotation.RuntimeType;
import net.bytebuddy.implementation.bind.annotation.SuperCall;
import net.bytebuddy.implementation.bind.annotation.This;

import java.util.concurrent.Callable;

public class DynamicProxy2 {
    @RuntimeType
    public static Object intercept(@This Object obj, @AllArguments Object[] args, @SuperCall Callable<?> callable) throws Exception {
        before();
        Object result = callable.call();
        after();
        return result;
    }

    private static void before() {
        System.out.println("DynamicProxy (bytebuddy) is doing something before RealSubject.");
    }

    private static void after() {
        System.out.println("DynamicProxy (bytebuddy) is doing something after RealSubject.");
    }
}
