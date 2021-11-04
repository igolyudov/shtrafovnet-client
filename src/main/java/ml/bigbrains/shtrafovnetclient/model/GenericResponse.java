package ml.bigbrains.shtrafovnetclient.model;

import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class GenericResponse {
    private Integer code;
    private String message;
    private List<Map<String,String>> details;
}
