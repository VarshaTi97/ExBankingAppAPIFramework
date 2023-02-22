package pojoModels;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetUserDetailsResponse {
    private String timestamp;
    private int status;
    private String message;
    private int count;

    @JsonProperty("data")
    List<UserCreationRequest> UserCreationRequest;
}
