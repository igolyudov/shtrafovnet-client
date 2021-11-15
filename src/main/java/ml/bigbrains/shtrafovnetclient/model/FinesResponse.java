package ml.bigbrains.shtrafovnetclient.model;

import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@ToString(callSuper = true)
public class FinesResponse extends GenericResponse {
    private List<FineDetails> fines;
}
