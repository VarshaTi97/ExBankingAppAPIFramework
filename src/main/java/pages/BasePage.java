package pages;

import base.RestAssurredEngine;
import com.fasterxml.jackson.databind.ObjectMapper;
import pojoModels.DepositRequest;
import pojoModels.UserCreationRequest;
import utils.TestData;

public class BasePage{

    final ObjectMapper mapper  = new ObjectMapper();
    final TestData testData = new TestData();
    public static UserCreationRequest userCreationRequest;
    public static DepositRequest depositRequest;
}
