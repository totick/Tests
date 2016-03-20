import static org.junit.Assert.assertTrue;

import org.junit.*;

import pages.*;
import browsers.*;

public class LoginPageTest {
	
	private static final String ADMIN_USERNAME = "totick@hotmail.com";
	private static final String ADMIN_PASSWORD = "secret";
	private static final String STUDENT_USERNAME = "dux@hotmail.com";
	private static final String STUDENT_PASSWORD = "secret";

	@Test
	public void goToLoginPage(){
		Pages.getLoginPage().goTo();
		boolean result = Pages.getLoginPage().isAt();
		assertTrue(result);
	}
	
	@Test
	public void loginAsAdmin(){
		Pages.getLoginPage().goTo();
		Pages.getLoginPage().addValueToUsernameField(ADMIN_USERNAME);
		Pages.getLoginPage().addValueToPasswordField(ADMIN_PASSWORD);
		Pages.getLoginPage().submitLoginForm();
		boolean result = Pages.getStudentsPage().isAt();
		assertTrue(result);
	}
	
	@Test
	public void loginAsStudent(){
		Pages.getLoginPage().goTo();
		Pages.getLoginPage().addValueToUsernameField(STUDENT_USERNAME);
		Pages.getLoginPage().addValueToPasswordField(STUDENT_PASSWORD);
		Pages.getLoginPage().submitLoginForm();
		boolean result = Pages.getStudentsPage().isAt();
		assertTrue(result);
	}
	
	@After
	public void cleanUp(){
		Pages.getLoginPage().logoutUser();
		Browser.close();
	}
}
