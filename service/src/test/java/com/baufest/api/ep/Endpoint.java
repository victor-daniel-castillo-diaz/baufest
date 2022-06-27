package com.baufest.api.ep;

import io.restassured.response.Response;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import static io.restassured.RestAssured.given;

public class Endpoint 
{   String sessionId = null;

    public Endpoint() {
        RestAssured.baseURI = "https://petstore.swagger.io/";
    }

    public Response addPet(String id) {
        String endpoint = "/v2/pet";   
        String json = 
        "{"+
            "\"id\": "+id+","+
            "\"category\": {"+
                "\"id\": 23,"+
                "\"name\": \"Perros\""+  
            "},"+
            "\"name\": \"Máximo\","+
            "\"photoUrls\": [\"https://vidadigital.com.mx/imagen/maximo.jpg\"],"+
            "\"tags\": [{\"id\": 23, \"name\":\"Máximo\"}],"+
            "\"status\": \"available\""+
        "}";
        Response response = given().contentType(ContentType.JSON).body(json).when().post(endpoint);
        return response;
    }

    public Response getPet(String id) {
        String endpoint = "/v2/pet/"+id;   
        Response response = given().contentType(ContentType.JSON).when().get(endpoint);
        return response;
    }

    public Response updatePet(String id, String name) {
        String endpoint = "/v2/pet/"+id;   
        Response response = given().contentType("application/x-www-form-urlencoded; charset=utf-8").formParam("name", name).when().post(endpoint);
        return response;
    }

}
