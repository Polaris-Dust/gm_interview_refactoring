package ch.gma.vente.interview.refactoring.models.website;

import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonSO {

  private String uuid;
  private List<ProductTarifSO> products = new ArrayList<>();
}
