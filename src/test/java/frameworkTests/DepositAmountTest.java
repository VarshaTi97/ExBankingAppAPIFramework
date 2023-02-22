package frameworkTests;

import base.RestAssurredEngine;
import org.testng.annotations.Test;
import pojoModels.SuccessMessageResponse;
import pojoModels.FailureResponse;
import utils.ExcelUtility;

import java.util.Map;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;

public class DepositAmountTest extends BaseTest{

    @Test(dataProvider="getAPiEndpointData", dataProviderClass = ExcelUtility.class,
            testName = "Verify_DepositTest_Add_Amount_to_Valid_Account")
    public void Verify_DepositTest_Add_Amount_to_Valid_Account(String serviceEndpoint, String methodName,
                                                               Map<String, String> headerMap, Map<String, String> queryParamMap,
                                                               Map<String, String> pathParamMap,
                                                               int statusCode, String requestBody){
        response = depositPage.addMoneyToTheAccount(serviceEndpoint, methodName, headerMap,
                queryParamMap, pathParamMap, requestBody, new RestAssurredEngine());
        successMessageResponse = response.body().as(SuccessMessageResponse.class);
        //response code validation
        softAssert.assertEquals(response.getStatusCode(), statusCode);
        System.out.println(response.body().asString());
        //status validation
        softAssert.assertEquals(successMessageResponse.getStatus(), "Success");
        //schema validation
        response.then().body(matchesJsonSchema(RestAssurredEngine.getFileObject(
                propertyFileOperations.getPropertyValue("successSchema"))));

    }

    @Test(dataProvider="getAPiEndpointData", dataProviderClass = ExcelUtility.class,
            testName = "Verify_DepositTest_Add_Amount_to_InValid_Account")
    public void Verify_DepositTest_Add_Amount_to_InValid_Account(String serviceEndpoint, String methodName,
                                                               Map<String, String> headerMap, Map<String, String> queryParamMap,
                                                               Map<String, String> pathParamMap,
                                                               int statusCode, String requestBody){
        response = depositPage.addMoneyToTheAccount(serviceEndpoint, methodName, headerMap,
                queryParamMap, pathParamMap, requestBody, new RestAssurredEngine());
        failureResponse = response.body().as(FailureResponse.class);
        //response code validation
        softAssert.assertEquals(response.getStatusCode(), statusCode);
        System.out.println(response.body().asString());
        //status validation
        softAssert.assertEquals(failureResponse.getStatus(), "Failure");
        //response message validation
        softAssert.assertEquals(failureResponse.getErrorMessagesList().get(0).getMessage(),
                "Account details not found");
        //schema validation
        response.then().body(matchesJsonSchema(RestAssurredEngine.getFileObject(
                propertyFileOperations.getPropertyValue("errorSchema"))));

    }

    @Test(dataProvider="getAPiEndpointData", dataProviderClass = ExcelUtility.class,
            testName = "Verify_DepositTest_Add_Invalid_Amount")
    public void Verify_DepositTest_Add_Invalid_Amount(String serviceEndpoint, String methodName,
                                                                 Map<String, String> headerMap, Map<String, String> queryParamMap,
                                                                 Map<String, String> pathParamMap,
                                                                 int statusCode, String requestBody){
        response = depositPage.addMoneyToTheAccount(serviceEndpoint, methodName, headerMap,
                queryParamMap, pathParamMap, requestBody, new RestAssurredEngine());
        failureResponse = response.body().as(FailureResponse.class);
        //response code validation
        softAssert.assertEquals(response.getStatusCode(), statusCode);
        System.out.println(response.body().asString());
        //status validation
        softAssert.assertEquals(failureResponse.getStatus(), "Failure");
        //response message validation
        softAssert.assertEquals(failureResponse.getErrorMessagesList().get(0).getMessage(),
                "Invalid amount to be credited.");
        //schema validation
        response.then().body(matchesJsonSchema(RestAssurredEngine.getFileObject(
                propertyFileOperations.getPropertyValue("errorSchema"))));

    }
}
