package pojoModels;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FailureResponse {
    private String status;

    @JsonProperty("errors")
    private List<ErrorMessages> errorMessagesList;

}
