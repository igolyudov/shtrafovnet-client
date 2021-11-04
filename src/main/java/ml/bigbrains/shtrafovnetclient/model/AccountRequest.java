package ml.bigbrains.shtrafovnetclient.model;

import lombok.Data;

@Data
public class AccountRequest implements GenericRequest {
    public String requestUrl = "v3/account";
}
