package online.shenjian.struts2;

import static org.junit.Assert.*;

import org.junit.Test;


public class ConfigurationTest {

    Configuration config = new Configuration("struts.xml");

    @Test
    public void testGetClassName() {

        String clazzName = config.getClassName("login");
        assertEquals("LoginAction", clazzName);

        clazzName = config.getClassName("logout");
        assertEquals("LoginOutAction", clazzName);
    }

    @Test
    public void testGetResultView() {

        String jsp = config.getResultView("login", "success");
        assertEquals("/jsp/homepage.jsp", jsp);

        jsp = config.getResultView("login", "fail");
        assertEquals("/jsp/showLogin.jsp", jsp);

        jsp = config.getResultView("logout", "success");
        assertEquals("/jsp/welcome.jsp", jsp);

        jsp = config.getResultView("logout", "error");
        assertEquals("/jsp/error.jsp", jsp);
    }
}
