package frameworkTests;

import base.RestAssurredEngine;
import org.testng.annotations.Test;
import pojoModels.FailureResponse;
import pojoModels.UserCreationSuccessResponse;
import utils.ExcelUtility;

import java.util.Map;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static pages.BasePage.userCreationRequest;


public class UserCreationTest extends BaseTest {


    //Test to validate if user creation is success and response data is valid.
    @Test(dataProvider="getAPiEndpointData", dataProviderClass = ExcelUtility.class, testName =
            "Verify_UserCreationTest_With_Valid_User_Data")
    public void Verify_UserCreationTest_With_Valid_User_Data(String serviceEndpoint, String methodName,
                                                             Map<String, String> headerMap, Map<String, String> queryParamMap,
                                                             Map<String, String> pathParamMap,
                                                             int statusCode, String requestBody){
        response = userCreationPage.createNewUserAccountWithValidData(serviceEndpoint, methodName, headerMap,
                queryParamMap, pathParamMap, requestBody, new RestAssurredEngine());
        userCreationSuccessResponse = response.body().as(UserCreationSuccessResponse.class);
        //status code validation
        softAssert.assertEquals(response.statusCode(), statusCode);
        //status message validation
        softAssert.assertEquals(userCreationSuccessResponse.getStatus(),"Success", "Status not as expected");
        softAssert.assertEquals(userCreationSuccessResponse.getMessage(), "User created successfully",
                "Message not as expected");

        //schema validation
        response.then().body(matchesJsonSchema(RestAssurredEngine.getFileObject(
                propertyFileOperations.getPropertyValue("userCreationSuccessSchema"))));
        //Output data validation
        softAssert.assertEquals(userCreationSuccessResponse.getUserContentDetails().getAccountNumber(),
                userCreationRequest.getAccountNumber(), "Account number not correct in response");
        softAssert.assertEquals(userCreationSuccessResponse.getUserContentDetails().getAccountHolderName(),
                userCreationRequest.getAccountHolderName(), "Account Holder name not correct in response");
        softAssert.assertEquals(userCreationSuccessResponse.getUserContentDetails().getAccountHolderType(),
                userCreationRequest.getAccountHolderType(), "Account holder type is not correct in response");
        softAssert.assertEquals(userCreationSuccessResponse.getUserContentDetails().getTotalBalance(),
                userCreationRequest.getTotalBalance(), "Account balance is not correct in response");
        softAssert.assertEquals(userCreationSuccessResponse.getUserContentDetails().getDateOfBirth(),
                userCreationRequest.getDateOfBirth(), "Date of birth is not correct in response");
        softAssert.assertEquals(userCreationSuccessResponse.getUserContentDetails().getDateOfBirth(),
                userCreationRequest.getDateOfBirth(), "Date of birth is not correct in response");
        softAssert.assertEquals(userCreationSuccessResponse.getUserContentDetails().getCountry(),
                userCreationRequest.getCountry(), "Country is not correct in response");
        softAssert.assertEquals(userCreationSuccessResponse.getUserContentDetails().getDefaultCurrency(),
                userCreationRequest.getDefaultCurrency(), "Currency is not correct in response");
        softAssert.assertEquals(userCreationSuccessResponse.getUserContentDetails().getGender(),
                userCreationRequest.getGender(), "Gender is not correct in response");
    }

    //To validate the user creation with empty request body
    @Test(dependsOnMethods = {"Verify_UserCreationTest_With_Valid_User_Data"}, dataProvider = "getAPiEndpointData", dataProviderClass = ExcelUtility.class,
            testName = "Verify_UserCreationTest_With_Multiple_Invalid_Payload_Format")
    public void Verify_UserCreationTest_With_Multiple_Invalid_Payload_Format(String serviceEndpoint, String methodName,
                                                                             Map<String, String> headerMap,
                                                                             Map<String, String> queryParamMap,
                                                                             Map<String, String> pathParamMap,
                                                                             int statusCode, String requestBody){
        response = userCreationPage.executeCreateUserRequest(serviceEndpoint, methodName, headerMap,
                queryParamMap, pathParamMap, requestBody, new RestAssurredEngine());

        //status code validation
        softAssert.assertEquals(response.statusCode(), statusCode);

        //schema validation
        response.then().body(matchesJsonSchema(RestAssurredEngine.getFileObject(
                propertyFileOperations.getPropertyValue("errorSchema"))));
        failureResponse = response.body().as(FailureResponse.class);
        //status message validation
        softAssert.assertEquals(failureResponse.getStatus(),"Failure", "Status is not correct.");
        //error messages validation
        softAssert.assertEquals(failureResponse.getErrorMessagesList().get(0).getMessage(),
                "Account number cannot be empty.");
        softAssert.assertEquals(failureResponse.getErrorMessagesList().get(1).getMessage(),
                "Account holder name should not be an integer.");
        softAssert.assertEquals(failureResponse.getErrorMessagesList().get(2).getMessage(),
                "Account balance cannot be negative.");
        softAssert.assertEquals(failureResponse.getErrorMessagesList().get(3).getMessage(),
                "creation time cannot be empty.");
    }
}
