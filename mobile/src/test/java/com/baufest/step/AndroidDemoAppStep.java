package com.baufest.step;

import com.baufest.po.LogInPage;
import com.baufest.po.SignUpPage;
import com.baufest.po.WebviewPage;
import com.baufest.po.BasePage;
import com.baufest.po.FormPage;
import com.baufest.po.HomePage;
import com.baufest.util.TestContext;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import java.util.*;

public class AndroidDemoAppStep extends BasePage {
	
	private TestContext testContext = null;
	private SignUpPage signUpPage; 
	private LogInPage logInPage; 
	private HomePage homePage; 
	private FormPage formPage;
	private WebviewPage webviewPage;

	public AndroidDemoAppStep(TestContext context) throws Exception {
		testContext = context;
		homePage = new HomePage();
	}

	@Given("sign up user")
	public void signUpUser() throws Exception {
		logInPage = homePage.clickLoginButton();
		signUpPage = logInPage.selectSigUpTab();
		Random random = new Random();
		String email = "zx"+random.nextInt(9999)+"@site.com";
		String password = "Password"+random.nextInt(9999);
		signUpPage.setEmail(email);
		signUpPage.setPassword(password);
		signUpPage.setConfirmPassword(password);
		signUpPage.clickSigUpButton();
		signUpPage.clickSigUpButton();
		signUpPage.clickOkButton();
		testContext.getMap().put("email", email);
		testContext.getMap().put("password", password);
	}

	@Given("log in")
	public void logIn() throws Exception {
		logInPage.selectLogInTab();
		String email = (String) testContext.getMap().get("email");
		String password = (String) testContext.getMap().get("password");
		logInPage.setUserName(email);
		logInPage.setPassword(password);
		logInPage.clickLogInButton();
		logInPage.clickOkButton();
	}

	@Given("complete fields of form section")
  	public void addLaptopToShoppingCart() throws Exception {
    	formPage = homePage.clickFormButton();
		formPage.setInputField("Baufest");
		formPage.clickSwith();
		formPage.selectDropdownOption("webdriver.io is awesome");
		formPage.clickActiveButton();
  	}

	@Then("search word")
  	public void searchWord(DataTable dataTable) throws Exception {
    	List<List<String>> data = dataTable.asLists(String.class);
		webviewPage = homePage.clickWebviewButton();
		webviewPage.clickSearchButton();
		webviewPage.setSearchInput(data.get(0).get(0));
  	}

	@Given("exit search")
  	public void exitSearch() throws Exception {
    	webviewPage.clickCancelButton();
  	}

	  
	@Then("navigate to tab")
	public void navigateToTab(DataTable dataTable) throws Exception {
	  	List<List<String>> data = dataTable.asLists(String.class);
	  	webviewPage.clickHamburgerMenu();
	  	webviewPage.selectTab(data.get(0).get(0));
		Set<String> contextNames = driver.getContextHandles();
		driver.context((String)contextNames.toArray()[1]); // set context to WEBVIE
		driver.navigate().back();
		driver.context("NATIVE_APP");
	}

}