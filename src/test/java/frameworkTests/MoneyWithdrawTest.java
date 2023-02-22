package frameworkTests;

import base.RestAssurredEngine;
import org.testng.annotations.Test;
import pojoModels.FailureResponse;
import pojoModels.SuccessMessageResponse;
import utils.ExcelUtility;

import java.util.Map;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;

public class MoneyWithdrawTest extends BaseTest{
    @Test(dataProvider="getAPiEndpointData", dataProviderClass = ExcelUtility.class,
            testName = "Verify_WithdrawTest_Withdraw_Valid_Amount_From_Valid_Account")
    public void Verify_WithdrawTest_Withdraw_Valid_Amount_From_Valid_Account(String serviceEndpoint, String methodName,
                                                                      Map<String, String> headerMap, Map<String, String> queryParamMap,
                                                                      Map<String, String> pathParamMap,
                                                                      int statusCode, String requestBody){
        response = moneyWithDrawPage.withDrawMoneyFromAccount(serviceEndpoint, methodName, headerMap,
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
            testName = "Verify_WithdrawTest_Withdraw_From_Invalid_Account")
    public void Verify_WithdrawTest_Withdraw_From_Invalid_Account(String serviceEndpoint, String methodName,
                                                                        Map<String, String> headerMap, Map<String, String> queryParamMap,
                                                                        Map<String, String> pathParamMap,
                                                                        int statusCode, String requestBody){
        response = moneyWithDrawPage.withDrawMoneyFromAccount(serviceEndpoint, methodName, headerMap,
                queryParamMap, pathParamMap, requestBody, new RestAssurredEngine());
        failureResponse = response.body().as(FailureResponse.class);
        //response code validation
        softAssert.assertEquals(response.getStatusCode(), statusCode);
        System.out.println(response.body().asString());
        //status validation
        softAssert.assertEquals(failureResponse.getStatus(), "Failure");
        //response message validation
        softAssert.assertEquals(failureResponse.getErrorMessagesList().get(0).getMessage(),
                "Account details not found.");
        //schema validation
        response.then().body(matchesJsonSchema(RestAssurredEngine.getFileObject(
                propertyFileOperations.getPropertyValue("errorSchema"))));

    }

    @Test(dataProvider="getAPiEndpointData", dataProviderClass = ExcelUtility.class,
            testName = "Verify_WithdrawTest_Withdraw_Invalid_Amount_From_Valid_Account")
    public void Verify_WithdrawTest_Withdraw_Invalid_Amount_From_Valid_Account(String serviceEndpoint, String methodName,
                                                              Map<String, String> headerMap, Map<String, String> queryParamMap,
                                                              Map<String, String> pathParamMap,
                                                              int statusCode, String requestBody){
        response = moneyWithDrawPage.withDrawMoneyFromAccount(serviceEndpoint, methodName, headerMap,
                queryParamMap, pathParamMap, requestBody, new RestAssurredEngine());
        failureResponse = response.body().as(FailureResponse.class);
        //response code validation
        softAssert.assertEquals(response.getStatusCode(), statusCode);
        System.out.println(response.body().asString());
        //status validation
        softAssert.assertEquals(failureResponse.getStatus(), "Failure");
        //response message validation
        softAssert.assertEquals(failureResponse.getErrorMessagesList().get(0).getMessage(),
                "Insufficient Account Balance.");
        //schema validation
        response.then().body(matchesJsonSchema(RestAssurredEngine.getFileObject(
                propertyFileOperations.getPropertyValue("errorSchema"))));

    }
}
