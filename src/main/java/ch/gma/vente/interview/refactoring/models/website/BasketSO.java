package ch.gma.vente.interview.refactoring.models.website;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;

@Data
public class BasketSO implements Serializable {

  private List<PersonSO> persons = new ArrayList<>();
}
