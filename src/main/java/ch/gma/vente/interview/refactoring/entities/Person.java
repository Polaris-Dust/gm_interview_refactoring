package ch.gma.vente.interview.refactoring.entities;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Person {

  @Id
  private String uuid;
  @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
  @JoinTable(
    name = "person_products",
    joinColumns = {@JoinColumn(name = "person_uuid")},
    inverseJoinColumns = {@JoinColumn(name = "product_uuid")}
  )
  private List<Product> products = new ArrayList<>();
}
