package casePropreitaire;

import plateau.Case;

public class Terrain  extends Case{
	private int loyer;
	private int nbmaison;//nombre de maison dans le terrain
	private int nbHotel;
	private int prixMaison;//prix pour construire une maison
	private int prixHotel;//prix pour construire un hotel
	private String couleur;//pour savoir les groupes  des terraines
	public Terrain(String nom,int loyer,int prixMaison,int prixHotel,String couleur) {
		super(nom);
		this.loyer=loyer;
		this.prixMaison=prixMaison;
		this.prixHotel=prixHotel;
		this.couleur=couleur;
	}
	

}
