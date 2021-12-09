package ml.bigbrains.shtrafovnetclient.model;

import lombok.Data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
public class OwnersRequest implements GenericRequest {
    private String requestUrl = "v3/companies/{company_id}/owners";
    private Long companyId;
    private List<String> types;
    private List<String> rawid;
    private List<String> inn;

    public OwnersRequest(Long companyId) {
        this.companyId = companyId;
    }

    @Override
    public String getRequestUrl()
    {
        return requestUrl.replaceAll("\\{company_id\\}",Long.toString(companyId));
    }

    public Map<String,String> getParams() {
        Map<String, String> map = new HashMap<>();
        if (types != null && !types.isEmpty())
            map.put("types", String.join(",", types));
        if (rawid != null && !rawid.isEmpty())
            map.put("rawid", String.join(",", rawid));
        if (inn != null && !inn.isEmpty())
            map.put("inn", String.join(",", inn));
        return map;
    }
}
