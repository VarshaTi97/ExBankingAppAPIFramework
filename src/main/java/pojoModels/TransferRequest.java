package pojoModels;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransferRequest{
    @JsonProperty("account_number")
    String accountNumber;

    @JsonProperty("account_holder_name")
    String accountHolderName;

    @JsonProperty("transfer_account_number")
    String transferAccountNumber;

    @JsonProperty("amount_to_transfer")
    float amountToTransfer;

    @JsonProperty("mode_of_transfer")
    String modeOfTransfer;

}
