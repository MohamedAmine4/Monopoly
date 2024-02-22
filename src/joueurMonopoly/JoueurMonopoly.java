package joueurMonopoly;

import java.util.ArrayList;

import carte.Carte;
import casePropreitaire.Eau;
import casePropreitaire.Electriciter;
import casePropreitaire.Gare;
import casePropreitaire.Luxe;
import casePropreitaire.Terrain;

public class JoueurMonopoly {

	private String nom;
	private float position=0;
	private int Argent;
	private ArrayList<Terrain> terrain =new ArrayList<>();
	private ArrayList<Gare> gare=new ArrayList<>();
	private ArrayList<Eau> eau=new ArrayList<>();
	private ArrayList<Electriciter> electriciter=new ArrayList<>();
	private ArrayList<Luxe> luxe=new ArrayList<>();
	private boolean OnPrison=false;
	private ArrayList<Carte> carte=new ArrayList<>();
	
	public JoueurMonopoly(String nom) {
		this.nom=nom;
		this.Argent=1500;
	}
}
