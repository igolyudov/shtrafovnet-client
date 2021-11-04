package ml.bigbrains.shtrafovnetclient.model;

import lombok.Data;


@Data
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
