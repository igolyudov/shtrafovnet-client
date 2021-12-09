package ml.bigbrains.shtrafovnetclient.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonIgnoreProperties(value = { "requestUrl", "companyId" })
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CreateOwnersRequest  implements GenericRequest {
    private String requestUrl = "v3/companies/{company_id}/owners";

    private Long companyId;


    private String type;
    private String inn;
    private String kpp;

    public CreateOwnersRequest(Long companyId) {
        this.companyId = companyId;
    }

    public String getRequestUrl()
    {
        return requestUrl.replaceAll("\\{company_id\\}",Long.toString(companyId));
    }
}
