package pages;

import base.RestAssurredEngine;
import io.restassured.response.Response;

import java.util.Map;

public class TransferMoneyPage extends BasePage{
    private static TransferMoneyPage transferMoneyPage = new TransferMoneyPage();

    private TransferMoneyPage(){};
    public static TransferMoneyPage getTransferMoneyPage(){
        return transferMoneyPage;
    }

    public Response transferMoneyToAnotherAccount(String serviceEndpoint, String methodName,
                                         Map<String, String> headerMap,
                                         Map<String, String> queryParamMap,
                                         Map<String, String> pathParamMap,
                                         String requestBody, RestAssurredEngine restAssurredEngine){
        return restAssurredEngine.executeMethod(methodName, serviceEndpoint, queryParamMap, headerMap, pathParamMap,
                requestBody);
    }
}
