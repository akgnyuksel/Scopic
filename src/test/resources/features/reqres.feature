@api @all
Feature: ResReq API testing for Scopic

  Using https://reqres.in/api provide a test framework that tests the following:

  # I created 4 different scenario to clearly and easily find out the console output.

  # @Read --> successfully retrieves all users and single user asserts status code is 200
  # @Create --> successfully adds new user assert that status code is 201
  # @Update --> successfully updates the user and asserts status code 204
  # @Delete --> successfully deletes the user that he added and asserts status code is 204


  @Read
  Scenario: 1
    Given User sends GET request to retrieve all users
    When User sends GET request to retrieve single user

  @Create
  Scenario: 2
    Given User sends POST request to create new user

  @Update
  Scenario: 3
    Given User updates the recently created user "Yuksel", "manager1"

  @Delete
  Scenario: 4
    Then User deletes recently created user (id number : 888 )
    # normally i should have been provided the id number of recently created user
    # but, since it is not actually created there is no such an id number
    # so I provided id number myself as shown in the scenario step