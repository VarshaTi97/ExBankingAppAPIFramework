package pages;

import base.RestAssurredEngine;
import io.restassured.response.Response;

import java.util.Map;

public class DepositPage extends BasePage {
    private static DepositPage depositPage = new DepositPage();

    private DepositPage(){};
    public static DepositPage getDepositPage(){
        return depositPage;
    }

    public Response addMoneyToTheAccount(String serviceEndpoint, String methodName,
                                         Map<String, String> headerMap,
                                         Map<String, String> queryParamMap,
                                         Map<String, String> pathParamMap,
                                         String requestBody, RestAssurredEngine restAssurredEngine){
        return restAssurredEngine.executeMethod(methodName, serviceEndpoint, queryParamMap, headerMap, pathParamMap,
                requestBody);
    }

}
