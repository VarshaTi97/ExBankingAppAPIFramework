package pojoModels;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserContentDetails {
    @JsonProperty("account_number")
    private String accountNumber;

    @JsonProperty("account_holder_name")
    private String accountHolderName;

    @JsonProperty("is_active")
    private String isActive;

    @JsonProperty("total_balance")
    private float totalBalance;

    @JsonProperty("account_holder_type")
    private String accountHolderType;

    @JsonProperty("dob")
    private String dateOfBirth;

    private String country;

    @JsonProperty("default_currency")
    private String defaultCurrency;

    private String gender;
}
