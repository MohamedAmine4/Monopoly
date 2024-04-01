package casePropreitaire;

import joueurMonopoly.JoueurMonopoly;
import plateau.Case;

public class Terrain  extends Case{
	private int prix;
	private String nom;
	private int loyer;
	private int nbmaison;//nombre de maison dans le terrain
	private int nbHotel;
	private int prixMaison;//prix pour construire une maison
	private int prixHotel;//prix pour construire un hotel
	private String couleur;//pour savoir les groupes  des terraines
	private JoueurMonopoly propritaire;
	public Terrain(String nom,int prix,int loyer,int prixMaison,int prixHotel,String couleur) {
		super(nom);
		this.nom=nom;
		this.prix=prix;
		this.loyer=loyer;
		this.prixMaison=prixMaison;
		this.prixHotel=prixHotel;
		this.couleur=couleur;
		this.propritaire=null;
	}
	
	public int getPrix() {
		return prix;
	}

	public String getNom() {
		return nom;
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
	public int getNbmaison() {
		return nbmaison;
	}
	public void setNbmaison(int nbmaison) {
		this.nbmaison = nbmaison;
	}
	public int getNbHotel() {
		return nbHotel;
	}
	public void setNbHotel(int nbHotel) {
		this.nbHotel = nbHotel;
	}
	public int getPrixMaison() {
		return prixMaison;
	}
	public void setPrixMaison(int prixMaison) {
		this.prixMaison = prixMaison;
	}
	public int getPrixHotel() {
		return prixHotel;
	}
	public void setPrixHotel(int prixHotel) {
		this.prixHotel = prixHotel;
	}
	public String getCouleur() {
		return couleur;
	}
	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}
	public JoueurMonopoly getPropritaire() {
		return propritaire;
	}
	public void setPropritaire(JoueurMonopoly propritaire) {
		this.propritaire = propritaire;
	}

	@Override
	public String toString() {
		return "nom : "+nom +" nbmaison=" + nbmaison + ", nbHotel=" + nbHotel
			+" \n";
	}
	
}
