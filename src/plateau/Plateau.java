package plateau;

import java.util.ArrayList;
import java.util.Scanner;
import caseSansPropritaire.Depart;
import joueurMonopoly.JoueurMonopoly;

public class Plateau {
	private final int NB_CASES = 40;
	private Case[] plateau;
	private ArrayList<JoueurMonopoly> joueurs=new ArrayList<>();
	private ArrayList<Case> cases =new ArrayList<>();
	Scanner scanner = new Scanner(System.in);
	
	public void InitialiserPlateau() {
		plateau[0]=new Depart();
	}

}
