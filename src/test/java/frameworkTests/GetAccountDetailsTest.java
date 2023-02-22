package frameworkTests;

import base.RestAssurredEngine;
import org.testng.annotations.Test;
import pojoModels.FailureResponse;
import pojoModels.GetUserDetailsResponse;
import utils.ExcelUtility;

import java.util.Map;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;

public class GetAccountDetailsTest extends BaseTest{

    @Test(dataProvider = "getAPiEndpointData", dataProviderClass = ExcelUtility.class, testName =
            "Verify_GetUserDetailsTest_For_All_Users")
    public  void Verify_GetUserDetailsTest_For_All_Users(String serviceEndpoint, String methodName,
                                                         Map<String, String> headerMap, Map<String, String> queryParamMap,
                                                         Map<String, String> pathParamMap, int statusCode, String requestBody){
        response = getUserDetailsPage.getUserAccountDetails(serviceEndpoint, methodName, headerMap,
                queryParamMap, pathParamMap, requestBody, new RestAssurredEngine());
        getUserDetailsResponse = response.body().as(GetUserDetailsResponse.class);
        //response code validation
        softAssert.assertEquals(response.statusCode(), statusCode);

        //schema validation
        response.then().body(matchesJsonSchema(RestAssurredEngine.getFileObject(
                propertyFileOperations.getPropertyValue("getUserDetailsValidRequestSchema"))));

        //Count of items should be equal to the data items displayed
        softAssert.assertEquals(getUserDetailsResponse.getCount(),
                getUserDetailsResponse.getUserCreationRequest().size());

        //validate status
        softAssert.assertEquals(getUserDetailsResponse.getStatus(),statusCode);

        //Status message validation
        softAssert.assertEquals(getUserDetailsResponse.getMessage(), "Users list fetched successfully");
    }

    @Test(dataProvider = "getAPiEndpointData", dataProviderClass = ExcelUtility.class, testName =
            "Verify_GetUserDetailsTest_For_Specific_Users_With_Valid_Account_Number")
    public  void Verify_GetUserDetailsTest_For_Specific_Users_With_Valid_Account_Number(String serviceEndpoint, String methodName,
                                                                                        Map<String, String> headerMap,
                                                                                        Map<String, String> queryParamMap,
                                                                                        Map<String, String> pathParamMap,
                                                                                        int statusCode, String requestBody){
        response = getUserDetailsPage.getUserAccountDetails(serviceEndpoint, methodName, headerMap,
                queryParamMap, pathParamMap, requestBody, new RestAssurredEngine());
        getUserDetailsResponse = response.body().as(GetUserDetailsResponse.class);
        //response code validation
        softAssert.assertEquals(response.statusCode(), statusCode);

        //schema validation
        response.then().body(matchesJsonSchema(RestAssurredEngine.getFileObject(
                propertyFileOperations.getPropertyValue("getUserDetailsValidRequestSchema"))));

        //validate status
        softAssert.assertEquals(getUserDetailsResponse.getStatus(),statusCode);

        //Status message validation
        softAssert.assertEquals(getUserDetailsResponse.getMessage(), "Users list fetched successfully");
    }

    @Test(dataProvider = "getAPiEndpointData", dataProviderClass = ExcelUtility.class, testName =
            "Verify_GetUserDetailsTest_For_Specific_Users_With_Empty_Account_Number")
    public  void Verify_GetUserDetailsTest_For_Specific_Users_With_Empty_Account_Number(String serviceEndpoint, String methodName,
                                                                                        Map<String, String> headerMap,
                                                                                        Map<String, String> queryParamMap,
                                                                                        Map<String, String> pathParamMap,
                                                                                        int statusCode, String requestBody){
        response = getUserDetailsPage.getUserAccountDetails(serviceEndpoint, methodName, headerMap,
                queryParamMap, pathParamMap, requestBody, new RestAssurredEngine());
        failureResponse = response.body().as(FailureResponse.class);
        //response code validation
        softAssert.assertEquals(response.statusCode(), statusCode);

        //schema validation
        response.then().body(matchesJsonSchema(RestAssurredEngine.getFileObject(
                propertyFileOperations.getPropertyValue("errorSchema"))));

        //validate status
        softAssert.assertEquals(failureResponse.getStatus(),"Failure");

        //Status message validation
        softAssert.assertEquals(failureResponse.getErrorMessagesList().get(0).getMessage(), "Not a valid account number.");
    }

    @Test(dataProvider = "getAPiEndpointData", dataProviderClass = ExcelUtility.class, testName =
            "Verify_GetUserDetailsTest_For_Specific_Users_With_Valid_Account_Name_And_Number")
    public  void Verify_GetUserDetailsTest_For_Specific_Users_With_Valid_Account_Name_And_Number(String serviceEndpoint, String methodName,
                                                                                                 Map<String, String> headerMap,
                                                                                                 Map<String, String> queryParamMap,
                                                                                                 Map<String, String> pathParamMap,
                                                                                                 int statusCode,
                                                                                                 String requestBody){
        response = getUserDetailsPage.getUserAccountDetails(serviceEndpoint, methodName, headerMap,
                queryParamMap, pathParamMap, requestBody, new RestAssurredEngine());
        getUserDetailsResponse = response.body().as(GetUserDetailsResponse.class);
        //response code validation
        softAssert.assertEquals(response.statusCode(), statusCode);

        //schema validation
        response.then().body(matchesJsonSchema(RestAssurredEngine.getFileObject(
                propertyFileOperations.getPropertyValue("getUserDetailsValidRequestSchema"))));

        //validate status
        softAssert.assertEquals(getUserDetailsResponse.getStatus(),statusCode);

        //Status message validation
        softAssert.assertEquals(getUserDetailsResponse.getMessage(), "Users list fetched successfully");
    }
}
