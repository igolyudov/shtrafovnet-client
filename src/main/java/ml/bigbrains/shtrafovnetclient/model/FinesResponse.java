package ml.bigbrains.shtrafovnetclient.model;

import lombok.Data;

import java.util.List;

@Data
public class FinesResponse extends GenericResponse {
    private List<FineDetails> fines;
}
