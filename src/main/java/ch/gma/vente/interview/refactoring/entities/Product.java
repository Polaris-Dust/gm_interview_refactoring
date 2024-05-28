package ch.gma.vente.interview.refactoring.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Product {

  @Id
  private String uuid;
  private String code;
}
