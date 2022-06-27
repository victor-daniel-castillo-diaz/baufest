package com.baufest.step;

import com.baufest.api.ep.Endpoint;
import com.baufest.util.TestContext;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import java.io.File;
import java.util.*;

public class PetStoreStep {
	private TestContext testContext = null;

	public PetStoreStep(TestContext context) {
		testContext = context;
	}

	@Given("add pet")
  	public void addPet() throws Exception {
		Endpoint endpoint = new Endpoint();
		Random random = new Random();
		String id = String.valueOf(random.nextInt(999999999));
		Response response = endpoint.addPet(id);
		response.then().assertThat().statusCode(200);
		response.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(new File(System.getProperty("user.dir")+ "\\schema\\pet.json")));
		testContext.getMap().put("petId", id);
  	}

	@When("get pet")
  	public void getPet() throws Exception {
		Endpoint endpoint = new Endpoint();
		String petId = (String) testContext.getMap().get("petId");
		Response response = endpoint.getPet(petId);
		response.then().assertThat().statusCode(200);
		response.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(new File(System.getProperty("user.dir")+ "\\schema\\pet.json")));
  	}

	@Then("update pet")
  	public void updatePet(DataTable dataTable) throws Exception {
		List<List<String>> data = dataTable.asLists(String.class);
		Endpoint endpoint = new Endpoint();
		String petId = (String) testContext.getMap().get("petId");
		Response response = endpoint.updatePet(petId, data.get(0).get(0));
		response.then().assertThat().statusCode(200);
  	}
}