package frameworkTests;

import constants.FilePaths;
import pages.*;
import io.restassured.response.Response;
import org.testng.annotations.AfterSuite;
import org.testng.asserts.SoftAssert;
import pojoModels.*;
import utils.PropertyFileOperations;

public class BaseTest {

    public Response response;
    protected PropertyFileOperations propertyFileOperations = new PropertyFileOperations(FilePaths.testJsonSchemaFile);
    protected SoftAssert softAssert = new SoftAssert();
    protected UserCreationPage userCreationPage = UserCreationPage.getUserCreationPage();
    protected GetUserDetailsPage getUserDetailsPage = GetUserDetailsPage.getUserDetailsPageObject();
    protected DepositPage depositPage = DepositPage.getDepositPage();
    protected TransferMoneyPage transferMoneyPage = TransferMoneyPage.getTransferMoneyPage();
    protected MoneyWithDrawPage moneyWithDrawPage = MoneyWithDrawPage.getMoneyWithDrawPage();
    protected UserCreationSuccessResponse userCreationSuccessResponse;
    protected FailureResponse failureResponse;
    protected GetUserDetailsResponse getUserDetailsResponse;
    protected SuccessMessageResponse successMessageResponse;

    @AfterSuite
    public void tearDown(){
        softAssert.assertAll();
    }
}
