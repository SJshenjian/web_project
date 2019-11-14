package proxy.cglib;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CglibProxy implements MethodInterceptor {


    @Override
    public Object intercept(Object target, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        System.out.println("Before execute " + method.getName());
        Object result = proxy.invokeSuper(target, args);
        System.out.println("After returning " + method.getName());
        return result;
    }
}
