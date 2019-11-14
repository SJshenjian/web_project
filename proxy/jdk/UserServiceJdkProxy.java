package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class UserServiceJdkProxy {

    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();
        InvocationHandler invocationHandler = new UserInvocationHandler(userService);
        UserService userServiceProxy = (UserService) Proxy.newProxyInstance(userService.getClass().getClassLoader(), userService.getClass().getInterfaces(), invocationHandler);
        System.out.println(userServiceProxy.getUsername());
    }
}
