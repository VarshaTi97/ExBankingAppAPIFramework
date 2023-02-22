package base;

import constants.APIConstants;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
import io.restassured.specification.RequestSpecification;

import java.io.File;
import java.util.Map;

public class RestAssurredEngine {

    private RequestSpecBuilder requestSpecBuilder;
    private RequestSpecification request;

    public RestAssurredEngine() {
        requestSpecBuilder = new RequestSpecBuilder();
        request = RestAssured.given();
        requestSpecBuilder.addHeader("accept", "application/json");
    }

    /**
    * Executes API methods GET/PUT/POST/DELETE
    **/
    private Response executeAPIMethods(String methodName, String serviceEndpoint){
        RequestSpecification requestSpecification = requestSpecBuilder.build();
        RequestSpecification request = RestAssured.given();
        request.spec(requestSpecification);
        if(methodName.equalsIgnoreCase(APIConstants.POST))
            return request.post(serviceEndpoint);
        else if(methodName.equalsIgnoreCase(APIConstants.GET))
            return request.get(serviceEndpoint);
        else if(methodName.equalsIgnoreCase(APIConstants.PUT))
            return request.post(serviceEndpoint);
        else if(methodName.equalsIgnoreCase(APIConstants.DELETE))
            return request.post(serviceEndpoint);
        return null;
    }

    /**
     * Executes API methods with query params and header value
     * **/

    public Response executeMethod(String methodName, String serviceEndpoint,
                                                   Map<String, String>queryParams, Map<String, String>headerMap,
                                                   Map<String, String> pathParams,
                                                   String requestBody){
        if(!headerMap.isEmpty())
            requestSpecBuilder.addHeaders(headerMap);
        if(!queryParams.isEmpty())
            requestSpecBuilder.addQueryParams(queryParams);
        if(!pathParams.isEmpty())
            requestSpecBuilder.addPathParams(pathParams);
        if(requestBody.equalsIgnoreCase("NA"))
            requestSpecBuilder.setBody("");
        if(methodName.equalsIgnoreCase(APIConstants.POST) || methodName.equalsIgnoreCase(APIConstants.PUT))
            requestSpecBuilder.setBody(requestBody);
        return executeAPIMethods(methodName, serviceEndpoint);
    }

    /**
     * Execute API call with arguments endpoint and http method name
     * */
    public Response executeMethod(String methodName, String endPoint){
        return executeAPIMethods(methodName,endPoint);
    }

    public static File getFileObject(String filePath){
        return new File(filePath);
    }
}
