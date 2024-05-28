package ch.gma.vente.interview.refactoring.models;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;

@Data
public class CombinaisonTarifDTO {

  private LocalDate dateEntreeVigueur;

  private List<String> caisses = new ArrayList<>();

  private List<String> produits = new ArrayList<>();

  private List<String> produitsMedecinsReseauSoins = new ArrayList<>();

  private List<String> produitsMedecinsPremierRecours = new ArrayList<>();

  private String selectedProduit;

  private BigDecimal taxeEnvironnementale;
}
