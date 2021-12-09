package ml.bigbrains.shtrafovnetclient.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonIgnoreProperties(value = { "requestUrl", "companyId", "ownerId" })
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DelOwnersRequest implements GenericRequest {
    private String requestUrl = "v3/companies/{company_id}/owners/{owner_id}";

    private Long companyId;

    private String ownerId;

    public DelOwnersRequest(Long companyId) {
        this.companyId = companyId;
    }

    public String getRequestUrl()
    {
        return requestUrl.replaceAll("\\{company_id\\}",Long.toString(companyId)).replaceAll("\\{owner_id\\}","owner_id");
    }
}
