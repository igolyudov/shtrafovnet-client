package ml.bigbrains.shtrafovnetclient.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@JsonIgnoreProperties(value = { "requestUrl" })
public interface GenericRequest {
    public String getRequestUrl();
}
