## Ex Banking Application ##


`Introduction:`
ExBanking application is developed using the mocking service provided by postman. It has following modules and its endpoints mentioned below:

`Base URL: `
https://dd071f0e-808e-4709-b7f1-f1edd7c8a4e1.mock.pstmn.io

`Postman Collection File:`
	Ex Banking Application.postman_collection.json
	
 `Account Folder:` It has mocks related to the User creation and retrieving user data
      /v1/accounts
      /v1/accounts?account_number="{{account_id}}"
      /v1/accounts?account_number="{{account_id}}"&account_holder_name="{{account_holder_name}}"

`Deposit Folder:` It has mocks related to the money deposit.
      /v1/accounts/{{account_id}}/deposit

`Send Folder:` It has mocks related to the money transfer.
      /v1/accounts/{{transfer_account_id}}/transfer/{{receiver_account_id}}

 `Withdraw Folder:` It has mocks related to the money transfer.
      /v1/accounts/{{valid_account_id}}/withdraw


Manual Test Cases: They are present inside ExBankingAppTestcases.xlsx file.

Automation Framework:
```
	Programming language: Java
	Testing framework: Testng
	API automation library: RestAssured
	Build Tool: Maven
	Design Patterns: Singleton , POM(page object model)
```

