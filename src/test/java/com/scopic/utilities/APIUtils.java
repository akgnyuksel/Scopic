package com.scopic.utilities;

import com.github.javafaker.Faker;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import java.util.LinkedHashMap;
import java.util.Map;
import static io.restassured.RestAssured.*;

public class APIUtils {

    private static Faker faker = new Faker();

    /**
     * sends GET request, returns all users in Response object
     * @return
     */
    public static Response getAllUsers(){
        baseURI = ConfigurationReader.getProperty("apiUrl");

        return  given().accept(ContentType.JSON)
                .queryParam("page", 2)
                .when().get(ConfigurationReader.getProperty("apiUrl")+"/users")
                .then().statusCode(200)
                .and().extract().response();
    }

    /**
     * sends GET request, returns single user in Response object
     * @return
     */
    public static Response getSingleUsers(){
       //baseURI = ConfigurationReader.getProperty("apiUrl");

        return  given().accept(ContentType.JSON)
                .when().get(baseURI+"/users/2")
                .then().statusCode(200)
                .and().extract().response();
    }

    /**
     * sends POST request, creates a random new user
     * asserts statusCode is 201
     * prints the name of the recently created user
     * @param
     * @return
     */
    public static void createNewUser(){

        String newUserName = faker.name().name();
        String newUserJob = faker.job().title();

        Map<String,Object> map = new LinkedHashMap<>();
        map.put("name",newUserName);
        map.put("title",newUserJob);

        Response response = given().contentType(ContentType.JSON)
                .and().body(map)
                .when().post("/users")
                .then().statusCode(201)
                .and().log().all().extract().response();

        String nameOfUser = response.jsonPath().getString("name");
        String jobOfUser = response.jsonPath().getString("title");

        System.out.println("Say Hello to new colleague named : " + nameOfUser);
        System.out.println("Welcome to team as a new "+jobOfUser);
    }

    /**
     * sends PUT request, updates the user given by name and job
     * asserts statusCode is 204
     * prints the response body
     * @param name
     * @param job
     */
    public static void updateUserInfo(String name, String job){
        baseURI = ConfigurationReader.getProperty("apiUrl");

        Map<String,Object> map = new LinkedHashMap<>();
        map.put("name",name);
        map.put("job",job);

        Response response = given().contentType(ContentType.JSON)
                .and().body(map)
                .when().put("/api/users/2")
                .then().statusCode(200)
                .and().extract().response();
        response.prettyPrint();
    }

    /**
     * sends DELETE request, deletes the user by given id
     * asserts statusCode is 204
     * prints the response body
     * @param id
     */
    public static void deleteUser(int id){
        //baseURI = ConfigurationReader.getProperty("apiUrl");

        Response response = given().contentType(ContentType.JSON)
                .when().delete("/users/"+id)
                .then().statusCode(204)
                .and().extract().response();
        response.prettyPrint();
    }
}
