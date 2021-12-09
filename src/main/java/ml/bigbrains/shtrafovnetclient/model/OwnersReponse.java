package ml.bigbrains.shtrafovnetclient.model;

import lombok.Data;
import lombok.ToString;


import java.util.List;

@Data
@ToString(callSuper = true)
public class OwnersReponse extends GenericResponse {
    List<OwnerDetails> owners;
}
