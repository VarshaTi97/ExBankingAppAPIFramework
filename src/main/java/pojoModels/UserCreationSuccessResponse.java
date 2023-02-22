package pojoModels;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserCreationSuccessResponse {
    private String status;
    private String message;

    @JsonProperty("content")
    private UserContentDetails userContentDetails;

}
