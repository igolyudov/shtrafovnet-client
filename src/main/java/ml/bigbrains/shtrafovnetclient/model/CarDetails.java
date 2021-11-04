package ml.bigbrains.shtrafovnetclient.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CarDetails {
    private Long id;
    @JsonProperty("unit_id")
    private String unitId;
    private String sts;
    private String grz;
    private String name;
    private String status;
    @JsonProperty("inactive_reason")
    private String inactiveReason;
    @JsonProperty("created_at")
    private String createdAt;
    @JsonProperty("updated_at")
    private String updatedAt;
    @JsonProperty("archived_at")
    private String archivedAt;
}
