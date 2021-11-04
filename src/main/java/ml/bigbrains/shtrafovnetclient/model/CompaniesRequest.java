package ml.bigbrains.shtrafovnetclient.model;

import lombok.Data;

@Data
public class CompaniesRequest implements GenericRequest {
    public String requestUrl="v3/companies";
}
