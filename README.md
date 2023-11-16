# Automation of RESTFUL-BOOKER Web Services Using Serenity BDD framework and Rest Assured library.

This project aims to automate tests for the web services provided by RESTFUL-BOOKER, a reservation application offering
functionalities to create, read, update, and delete bookings. The automation has been performed using Serenity and Rest
Assured tools, integrating Cucumber and Gherkin as the testing language.

## Report Example

https://mariaangelica2226.github.io/

### Key Features

- **Booking Creation:** Automation of the booking creation process using the POST method of the "/booking" endpoint.
  Both success cases and error scenarios are verified to ensure the integrity and robustness of the creation process.

- **Booking Retrieval by ID:** Automation of the retrieval of booking details using the GET method of the "
  /booking/{id}" endpoint. Both existing booking cases and queries with invalid IDs are covered.

- **Booking Update:** Implementation of tests to update bookings using the PUT method of the "/booking/{id}" endpoint.
  Ensures the correct update of reservation information.

- **Booking Deletion:** Automation of the booking deletion through the DELETE method of the "/booking/{id}" endpoint.
  Handles both successful deletion and error situations.

### Tools Used

- **IDE:** IntelliJ IDEA used as the development environment.

- **Testing Language:** Gherkin used for test writing in a non-technical readable format.

- **Automation Framework:** Serenity and Rest Assured for REST service automation.

- **Dependency Management:** Gradle used for dependency management and project building.

- **Reporting:** Serenity Reports generated to provide detailed information about the test status.

### Automation Strategy

The automation strategy focused on automating flows and APIs using Gherkin and Cucumber. Both happy paths and unhappy
paths were implemented to ensure complete coverage of use cases.

Code reuse was implemented through the creation of the `GeneralStepsDefinitions` class, containing common steps used in
various scenarios, following good programming practices and SOLID principles.

### Environment Configuration

Necessary environment variables have been configured for test execution, including the base URL of the service and any
other essential parameters.

## Running Tests

Tests can be easily executed using Gradle and the IntelliJ IDEA IDE. A set of simple commands is provided to run the
tests and generate reports.

### Steps to Run Tests

1.1 **Clone the Repository:**

   ```bash
   git clone https://your-repository.git
```

2.**Import Project in IntelliJ IDEA:**

-Open IntelliJ IDEA.

-Select "Import Project."

-Navigate to the project directory and select the build.gradle file.

-Click "OK" and follow the import steps.

3. **Run Tests with Gradle:**

```bash
./gradlew clean test aggregate
```

4.**Generate Reports:**

Serenity-generated reports are located in the target/site/serenity directory.

### **Additional Information**

-API Endpoint: RESTFUL-BOOKER

-Framework: Serenity BDD framework and Rest Assured library.

-Test Cases: Written in Gherkin language, located in the src/test/resources/features folder.

-Test Results: Generated in the target/site/serenity folder.

-Test Reports: Generated in the target/site/serenity folder.

-Test Data: Stored in the src/test/resources/data folder.

-Test Environment: Stored in the src/test/resources/properties folder.

-Test Steps: Stored in the src/test/java/steps folder.