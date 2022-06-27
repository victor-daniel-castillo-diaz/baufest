package com.baufest.step;

import com.baufest.po.LogInPage;
import com.baufest.po.ProductPage;
import com.baufest.po.SignUpPage;
import com.baufest.po.BasePage;
import com.baufest.po.CategoryPage;
import com.baufest.po.HomePage;
import com.baufest.util.TestContext;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import java.util.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ShoppingCarStep extends BasePage {
	
	private TestContext testContext = null;
	SignUpPage signUpPage; 
	LogInPage logInPage; 
	HomePage homePage; 
	CategoryPage categoryPage;
	ProductPage productPage;


	public ShoppingCarStep(TestContext context) throws Exception {
		testContext = context;
	}

	@Given("the user go to page")
  	public void theUserGoToPage(DataTable dataTable) throws Exception {
    	List<List<String>> data = dataTable.asLists(String.class);
    	driver.navigate().to(data.get(0).get(0));
  	}

	@Given("sign up user")
	public void signUpUser() throws Exception {
		String message = null;
		String username = null;
		String password = null;
		do {	
			homePage= new HomePage();
			signUpPage = homePage.clickSigUpLink();
			Random random = new Random();
			username = "test"+random.nextInt(9999);
			password = "pass"+random.nextInt(9);
			signUpPage.setUserName(username);
			signUpPage.setPassword(password);
			signUpPage.clickSigUpButton();
			message = signUpPage.getAlertMessage();
			if(message.equals("Sign up successful."))
			{	signUpPage.acceptAlert("Sign up successful.");
				break;
			}else
			{	signUpPage.acceptAlert("This user already exist.");
				signUpPage.clickCloseButton();
			}
		}while(true);	
		testContext.getMap().put("username", username);
		testContext.getMap().put("password", password);
	}

	@Given("log in")
	public void logIn() throws Exception {
		logInPage= new LogInPage();
		logInPage.clickLogInLink();
		String username = (String) testContext.getMap().get("username");
		String password = (String) testContext.getMap().get("password");
		logInPage.setUserName(username);
		logInPage.setPassword(password);
		logInPage.clickLogInButton();
		String expectedMessage = "Welcome "+ testContext.getMap().get("username");
		assertEquals(homePage.getWelcomeMessage(), expectedMessage);
	}

	@Given("log out")
	public void logOut() throws Exception {
		homePage= new HomePage();
		homePage.clickLogOutLink();
	}

	@Given("add laptop to shopping cart")
  	public void addLaptopToShoppingCart(DataTable dataTable) throws Exception {
    	List<List<String>> data = dataTable.asLists(String.class);
    	categoryPage = homePage.selectCategory("Laptops");
		productPage = categoryPage.selectProduct(data.get(0).get(0));
		productPage.clickAddToCarButton().acceptAlert("Product added.");
  	}

	@Then("verify laptop in shopping cart")
  	public void verifyLaptopInShoppingCart(DataTable dataTable) throws Exception {
    	List<List<String>> data = dataTable.asLists(String.class);
    	
		//homePage.clickCartLink().findProductByName(data.get(0).get(0));

		assertTrue(homePage.clickCartLink().findProductByName(data.get(0).get(0)));
  	}

	  



}