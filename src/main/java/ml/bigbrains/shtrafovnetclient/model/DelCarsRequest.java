package ml.bigbrains.shtrafovnetclient.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(value = { "companyId" })
public class DelCarsRequest implements GenericRequest {
    private String requestUrl = "v3/companies/{company_id}/cars/bulk-delete";

    private Long companyId;

    @JsonProperty("ids")
    private List<Long> ids;


    public DelCarsRequest(Long companyId) {
        this.companyId = companyId;
    }

    @Override
    public String getRequestUrl()
    {
        return requestUrl.replaceAll("\\{company_id\\}",Long.toString(companyId));
    }


}
