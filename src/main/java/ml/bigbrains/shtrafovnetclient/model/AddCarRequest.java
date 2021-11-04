package ml.bigbrains.shtrafovnetclient.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(value = { "companyId" })
public class AddCarRequest implements GenericRequest {
    private String requestUrl = "v3/companies/{company_id}/cars";
    private Long companyId;

    @JsonProperty("unit_id")
    private String unitId;
    private String sts;
    private String grz;
    private String name;

    public AddCarRequest(Long companyId) {
        this.companyId = companyId;
    }

    @Override
    public String getRequestUrl()
    {
        return requestUrl.replaceAll("\\{company_id\\}",Long.toString(companyId));
    }


}
