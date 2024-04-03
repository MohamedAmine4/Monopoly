package joueurMonopoly;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;


import casePropreitaire.ProprieterPublic;
import casePropreitaire.Terrain;
import caseSansPropritaire.Chance;
import plateau.Case;

public class JoueurMonopoly {

	private String nom;
	private int position=0;
	private int Argent;
	private ArrayList<Terrain> terrain =new ArrayList<>();
	private ArrayList<ProprieterPublic> propriterPublic=new ArrayList<>();
	private boolean OnPrison=false;
	private ArrayList<String> carteChance=new ArrayList<>();
	private ArrayList<String> carteCommunaute=new ArrayList<>();
	private int nbToursEnPrison=0;
	private ArrayList<String> reponseIA = new ArrayList<>(Arrays.asList("oui", "Non"));
	private Scanner scanner =new Scanner(System.in);
	public JoueurMonopoly(String nom) {
		this.nom=nom;
		this.Argent=200;
	}

	 public String ReponseIA() {
	        Random random = new Random();
	        int index = random.nextInt(reponseIA.size());
	        return reponseIA.get(index);
	    }
	 
    public void AjouterPropriter(Case c , JoueurMonopoly j) {
    
    	if(c instanceof ProprieterPublic) {
    	if(j.getArgent()>=((ProprieterPublic) c).getPrix()) {
    		System.out.println("voulez vous Acheter cette Proprieter ? Avec un montant de "+((ProprieterPublic) c).getPrix()+" £ (Oui or Non)");
    		String res;
    		if (j.getNom().equals("IA")) {
    		    res = ReponseIA();
    		} else {
    		    res = scanner.nextLine().toLowerCase();
    		}

		if(res.equals("oui")) {
    		j.getPropriterPublic().add((ProprieterPublic) c); //ajouter la propriter a la liste des propiter de joueur
		    int prix=j.getArgent()-((ProprieterPublic) c).getPrix();
		    j.setArgent(prix);// diminuer argent de propritaire apres achat
		    ((ProprieterPublic) c).setProprietaire(j); //ajouter le proprietaire a le service public 
		    System.out.println(j.getNom() + " a acheté " + ((ProprieterPublic) c).getNom());
    	    }
		else 
			System.out.println(j.getNom() + " n'a pas  acheté " + ((ProprieterPublic) c).getNom());
    	}else 
			System.out.println("Vous pouvez pas l'acheter "+j.getNom() + " n'a pas  acheté " + ((ProprieterPublic) c).getNom()+" qui a pour prix "+((ProprieterPublic) c).getPrix());
    	}
    	else if(c instanceof Terrain) {
    		if(j.getArgent()>=((Terrain) c).getPrix()) {
    		System.out.println("voulez vous Acheter cette Proprieter ? Avec un montant de "+((Terrain) c).getPrix()+" £ (Oui or Non)");
    		String res;
    		if (j.getNom().equals("IA")) {
    		    res = ReponseIA();
    		} else {
    		    res = scanner.nextLine().toLowerCase();
    		}

    		if(res.equals("oui")) {
        		j.getTerrain().add((Terrain) c); //ajouter la propriter a la liste des propiter de joueur
    		    int prix=j.getArgent()-((Terrain) c).getPrix();
    		    j.setArgent(prix);// diminuer argent de propritaire apres achat
    		    ((Terrain) c).setPropritaire(j); //ajouter le proprietaire a le service public 
    		    System.out.println(j.getNom() + " a acheté " + ((Terrain) c).getNom());
        	    }
    		else 
    			System.out.println(j.getNom() + " n'a pas  acheté " + ((Terrain) c).getNom());
    		}else 
    			System.out.println("Vous pouvez pas l'acheter "+j.getNom() + " n'a pas  acheté " + ((Terrain) c).getNom()+" qui a pour prix "+((Terrain) c).getPrix());
    	}
		
    }
    
    
    
    public void payerLoyer(int c) {
    	this.Argent-=c;
    }
    
    
    
	public ArrayList<ProprieterPublic> getPropriterPublic() {
		return propriterPublic;
	}

	public void setPropriterPublic(ArrayList<ProprieterPublic> propriterPublic) {
		this.propriterPublic = propriterPublic;
	}

	public int getPosition() {
		return position;
	}


	public void setPosition(int position) {
		this.position = position;
	}


	public int getArgent() {
		return Argent;
	}


	public void setArgent(int argent) {
		Argent = argent;
	}

public void ajouterArgent(int r) {
	Argent+=r;
}
	public ArrayList<Terrain> getTerrain() {
		return terrain;
	}


	public void setTerrain(ArrayList<Terrain> terrain) {
		this.terrain = terrain;
	}






	public ArrayList<String> getCarteChance() {
		return carteChance;
	}

	public void setCarteChance(ArrayList<String> carteChance) {
		this.carteChance = carteChance;
	}

	public ArrayList<String> getCarteCommunaute() {
		return carteCommunaute;
	}

	public void setCarteCommunaute(ArrayList<String> carteCommunaute) {
		this.carteCommunaute = carteCommunaute;
	}

	public String getNom() {
		return nom;
	}


	public boolean isOnPrison() {
		return OnPrison;
	}

    public boolean getsOnPrison() {
    	return OnPrison;
    }
	public void setOnPrison(boolean onPrison) {
		OnPrison = onPrison;
	}

	 public void resteEnPrison() {
	        nbToursEnPrison++;
	    }

	public int getNbToursEnPrison() {
		return nbToursEnPrison;
	}

	public void setNbToursEnPrison(int nbToursEnPrison) {
		this.nbToursEnPrison = nbToursEnPrison;
	}

	@Override
	public String toString() {
		return "JoueurMonopoly [nom=" + nom + ", position=" + position + ", Argent=" + Argent + ", terrain=" +terrain
				+ ", propriterPublic=" + propriterPublic + ", OnPrison=" + OnPrison
				+ ", nbToursEnPrison=" + nbToursEnPrison + "]";
	}
	
	public String Afficher() {
			return "nom=" + nom + " position=" + position + " Argent=" + Argent + "\n ********terrains******** \n" +terrain
					+ "******** \n propriterPublic******** \n" + propriterPublic + "\n ********\n OnPrison=" + OnPrison
					+ "\n nbToursEnPrison=" + nbToursEnPrison+"\n ********";
		
	}
	
	
	
}
