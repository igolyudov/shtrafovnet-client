package ml.bigbrains.shtrafovnetclient.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;


@Data
@JsonIgnoreProperties(value = { "requestUrl" })
public class LoginRequest implements GenericRequest {
    private String requestUrl = "v3/account/login";
    private String email;
    private String password;
    private Integer exp;

    public LoginRequest(String email, String password, Integer exp) {
        this.email = email;
        this.password = password;
        this.exp = exp;
    }

}
