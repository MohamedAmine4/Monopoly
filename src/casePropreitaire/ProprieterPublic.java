package casePropreitaire;

import joueurMonopoly.JoueurMonopoly;
import plateau.Case;

public class ProprieterPublic extends Case{
    private JoueurMonopoly proprietaire;
    private int prix;
    private int loyer;
    private String nom;
    public ProprieterPublic(String nom, int prix, int loyer) {
        super(nom);
        this.nom=nom;
        this.prix = prix;
        this.loyer = loyer;
        this.proprietaire = null;
    }
    public ProprieterPublic(String nom, int prix) {
        super(nom);
        this.nom=nom;
        this.prix = prix;
    }

	public JoueurMonopoly getProprietaire() {
		return proprietaire;
	}

	public void setProprietaire(JoueurMonopoly proprietaire) {
		this.proprietaire = proprietaire;
	}

	public int getPrix() {
		return prix;
	}
  
	public void setPrix(int prix) {
		this.prix = prix;
	}

	public int getLoyer() {
		return loyer;
	}

	public void setLoyer(int loyer) {
		this.loyer = loyer;
	}
	@Override
	public String toString() {
		return "nom =" + nom +"\n";
	}
	public String Affiche() {
		return "proprietaire=" + proprietaire + "\n ********\nprix=" + prix + "\nloyer=" + loyer+" *******";
	}

}
