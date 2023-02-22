package pages;

import base.RestAssurredEngine;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
import pojoModels.UserCreationRequest;

import java.util.Map;

public class UserCreationPage extends BasePage{
    private static UserCreationPage userCreationPage = new UserCreationPage();
    private UserCreationPage(){};

    public static UserCreationPage getUserCreationPage(){
        return userCreationPage;
    }

    public Response createNewUserAccountWithValidData(String serviceEndpoint, String methodName,
                                                      Map<String, String> headerMap,
                                                      Map<String, String> queryParamMap,
                                                      Map<String, String> pathParamMap,
                                                      String requestBody, RestAssurredEngine restAssurredEngine){
        requestBody = modifyUserCreationData(requestBody);
        return restAssurredEngine.executeMethod(methodName, serviceEndpoint, queryParamMap, headerMap, pathParamMap,
                requestBody);
    }

    public Response executeCreateUserRequest(String serviceEndpoint, String methodName,
                                             Map<String, String> headerMap,
                                             Map<String, String> queryParamMap,
                                             Map<String, String> pathParamMap,
                                             String requestBody, RestAssurredEngine restAssurredEngine){
        return restAssurredEngine.executeMethod(methodName, serviceEndpoint, queryParamMap, headerMap, pathParamMap,
                requestBody);
    }

    public String modifyUserCreationData(String requestBody) {
        String modifiedRequestBody = "";
        try {
            userCreationRequest = mapper.readValue(requestBody, UserCreationRequest.class);
            userCreationRequest.setAccountNumber(testData.getId());
            userCreationRequest.setAccountHolderName(testData.getFullName());
            userCreationRequest.setAccountType(testData.getAccountType());
            userCreationRequest.setCountry(testData.getCountry());
            userCreationRequest.setDefaultCurrency(testData.getCurrency());
            userCreationRequest.setGender(testData.getGender());
            userCreationRequest.setDateOfBirth(testData.getBirthDate());
            userCreationRequest.setAddress(testData.getStreet());
            userCreationRequest.setContactNumber(testData.getPhoneNumber());
            userCreationRequest.setEmailAddress(testData.getEmailId());
            userCreationRequest.setActive(true);
            userCreationRequest.setTotalBalance(0);
            userCreationRequest.setCreatedAt(testData.getTimeStamp());
            modifiedRequestBody = mapper.writeValueAsString(userCreationRequest);
        }
        catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return modifiedRequestBody;
    }
}
