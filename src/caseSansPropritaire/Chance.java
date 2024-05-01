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

public class Chance extends Case {
    protected ArrayList<String> carteChance;

	public Chance() {
		super("Chance");
		 carteChance = new ArrayList<>();
	     chargerCarte();
	}
	 public ArrayList<String> getCarteChance() {
			return carteChance;
		}
	 
	 
	public void chargerCarte() {
        String path = "carte_chance.csv";
        String line = "";
        BufferedReader fi = null;

        try {
            fi = new BufferedReader(new FileReader(path));
            while ((line = fi.readLine()) != null) {
                carteChance.add(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	
	
	  public void removeCarteChance(String carte) {
		  carteChance.remove(carte);
	  }

	  public String tirerCarte() {
		    int taille = carteChance.size();
		    Random r = new Random();
		    int rand = r.nextInt(taille); // Utiliser taille plutôt que taille + 1
		    String carteObtenu = carteChance.get(rand);
		    removeCarteChance(carteObtenu);
		    // Supprimer les guillemets doubles
		    carteObtenu = carteObtenu.substring(1, carteObtenu.length() - 1);
		    return carteObtenu;
		}

	  
	  public static void  Appliquercarte(JoueurMonopoly j, String carte) {
	
		    switch(carte) {
		
		        case "Avancez jusqu’à la case Départ.":
		            j.setPosition(0);
		            break;
		        case "Avancez jusqu’à la Rue de la Paix.":
		            j.setPosition(39);
		            break;
		        case "Avancez jusqu’à l’Avenue Henri-Martin.":
		            j.setPosition(24);
		            break;
		        case "Avancez jusqu’à la Gare de Lyon.Si vous passez par la case Départ, recevez 200M.":
		        	if(j.getPosition()>15) {
		        		j.setArgent(j.getArgent()+200);
		            j.setPosition(15);
		            }
		        	else j.setPosition(15);
		            break;
		        case "Amende pour excès de vitesse : 150M.":
		        	j.setArgent(j.getArgent()-150);
		        	break;
		        case "Vous êtes libéré de prison.Cette carte peut être conservée jusqu’à ce qu’elle soit utilisée.":
		        	if(j.getsOnPrison()==true)
		        		j.setOnPrison(false);
		        	else j.getCarteChance().add(carte);
		        	break;
		        case "Allez en prison.Avancez directement à la prison. Ne passez pas par la case Départ.Ne recevez pas 200M.":
		        	j.setPosition(10);
		        	
		        	break;
		        case "Reculez de trois cases.":
		            j.setPosition(j.getPosition()-3);
		            break;
		        case "Faites des réparations dans toutes vos maisons.Payez 25M par maison et 100M par hôtel.":
		            ArrayList<Terrain> terrain=j.getTerrain();
		            for(Terrain t :terrain) {
		            	if(t.getNbmaison()>0) {
		            		j.setArgent(j.getArgent()-(t.getNbmaison()*25));
		            		if(t.getNbHotel()>0) {
		            			j.setArgent(j.getArgent()-(t.getNbHotel()*100));
		            		}
		            	}
		            	
		            }
		            break;
		        case "Payez une amende de 20M":
		        	j.setArgent(j.getArgent()-20);
		        	break;
		        case "Votre immeuble et votre prêt rapportent.Vous devez toucher 150M.":
		        	j.setArgent(j.getArgent()+150);
		        	break;
		        default:
		            System.out.println("Carte non reconnue.");
		            System.out.println(carte);
		            break;
		    }
		}
	  
	  
	@Override
	public String toString() {
		return "Carte [carteChance=" + carteChance +"]";
	}
}
