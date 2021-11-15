package ml.bigbrains.shtrafovnetclient.model;

import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@ToString(callSuper = true)
public class CarsResponse extends GenericResponse{
    public List<CarDetails> cars;
}
