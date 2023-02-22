package pojoModels;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserCreationRequest {

    @JsonProperty("account_number")
    private String accountNumber;

    @JsonProperty("account_holder_name")
    private String accountHolderName;

    @JsonProperty("account_type")
    private String accountType;

    @JsonProperty("account_holder_type")
    private String accountHolderType;

    private String country;

    @JsonProperty("default_currency")
    private String defaultCurrency;

    private String gender;

    @JsonProperty("dob")
    private String dateOfBirth;

    private String address;

    @JsonProperty("contact_number")
    private String contactNumber;

    @JsonProperty("email_address")
    private String emailAddress;

    @JsonProperty("is_active")
    private boolean isActive;

    @JsonProperty("total_balance")
    private float totalBalance;

    @JsonProperty("created_at")
    private String createdAt;
}
