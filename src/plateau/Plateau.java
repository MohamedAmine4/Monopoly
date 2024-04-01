package plateau;

import java.util.ArrayList;

import java.util.InputMismatchException;
import java.util.Scanner;


import casePropreitaire.ProprieterPublic;
import casePropreitaire.Terrain;
import caseSansPropritaire.AllerPrison;
import caseSansPropritaire.Chance;
import caseSansPropritaire.Communaute;
import caseSansPropritaire.Depart;
import caseSansPropritaire.Impot;
import caseSansPropritaire.ParcGratuit;
import caseSansPropritaire.Prison;
import joueurMonopoly.JoueurMonopoly;

public class Plateau {
	private final int NB_CASES = 40;
	private Des des;
	private Case[] plateau;
	private ArrayList<JoueurMonopoly> joueurs=new ArrayList<>();
	private ArrayList<Case> cases =new ArrayList<>();
	Scanner scanner = new Scanner(System.in);
	public Plateau() {
		plateau = new Case[NB_CASES];
		joueurs = new ArrayList<JoueurMonopoly>();
		InitialiserPlateau();
		des =new Des();
		ajouterJoueurs();
	}
	public void InitialiserPlateau() {
		plateau[0]=new Depart();
		plateau[1]=new Terrain("Boulvard de belleville", 60,2, 50, 50, "marron");//(String nom,int prix,int loyer,int prixMaison,int prixHotel,String couleur) 
		plateau[2]=new Communaute();
		plateau[3]=new Terrain("Rue Lecourbe",60, 4, 50, 50, "marron");
		plateau[4]=new Impot();
		plateau[5]=new ProprieterPublic("Gare Montparinasse",200,25);
		plateau[6]=new Terrain("Rue de Vaugirad",100, 6, 50, 50, "bleu ciel");
		plateau[7]=new Chance();
		plateau[8]=new Terrain("Rue de Courcelles",100, 6, 50, 50, "bleu ciel");
		plateau[9]=new Terrain("Avenu de la republique",120, 8, 50, 50, "bleu ciel");
		plateau[10]=new Prison();
		plateau[11]=new Terrain("Boulvard de la villete",40, 10, 100, 100, "rose");
		plateau[12]=new ProprieterPublic("Electricité",150,1);
		plateau[13]=new Terrain("Avenu de neuilly",40, 10, 100, 100, "rose");
		plateau[14]=new Terrain("Rue de Paradis",60, 12, 100, 100, "rose");
		plateau[15]=new ProprieterPublic("Gare de Lyon",200,25);
		plateau[16]=new Terrain("Avenu de Mouzart",180, 14, 100, 100, "orange");
		plateau[17]=new Communaute();
		plateau[18]=new Terrain("Boulvard saint Michel",180, 14, 100, 100, "orange");
		plateau[19]=new Terrain("Place Pigalle",200, 16, 100, 100, "orange");
		plateau[20]=new ParcGratuit();
		plateau[21]=new Terrain("Avenu de matignon",220, 18, 150, 150, "rouge");
		plateau[22]=new Chance();
		plateau[23]=new Terrain("Boulvard Malesherbes",220, 18, 150, 150, "rouge");
		plateau[24]=new Terrain("Avenu henri-Martin",240, 20, 150, 150, "rouge");
		plateau[25]=new ProprieterPublic("Gare du nord",200,25);
		plateau[26]=new Terrain("Faubourg saint honore", 260,22, 150, 150, "jaune");
		plateau[27]=new Terrain("Place de la bourse",260, 22, 150, 150, "jaune");
		plateau[28]=new ProprieterPublic("eau",150,1);//le loyer c 4*le resultats de des 
		plateau[29]=new Terrain("Rue la fayette",280, 24, 150, 150, "jaune");
		plateau[30]=new AllerPrison();
		plateau[31]=new Terrain("Avenu de bereteuil", 300,26, 200, 200, "vert");
		plateau[32]=new Terrain("Avenu Foch",300, 26, 200, 200, "vert");
		plateau[33]=new Communaute();
		plateau[34]=new Terrain("Boulvard Des Capucines", 320,28, 200, 1400, "vert");
		plateau[35]=new ProprieterPublic("Gare Saint-Lazare",200,25);
		plateau[36]=new Chance();
		plateau[37]=new Terrain("Avenu des champs-elysees",350, 35, 200, 200, "bleu");
		plateau[38]=new ProprieterPublic("taxe de luxe",150);
		plateau[39]=new Terrain("Rue de la paix",400, 50, 200, 200, "bleu");

		
	}
	private void ajouterJoueurs() { 
		 Scanner scanner = new Scanner(System.in);
			int nombreJoueur;
			System.out.print("Saisir le nombre des joueurs : ");
			nombreJoueur=scanner.nextInt();
			scanner.nextLine();
			
			for (int i = 1; i <= nombreJoueur; i++) {
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
public void jouer() {
	int nbrRound=0;
	boolean fintour=false;
	
	while(!fintour) {
		nbrRound++;
		System.out.println("############## Tour "+nbrRound+" ##############");
		for(JoueurMonopoly j:joueurs) {
			System.out.println("");
			System.out.println("c le Tour de "+j.getNom()+" il a "+j.getArgent()+" £");
			if (j.getArgent() <=0) {
				System.out.println(j.getNom() + " n'a plus d'argent et quitte le jeu !");
				joueurs.remove(j);
				break;
			}
			else if(j.getsOnPrison() && j.getNbToursEnPrison()<3) {
				System.out.println("le joueur "+j.getNom()+" ne peut pas jouer il est en Prison");
				j.resteEnPrison();
				if(j.getNbToursEnPrison()==2) 
				   {
				   j.setNbToursEnPrison(0);
				   j.setOnPrison(false); 
				   }
			}
			else {
				LancerTour(j);
			}
		}
		if (joueurs.size() == 1) {
			System.out.println("#####################################");
			System.out.println("Fin de la partie ! Le gagnant est " + joueurs.get(0).Afficher());
			fintour = true;
			scanner.close();
		}
		
	}
}
	public void LancerTour(JoueurMonopoly j) {
		int des1=des.lancerDe();
		int des2=des.lancerDe();
		int totalDes = des1 + des2;
		//ajouter le cas de double de dé
		
		int position=j.getPosition()+totalDes;
		
		j.setPosition(position);
		System.out.println(j.getNom() + " lance les des et fait " + des1 + " + " + des2 + " = " + totalDes);
		if (position >=NB_CASES) {
			position-=NB_CASES;
			j.setPosition(position);
			j.ajouterArgent(200);
			System.out.println(j.getNom() + " passe par la case départ et reçoit 200 euros");
		}
		else {
			Case ca = plateau[position];
			System.out.println(j.getNom()+" est dans la case "+ca.getNom());
		   if(ca instanceof ProprieterPublic  ) {
			   ProprieterPublic p=(ProprieterPublic) ca;
			   if(p.getProprietaire()==null) {
				   j.AjouterPropriter(ca, j);
			   }
			   else  if(p.getProprietaire() != j) {
				   int loyer=p.getLoyer();
				   j.payerLoyer(loyer);
				   JoueurMonopoly prorietaire =p.getProprietaire();
				   prorietaire.ajouterArgent(loyer);
				   System.out.println("Vous Avez verser un montant de "+loyer+" £ de loyer a "+prorietaire.getNom()+" votre solde Actuelle est "+j.getArgent());
			   }
			   
		   }
		   else if ( ca instanceof Terrain) {
			   Terrain p=(Terrain) ca;
			   if(p.getPropritaire()==null) 
				   j.AjouterPropriter(ca, j);
			   else if(p.getPropritaire() != j) {// si le proprieteir de case et n'est pas le persone qui joue
				   int loyer=p.getLoyer();
				   j.payerLoyer(loyer);
				   JoueurMonopoly prorietaire =p.getPropritaire();
				   prorietaire.ajouterArgent(loyer);
				   System.out.println("Vous Avez verser un montant de "+loyer+" £ de loyer a "+prorietaire.getNom()+" votre solde Actuelle est "+j.getArgent());
				   
				   
				   
				   
				   
				   
				   
				   
				   
			   }
			   else { 
				  System.out.println("c votre proprieter !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
				  if(p.getNbmaison()<=4 && p.getNbHotel()==0) {
					  if(j.getArgent()>=p.getPrixMaison()) {  
						  System.out.println("vous voulez construire une maison a ce terrain (Oui,Non) avec prix= "+p.getPrixMaison());
					      String res=scanner.nextLine().toLowerCase();
					      if(res.equals("oui")) {
					    	  j.setArgent(j.getArgent()-p.getPrixMaison());
					    	  int nbMaisonActuel= p.getNbmaison();
					    	  System.out.println(j.getNom() +" a acheté un maison .Votre solde actuelle est "+j.getArgent());
					    	  p.setNbmaison(nbMaisonActuel+1);
					    	  switch(nbMaisonActuel) {
					    	  case 1 : p.setLoyer(5*p.getLoyer());break;
					    	  case 2 : p.setLoyer(14*p.getLoyer());break; 
					    	  case 3 : p.setLoyer(36*p.getLoyer());break; 
					    	  case 4 : p.setLoyer(45*p.getLoyer());break; 
					    	  default: break ;
					    	  }
				
					      }
					      else System.out.println(j.getNom()+" n'a pas acheté des maisons pour le terrain "+p.getNom());
						  
					  }
					  else 
						 System.out.println("Vous pouvez pas acheter la maison de prix  "+ p.getPrixMaison()); 
				  }
				  else {
					  if(j.getArgent()>=p.getPrixHotel() && p.getNbHotel()==0) {
						  
						  System.out.println("vous voulez construire un hotel a ce terrain (Oui,Non) avec prix= "+p.getPrixHotel());
					      String res=scanner.nextLine().toLowerCase();
					      if(res.equals("oui")) {
					    	  j.setArgent(j.getArgent()-p.getPrixHotel());
					    	  p.setNbHotel(1);
					    	  System.out.println(j.getNom() +" a acheté un hotel .Votre solde actuelle est "+j.getArgent());
					    	  p.setLoyer(50*p.getLoyer());
					      }
					      else System.out.println(j.getNom()+" n'a pas acheté un hotel pour le terrain "+p.getNom());
					      
					  }  else 
							 System.out.println("Vous pouvez pas acheter l'hotel de prix  "+ p.getPrixHotel()); 
					  
				  }
			   
			   }
			   
		   }   else if ( ca instanceof AllerPrison) {
			   j.setOnPrison(true); 
			  System.out.println(j.getNom()+" est partie a la prison");
			  j.setPosition(10);
		   }
		   else if (ca instanceof Prison) {
				   j.setOnPrison(true);
				   System.out.println(j.getNom()+" est partie a la prison");
					  j.setPosition(10);
					  
		   }
		   else if(ca instanceof Impot) {
			   j.setArgent(j.getArgent()-200);
		   }
		 
		}
	}
	
}
