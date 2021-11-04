package ml.bigbrains.shtrafovnetclient.model;

import lombok.Data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Data
public class CarsRequest implements GenericRequest {
    private String requestUrl = "v3/companies/{company_id}/cars";
    private Long companyId;

    private List<String> units;
    private List<Long> cars;
    private List<String> sts;
    private List<String> grz;

// statuses enum:
//    checking: находится на проверке по базе ГИБДД, но мы уже ищем по ней штрафы
//    active: проверена
//    inactive: по причине, указанной в inactive_reason, машина не активна
//    archived: перенесена в архив
//    deleted: удалена
    private List<String> statuses;
    private String search;
    private Boolean onlyArchived;
    private String orderBy;
    private Integer limit;
    private Integer offset;


    public CarsRequest(Long companyId) {
        this.companyId = companyId;
    }

    @Override
    public String getRequestUrl()
    {
        return requestUrl.replaceAll("\\{company_id\\}",Long.toString(companyId));
    }

    public Map<String,String> getParams()
    {
        Map<String,String> map = new HashMap<>();
        if(units!=null && !units.isEmpty())
            map.put("cond.units", String.join(",", units));
        if(cars!=null && !cars.isEmpty())
            map.put("cond.cars",cars.stream().map(String::valueOf).collect(Collectors.joining(",")));
        if(sts!=null && !sts.isEmpty())
            map.put("cond.sts",String.join(",",sts));
        if(grz!=null && !grz.isEmpty())
            map.put("cond.grz",String.join(",",grz));
        if(statuses!=null && !statuses.isEmpty())
            map.put("cond.statuses",String.join(",",statuses));
        if(search!=null && !search.equals(""))
            map.put("cond.search",search);
        if(onlyArchived!=null)
            map.put("cond.only_archived", Boolean.toString(onlyArchived));
        if(orderBy!=null && !orderBy.equals(""))
            map.put("order_by",orderBy);
        if(limit!=null)
            map.put("limit",Integer.toString(limit));
        if(offset!=null)
            map.put("offset",Integer.toString(offset));
        return map;
    }
}
