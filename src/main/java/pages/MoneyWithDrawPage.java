package pages;

import base.RestAssurredEngine;
import io.restassured.response.Response;

import java.util.Map;

public class MoneyWithDrawPage extends BasePage{

    private static MoneyWithDrawPage moneyWithDrawPage = new MoneyWithDrawPage();

    private MoneyWithDrawPage(){};
    public static MoneyWithDrawPage getMoneyWithDrawPage(){
        return moneyWithDrawPage;
    }

    public Response withDrawMoneyFromAccount(String serviceEndpoint, String methodName,
                                                  Map<String, String> headerMap,
                                                  Map<String, String> queryParamMap,
                                                  Map<String, String> pathParamMap,
                                                  String requestBody, RestAssurredEngine restAssurredEngine){
        return restAssurredEngine.executeMethod(methodName, serviceEndpoint, queryParamMap, headerMap, pathParamMap,
                requestBody);
    }
}
