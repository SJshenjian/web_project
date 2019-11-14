package proxy.cglib;

import net.sf.cglib.proxy.Enhancer;
import proxy.UserService;
import proxy.UserServiceImpl;

public class UserServiceCglibProxy {

    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(UserServiceImpl.class);
        enhancer.setCallback(new CglibProxy());

        UserService userService = (UserService) enhancer.create();
        System.out.println(userService.getUsername());
    }
}
