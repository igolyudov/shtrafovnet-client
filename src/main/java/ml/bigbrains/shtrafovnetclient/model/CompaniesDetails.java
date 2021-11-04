package ml.bigbrains.shtrafovnetclient.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CompaniesDetails {
    private Long id;
    @JsonProperty("display_name")
    private String displayName;
    private String name;
}
