package pojoModels;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DepositRequest {
    @JsonProperty("account_number")
    String accountNumber;
    @JsonProperty("account_holder_name")
    String accountHolderName;
    @JsonProperty("amount_to_deposit")
    float amountToDeposit;
    @JsonProperty("mode_of_transfer")
    String modeOfTransfer;
}
