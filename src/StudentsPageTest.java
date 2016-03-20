import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Ignore;
import org.junit.Test;

import browsers.Browser;
import pages.Pages;

public class StudentsPageTest {

	private static final String ADMIN_USERNAME = "totick@hotmail.com";
	private static final String ADMIN_PASSWORD = "secret";
	
	@Test
	public void goToStudentsPage(){
		Pages.getStudentsPage().goTo();
		boolean result = Pages.getStudentsPage().isAt();
		assertTrue(result);
	}
	
	@Test
	public void addNewStudentAsAdmin(){
		Pages.getLoginPage().goTo();
		Pages.getLoginPage().addValueToUsernameField(ADMIN_USERNAME);
		Pages.getLoginPage().addValueToPasswordField(ADMIN_PASSWORD);
		Pages.getLoginPage().submitLoginForm();
		Pages.getStudentsPage().showAddNewStudentForm();
		Pages.getStudentsPage().addValueToNewFirstNameField("Leo");
		Pages.getStudentsPage().addValueToNewLastNameField("Tolstoj");
		Pages.getStudentsPage().addValueToNewPersonnrField("8504189271");
		Pages.getStudentsPage().addValueToNewGenderRb("female");
		Pages.getStudentsPage().addValueToNewStreetField("Tomtbergavägen 217");
		Pages.getStudentsPage().addValueToNewCityField("Stockholm");
		Pages.getStudentsPage().addValueToNewTelephoneField("0700490691");
		Pages.getStudentsPage().addValueToNewEmailField("tolstoj@hotmail.com");
		Pages.getStudentsPage().addValueToNewPasswordField("secret");
		Pages.getStudentsPage().submitAddStudentForm();
		boolean result = Pages.getStudentsPage().isTextInStudentsListTable("tolstoj@hotmail.com");
		assertTrue(result);
	}
	
	@After
	@Ignore
	public void cleanUp(){
		Pages.getLoginPage().logoutUser();
		Browser.close();
	}
}
