package pages;

import base.RestAssurredEngine;
import io.restassured.response.Response;

import java.util.Map;

public class GetUserDetailsPage {

    private static GetUserDetailsPage getUserDetailsPage = new GetUserDetailsPage();

    private GetUserDetailsPage(){};
    public static GetUserDetailsPage getUserDetailsPageObject(){
        return getUserDetailsPage;
    }

    public Response getUserAccountDetails(String serviceEndpoint, String methodName,
                                          Map<String, String> headerMap, Map<String, String> queryParamMap,
                                          Map<String, String> pathParamMap, String requestBody,
                                          RestAssurredEngine restAssurredEngine){
        return restAssurredEngine.executeMethod(methodName, serviceEndpoint, queryParamMap, headerMap, pathParamMap,
                requestBody);
    }
}
