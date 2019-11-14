package proxy;

public class UserServiceImpl implements UserService {

    @Override
    public String getUsername() {
        System.out.println("execute getUsername()");
        return "shenjian";
    }
}
