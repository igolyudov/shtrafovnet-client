package ml.bigbrains.shtrafovnetclient.model;

import lombok.*;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class LoginResponse extends GenericResponse {
    private String token;
}
