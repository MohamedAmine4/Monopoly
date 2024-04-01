package carte;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
public class Carte {
    protected ArrayList<String> carteChance;
    protected ArrayList<String> Communaute;

    public Carte() {
        carteChance = new ArrayList<>();
        Communaute = new ArrayList<>();
        chargerCarte();
        chargerCarteCommunaute();
    }

    public ArrayList<String> getCarteChance() {
		return carteChance;
	}

	public ArrayList<String> getCommunaute() {
		return Communaute;
	}

  public void removeCarteChance(String carte) {
	  carteChance.remove(carte);
  }
public String tirerCarte() {
	int taille=carteChance.size();
	Random r =new Random();
	int rand=r.nextInt(0,taille);
	return carteChance.get(rand);
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
	@Override
	public String toString() {
		return "Carte [carteChance=" + carteChance + ", Communaute=" + Communaute + "]";
	}

	public String Affiche() {
		return "carteChance=" + carteChance + "\nCommunaute=" + Communaute ;
	}
	
}