package ml.bigbrains.shtrafovnetclient.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class AccountResponse extends GenericResponse{
    private Long id;
    private String email;
    @JsonProperty("last_name")
    private String lastName;
    @JsonProperty("first_name")
    private String firstName;
    @JsonProperty("middle_name")
    private String middleName;
    private String phone;
    @JsonProperty("phone_ext")
    private String phoneExt;
    private String status;
    private Boolean subscribed;
    @JsonProperty("created_at")
    private String createdAt;
    @JsonProperty("updated_at")
    private String updatedAt;
}
