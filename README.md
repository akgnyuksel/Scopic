# UI and API Testing for Scopic

## Objective

### The objective of this test plan is to verify the functionality of the https://reqres.in/api <ins>API</ins> and  https://www.amazon.com <ins>UI.</ins>

## Test Environment&Tools
### _The following test environment will be used for API and UI testing:_

- _**OS:**_ Windows 11
- _**System Requirements:**_ Java 8 + SDK
- _**Build Tool:**_ Maven
- _**IDE:**_ IntelliJ IDEA 2022.1
- _**Web Browser:**_ Google Chrome
- _**Programming Language:**_ Java, Gherkin, JavaScript
- _**BDD Framework:**_ BDD Cucumber Framework 

**For API:**
- _**Documentation:**_ Swagger and given specifications

    _Since the Swagger document is different with "given features", the test cases have prepared according to the "given conditions "._
- _**Testing Tools:**_ Postman, RestAssured.



**For UI:**
- _**Web Automation Tools:**_  Selenium WebDriver, JUnit

## Dependencies
```selenium-java```

```webdrivermanager```

```cucumber-java```

```cucumber-junit```

```rest-assured```

```javafaker```

```jackson-databind```

```reporting-plugin```

```maven-surefire-plugin```

## Test Cases
_**This test suite includes the following scenarios for <ins>API testing:</ins>**_

    I created 4 different scenario to clearly and easily find out the console output.
    @Read --> Successfully retrieves all users and single user asserts status code is 200
    @Create --> Successfully adds new user assert that status code is 201
    @Update --> Successfully updates the user and asserts status code 204
    @Delete --> Successfully deletes the user that he added and asserts status code is 204
        Normally I should have been provided the id number of recently created user but, since it is not actually
        created there is no such an id number so I provided id number myself as shown in the scenario step.
        

_**This test suite includes the following scenarios for <ins>UI testing:</ins>**_

    Background--> Successfully logs in 
    @a --> Successfully add two products to cart and assert that the operation is successful
    @b --> Semove successfully one of them and assert that the result is correct
    @b --> Semove successfully the remaining one and assert that the result is correct
    @c --> Try to remove again one of the products expecting a failed test in this case
        I let this case to fail, it throws RuntimeException        
        Also failed case can be examined in the reporting by attached screenshot

## Nice to Know
**1 - For running tests scenarios;**

    - go to CukerRunner.java class (src > test > java > com > scopic > runners > CukesRunner)
    - specify a tag in CucumberOptions
            * @ui for UI tests
            * @api for API tests
            * @all for all tests
    - run CukesRunner.java class
**2 - Cucumber BDD Framework has 2 layers;**

    - Business Layer --> src > test > resources > features
    - Implementation Layer --> src > > test > java > com > scopic > step_definitions



**3 - Relevant credentials are located in <ins>configuration.properties</ins> file.**

**4 - Followed <ins>Page Object Model</ins> & <ins>Singleton Design Pattern.</ins>**

**5 - Achieved <ins>Data Driven Testing</ins> by configuration.properties and Cucumber Expressions.**

**6 - Implemented <ins>Gherkin Language</ins> in feature files.**

**7 - Utilized <ins>Hooks</ins> class for taking screenshots if a test fails.**

## Contributing
_**If you wish to contribute to this project, please follow the standard GitHub workflow:**_

1- Fork the repository

2- Create a new branch for your changes

3- Make your changes and commit them 

4- Push your branch to your fork

5- Create a pull request to merge your changes into the main repository

## Conclusion:
Overall, the  https://reqres.in/api API demonstrated good functionality and reliability. The API was able to successfully handle CRUD operations for users and retrieve their informations, with expected responses and status codes.

For UI testing, the tests outlined in this test plan will ensure that the amazon.com website works as expected and meets the desired requirements. By following a BDD approach with Cucumber, Junit and using Selenium, the tests will be comprehensive and maintainable project. The test plan in the feature files a wide range of functionality and features of the amazon.com website to ensure that it works properly and meets the expected requirements. By following a BDD approach with, I have developed a comprehensive set of test cases and scenarios. The tests can be run easily by following the steps provided above.