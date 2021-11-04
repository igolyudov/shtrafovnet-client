package ml.bigbrains.shtrafovnetclient.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class CompaniesResponse extends GenericResponse{
    private List<CompaniesDetails> companies;
}
