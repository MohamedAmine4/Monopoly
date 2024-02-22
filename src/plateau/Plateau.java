package plateau;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import caseSansPropritaire.Depart;
import joueurMonopoly.JoueurMonopoly;

public class Plateau {
	private final int NB_CASES = 40;
	private Case[] plateau;
	private ArrayList<JoueurMonopoly> joueurs=new ArrayList<>();
	private ArrayList<Case> cases =new ArrayList<>();
	Scanner scanner = new Scanner(System.in);
	public Plateau() {
		plateau = new Case[NB_CASES];
		joueurs = new ArrayList<JoueurMonopoly>();
		InitialiserPlateau();
		ajouterJoueurs();
	}
	public void InitialiserPlateau() {
		plateau[0]=new Depart();
		
		//ajouter les autres plateaux amine
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	private void ajouterJoueurs() {
		for (int i = 1; i <= 2; i++) {
			System.out.print("Nom du joueur " + i + " : ");
			String nom = null;
			boolean inputIsValid = false;

			while (!inputIsValid) {
				try {
					nom = scanner.nextLine();
					inputIsValid = true;
				} catch (InputMismatchException e) {
					System.out.println("Entrée incorrecte, veuillez saisir une chaîne de caractères.");
					scanner.nextLine();
				}
			}

			joueurs.add(new JoueurMonopoly(nom));
		}
		jouer();

	}
public void jouer() {} // cette fonction gerer les tours des joueure et le positionement de chaque joueur   abdousalam
	
	
}
