## IT Bootcamp: Final Project - Selenium Test Automation

This project is a showcase on how to perform automated testing using Selenium WebDriver and TestNG. 
It is Java based and organized using Page Object Model design pattern which provides better maintainability and structure for automating UI tests.

### Structure

Project is organized into two main folders:
- `src/main/java` - containing all the shared logic - helpers, pages, retry analyzers
- `test/java/tests` - containing actual test automation logic

Detailed structure is shown below:

```
.
├── ...
├── src                    
│   ├── main               
│   │    └── java
│   │         ├── helper   # Screenshot helper methods
│   │         ├── pages    # Page classes (locators and various action methods) 
│   │         └── retry    # Retry Analyzer
│   └── test
│        └── java
│             └── tests    # Automation code for test cases / scenarios 
├── test_scenarios         # Test cases
└── README.md
```

## Test organization

The tests are organized into six test categories:

- **Login Tests**: tests verifying login functionality  (**[test cases](test_scenarios/TS_LOGIN_PAGE.md)**) <br/>
- **Signup Tests**: tests verifying signup functionality (**[test cases](test_scenarios/TS_SIGN_UP_PAGE.md)**)<br/>
- **Admin Cities Tests**: tests verifying Cities CRUD functionality (**[test cases](test_scenarios/TS_ADMIN_CITIES_PAGE.md)**)<br/>
- **Auth Routes Tests**: tests covering access to pages when user is not authenticated (**[test cases](test_scenarios/TS_AUTH_ROUTES.md)**)<br/>
- **Locale Tests**: tests covering page content in different languages when user language is changed (**[test cases](test_scenarios/TS_LOCALE.md)**)<br/>
- **Profile Tests**: tests covering user profile data validation and updates (**[test cases](test_scenarios/TS_PROFILE_PAGE.md)**)

## Dependencies

To run the tests on your machine you will need to have the following pre-installed:

- Java Development Kit (JDK)
- Maven
- TestNG
- Chrome WebDriver

### Running the tests

For running testng file from command line use command: `mvn clean test -Dsurefire.suiteXmlFiles=testng.xml`
