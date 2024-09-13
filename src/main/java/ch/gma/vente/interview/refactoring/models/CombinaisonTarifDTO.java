package ch.gma.vente.interview.refactoring.models;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CombinaisonTarifDTO {

  private LocalDate dateEntreeVigueur;

  private List<String> caisses = new ArrayList<>();

  private List<String> produits = new ArrayList<>();

  private List<String> produitsMedecinsReseauSoins = new ArrayList<>();

  private List<String> produitsMedecinsPremierRecours = new ArrayList<>();

  private String selectedProduit;

  private BigDecimal taxeEnvironnementale;

  public CombinaisonTarifDTO() {
  }

  public LocalDate getDateEntreeVigueur() {
    return this.dateEntreeVigueur;
  }

  public List<String> getCaisses() {
    return this.caisses;
  }

  public List<String> getProduits() {
    return this.produits;
  }

  public List<String> getProduitsMedecinsReseauSoins() {
    return this.produitsMedecinsReseauSoins;
  }

  public List<String> getProduitsMedecinsPremierRecours() {
    return this.produitsMedecinsPremierRecours;
  }

  public String getSelectedProduit() {
    return this.selectedProduit;
  }

  public BigDecimal getTaxeEnvironnementale() {
    return this.taxeEnvironnementale;
  }

  public void setDateEntreeVigueur(LocalDate dateEntreeVigueur) {
    this.dateEntreeVigueur = dateEntreeVigueur;
  }

  public void setCaisses(List<String> caisses) {
    this.caisses = caisses;
  }

  public void setProduits(List<String> produits) {
    this.produits = produits;
  }

  public void setProduitsMedecinsReseauSoins(List<String> produitsMedecinsReseauSoins) {
    this.produitsMedecinsReseauSoins = produitsMedecinsReseauSoins;
  }

  public void setProduitsMedecinsPremierRecours(List<String> produitsMedecinsPremierRecours) {
    this.produitsMedecinsPremierRecours = produitsMedecinsPremierRecours;
  }

  public void setSelectedProduit(String selectedProduit) {
    this.selectedProduit = selectedProduit;
  }

  public void setTaxeEnvironnementale(BigDecimal taxeEnvironnementale) {
    this.taxeEnvironnementale = taxeEnvironnementale;
  }

  public boolean equals(final Object o) {
    if (o == this) {
      return true;
    }
    if (!(o instanceof CombinaisonTarifDTO)) {
      return false;
    }
    final CombinaisonTarifDTO other = (CombinaisonTarifDTO) o;
    if (!other.canEqual((Object) this)) {
      return false;
    }
    final Object this$dateEntreeVigueur = this.getDateEntreeVigueur();
    final Object other$dateEntreeVigueur = other.getDateEntreeVigueur();
    if (this$dateEntreeVigueur == null ? other$dateEntreeVigueur != null : !this$dateEntreeVigueur.equals(other$dateEntreeVigueur)) {
      return false;
    }
    final Object this$caisses = this.getCaisses();
    final Object other$caisses = other.getCaisses();
    if (this$caisses == null ? other$caisses != null : !this$caisses.equals(other$caisses)) {
      return false;
    }
    final Object this$produits = this.getProduits();
    final Object other$produits = other.getProduits();
    if (this$produits == null ? other$produits != null : !this$produits.equals(other$produits)) {
      return false;
    }
    final Object this$produitsMedecinsReseauSoins = this.getProduitsMedecinsReseauSoins();
    final Object other$produitsMedecinsReseauSoins = other.getProduitsMedecinsReseauSoins();
    if (this$produitsMedecinsReseauSoins == null ? other$produitsMedecinsReseauSoins != null
      : !this$produitsMedecinsReseauSoins.equals(other$produitsMedecinsReseauSoins)) {
      return false;
    }
    final Object this$produitsMedecinsPremierRecours = this.getProduitsMedecinsPremierRecours();
    final Object other$produitsMedecinsPremierRecours = other.getProduitsMedecinsPremierRecours();
    if (this$produitsMedecinsPremierRecours == null ? other$produitsMedecinsPremierRecours != null
      : !this$produitsMedecinsPremierRecours.equals(other$produitsMedecinsPremierRecours)) {
      return false;
    }
    final Object this$selectedProduit = this.getSelectedProduit();
    final Object other$selectedProduit = other.getSelectedProduit();
    if (this$selectedProduit == null ? other$selectedProduit != null : !this$selectedProduit.equals(other$selectedProduit)) {
      return false;
    }
    final Object this$taxeEnvironnementale = this.getTaxeEnvironnementale();
    final Object other$taxeEnvironnementale = other.getTaxeEnvironnementale();
    if (this$taxeEnvironnementale == null ? other$taxeEnvironnementale != null : !this$taxeEnvironnementale.equals(other$taxeEnvironnementale)) {
      return false;
    }
    return true;
  }

  protected boolean canEqual(final Object other) {
    return other instanceof CombinaisonTarifDTO;
  }

  public int hashCode() {
    final int PRIME = 59;
    int result = 1;
    final Object $dateEntreeVigueur = this.getDateEntreeVigueur();
    result = result * PRIME + ($dateEntreeVigueur == null ? 43 : $dateEntreeVigueur.hashCode());
    final Object $caisses = this.getCaisses();
    result = result * PRIME + ($caisses == null ? 43 : $caisses.hashCode());
    final Object $produits = this.getProduits();
    result = result * PRIME + ($produits == null ? 43 : $produits.hashCode());
    final Object $produitsMedecinsReseauSoins = this.getProduitsMedecinsReseauSoins();
    result = result * PRIME + ($produitsMedecinsReseauSoins == null ? 43 : $produitsMedecinsReseauSoins.hashCode());
    final Object $produitsMedecinsPremierRecours = this.getProduitsMedecinsPremierRecours();
    result = result * PRIME + ($produitsMedecinsPremierRecours == null ? 43 : $produitsMedecinsPremierRecours.hashCode());
    final Object $selectedProduit = this.getSelectedProduit();
    result = result * PRIME + ($selectedProduit == null ? 43 : $selectedProduit.hashCode());
    final Object $taxeEnvironnementale = this.getTaxeEnvironnementale();
    result = result * PRIME + ($taxeEnvironnementale == null ? 43 : $taxeEnvironnementale.hashCode());
    return result;
  }

  public String toString() {
    return "CombinaisonTarifDTO(dateEntreeVigueur=" + this.getDateEntreeVigueur() + ", caisses=" + this.getCaisses() + ", produits=" + this.getProduits()
      + ", produitsMedecinsReseauSoins=" + this.getProduitsMedecinsReseauSoins() + ", produitsMedecinsPremierRecours="
      + this.getProduitsMedecinsPremierRecours() + ", selectedProduit=" + this.getSelectedProduit() + ", taxeEnvironnementale=" + this.getTaxeEnvironnementale()
      + ")";
  }
}
