package ml.bigbrains.shtrafovnetclient.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class OwnerDetails {
    private String id;
    private String type;
    private String form;
    private String status;
    private String rawid;
    private String inn;
    private String kpp;
    private String name;
    @JsonProperty("short_name")
    private String shortName;
    @JsonProperty("legal_address")
    private String legalAddress;
    @JsonProperty("created_at")
    private String createdAt;
    @JsonProperty("updated_at")
    private String updatedAt;
}
