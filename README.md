## ExBankingAppAPIFramework ##
This project contains automation of mock API using Java Restassured library


Programming language: `Java`

Automation library: `Restassurred`

Build tool: `maven`

test framework: `testng`

# Folder Structure Explaination: #

1. src/main/java/base : It contains the core restassured engine which will execute different HTTP calls.

2. src/main/java/constants: This contains all the contants used in the framework like filepaths.

3. src/main/java/pages: This contains the helper classes specific to different modules in the application.

4. src/main/java/pojoModels: This contains the pojo classes for different request and response schema which will help to perform serialization and deserialization.

5. src/main/java/utlis: This folder contains utility method to read data from property file, excel sheet & generating random data using faker utility.

6. src/test/java/frameworkTests: This folder contains all the testcases for different modules in the application.

7. src/test/java/resources: This folder contains all the testdata files needed for testcase execution.





`Execution report`: Explicit test reporting is not yet implemented, default reports generated are places at below location.
                  target/surefire-reports/emailable-report.html






# How to execute the testcases? #

1. open terminal and type `mvn test`
2. right click on file `testng.xml --> run testng.xml`
