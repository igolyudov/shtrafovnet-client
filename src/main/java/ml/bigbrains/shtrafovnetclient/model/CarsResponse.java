package ml.bigbrains.shtrafovnetclient.model;

import lombok.Data;

import java.util.List;

@Data
public class CarsResponse extends GenericResponse{
    public List<CarDetails> cars;
}
