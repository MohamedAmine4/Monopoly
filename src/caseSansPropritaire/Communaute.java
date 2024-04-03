package caseSansPropritaire;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import casePropreitaire.Terrain;
import joueurMonopoly.JoueurMonopoly;
import plateau.Case;

public class Communaute extends Case{
    protected ArrayList<String> Communaute;

	public Communaute() {
		super("Communaute");
        Communaute = new ArrayList<>();

        chargerCarteCommunaute();

	}
	public ArrayList<String> getCommunaute() {
		return Communaute;
	}
	
	
	public void chargerCarteCommunaute() {
        String path = "commauniter.csv";
        String line = "";
        BufferedReader fi = null;

        try {
            fi = new BufferedReader(new FileReader(path));
            while ((line = fi.readLine()) != null) {
            	Communaute.add(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

	
	
	public void removeCarteCommunaute(String carte) {
		  Communaute.remove(carte);
	  }
	
	
	
	public String tirerCarteCommunite() {
	    int taille = Communaute.size();
	    Random r = new Random();
	    int rand = r.nextInt(taille); // Utiliser taille plutôt que taille + 1
	    String carteObtenu = Communaute.get(rand);
	    removeCarteCommunaute(carteObtenu);
	    // Supprimer les guillemets doubles
	    carteObtenu = carteObtenu.substring(1, carteObtenu.length() - 1);
	    return carteObtenu;
	}


	
	public static void AppliquerCarteCommunaute(JoueurMonopoly j, String carte) {
	    switch(carte) {
	        case "Avancez jusqu’à Départ (Collectez 200M)":
	            j.setPosition(0);
	            j.setArgent(j.getArgent()+200);
	            break;
	        case "Erreur bancaire en votre faveur. Collectez 200M":
	        	 j.setArgent(j.getArgent()+200);
	        	break;
	        case "Frais médicaux. Payez 50M":
	        	j.setArgent(j.getArgent()-50);
	        	break;
	        case "Vente d'actions, vous recevez 50M":
	        	 j.setArgent(j.getArgent()+50);
	        	break;
	        case "Vous êtes libéré de prison Cette carte peut être conservée jusqu’à ce qu’elle soit utilisée.":
	        	if(j.getsOnPrison()==true)
	        		j.setOnPrison(false);
	        	else j.getCarteCommunaute().add(carte);
	            break;
	        case "Allez en prison Allez directement en prison, ne passez pas par la case départ, ne recevez pas 200M.":
	        	j.setPosition(10);
	        	break;
	        case "Le fonds de vacances arrive à échéance. Recevez 100M":
	        	j.setArgent(j.getArgent()+100);
	        	break;
	        case "Remboursement d'impôt sur le revenu. Collectez 20M":
	        	j.setArgent(j.getArgent()+20);
	            break;
	        case "C'est votre anniversaire. Collectez 10M de chaque joueur":
	        	j.setArgent(j.getArgent()+10);
	            break;
	        case "L'assurance-vie arrive à échéance. Collectez 100M":
	        	j.setArgent(j.getArgent()+100);
	            break;
	        case "Frais d'hôpital de 100M":
	        	j.setArgent(j.getArgent()-100);
	            break;
	        case "Frais de scolarité de 50M":
	        	j.setArgent(j.getArgent()-50);
	            break;
	        case "Recevez 25M de frais de consultation":
	        	j.setArgent(j.getArgent()+25);
	            break;
	        case "Vous êtes évalué pour les réparations de rue. 40M par maison. 115M par hôtel":
	        	ArrayList<Terrain> terrain=j.getTerrain();
	            for(Terrain t :terrain) {
	            	if(t.getNbmaison()>0) {
	            		j.setArgent(j.getArgent()-(t.getNbmaison()*40));
	            		if(t.getNbHotel()>0) {
	            			j.setArgent(j.getArgent()-(t.getNbHotel()*115));
	            		}
	            	}
	            	
	            }
	            break;
	        case "Vous avez gagné le deuxième prix dans un concours de beauté. Collectez 10M":
	        	j.setArgent(j.getArgent()+10);
	            break;
	        case "Vous héritez de 100M":
	        	j.setArgent(j.getArgent()+100);
	            break;
	        default:
	            System.out.println("Carte non reconnue.");
	            break;
	    }
	}

	@Override
	public String toString() {
		return "Communaute [Communaute=" + Communaute + "]";
	}
	
	
	
}
