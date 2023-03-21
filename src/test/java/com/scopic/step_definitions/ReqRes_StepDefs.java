package com.scopic.step_definitions;

import com.scopic.utilities.APIUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

public class ReqRes_StepDefs {
    //setting some fields as class level --> to be able to use them in other methods
    private Response allUsers;
    private Response singleUser;
    private int id;
    private String name;

    @Given("User sends GET request to retrieve all users")
    public void user_sends_get_request_to_retrieve_all_users() {
        //gets all employees as Response object, sets it as class level
        allUsers = APIUtils.getAllUsers();
        //allEmployees.prettyPrint();
    }

    @When("User sends GET request to retrieve single user")
    public void user_sends_get_request_to_retrieve_single_user() {
        //gets single user as Response object, sets it as class level
       singleUser=APIUtils.getSingleUsers();
    }

    @Given("User sends POST request to create new user")
    public void userSendsPOSTRequestToCreateNewUser() {
        //creates a new user, sets its name
        APIUtils.createNewUser();
    }

    @Given("User updates the recently created user {string}, {string}")
    public void user_updates_the_recently_created_user(String name, String job) {
        //updates recently created user's data
       APIUtils.updateUserInfo(name,job);
    }

    @Then("User deletes recently created user \\(id number : {int} )")
    public void user_deletes_recently_created_user_id_number(Integer id) {
        //removes user by given id
        APIUtils.deleteUser(id);
    }
}
