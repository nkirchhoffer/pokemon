import java.io.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.function.Consumer;

/**
 * Classe Pokedex
 * @author Nicolas Kirchhoffer
 * @version 1.0.0
 */
public class Pokedex implements Serializable {

	private ArrayList<Pokemon> listePokemon;

	/**
	 * Constructeur par d�faut
	 */
	public Pokedex() {
		this.listePokemon = new ArrayList<Pokemon>();
	}

	/**
	 * Ajouter un Pokemon
	 * 
	 * @param arg0 instance de Pokemon
	 * @return true ou false
	 */
	public boolean add(Pokemon arg0) {
		return listePokemon.add(arg0);
	}
	
	/**
	 * Ajouter un Pok�mon selon une position
	 * @param index position dans la liste
	 * @param pokemon instance de Pokemon � ajouter
	 */
	public void add(int index, Pokemon pokemon) {
		listePokemon.add(index, pokemon);
	}

	/**
	 * Recherche dans la liste en fonction du nom
	 * @param nom nom du Pok�mon � r�cup�rer
	 * @return pokemon instance de Pok�mon correspondant
	 */
	public Pokemon recherche(String nom) {
		for (Pokemon i : this.listePokemon) {
			if (i.getNom() == nom) {
				return i;
			}
		}

		return null;
	}

	/**
	 * Rechercher un Pok�mon en fonction d'une instance
	 * @param a instance de Pok�mon
	 * @return pokemon instance de Pok�mon correspondante
	 */
	public Pokemon recherche(Pokemon a) {
		return this.recherche(a.getNom());
	}

	/**
	 * Permet de v�rifier si la liste contient une instance de Pokemon
	 * @param o un objet
	 * @return bool�en
	 */
	public boolean contains(Object o) {
		return listePokemon.contains(o);
	}

	/**
	 * Supprime un Pok�mon de la liste en fonction de son nom
	 * @param nom nom du Pok�mon � supprimer
	 * @return bool�en
	 */
	public boolean supprimePokemon(String nom) {
		Pokemon poke = this.recherche(nom);

		if (poke == null) {
			return false;
		}

		return this.listePokemon.remove(poke);
	}

	/**
	 * Supprime un Pok�mon de la liste en fontion de son instance
	 * @param a instance de Pok�mon
	 * @return bool�en
	 */
	public boolean supprimePokemon(Pokemon a) {
		return this.supprimePokemon(a.getNom());
	}

	/**
	 * Mise sous String de l'objet
	 */
	public String toString() {
		String res = "La collection est compos�e de :\n";

		for (Pokemon i : this.listePokemon) {
			res += i.toString() + "\n";
		}

		return res;
	}

	/**
	 * Recherche de plusieurs Pok�mon en fonction de leur nom
	 * @param nom nom du Pok�mon
	 * @return ArrayList<Pokemon> des r�sultats
	 */
	public ArrayList<Pokemon> rechercheListe(String nom) {
		ArrayList<Pokemon> res = new ArrayList<Pokemon>();

		for (Pokemon i : this.listePokemon) {
			if (i.getNom() == nom) {
				res.add(i);
			}
		}

		return res;
	}

	/**
	 * Calcul de la vitesse moyenne de tous les Pok�mon de la liste
	 * @return vitesse moyenne - double
	 */
	public double vitesseMoyenne() {
		double somme = 0.0d;

		for (Pokemon i : this.listePokemon) {
			somme += i.calculVitesse();
		}

		return somme / this.listePokemon.size();
	}

	/**
	 * Serialisation de l'objet courant avec les Pok�mon
	 * @param fichier chemin relatif vers le fichier
	 */
	public void sauvegarder(String fichier) {
		try {
			ObjectOutputStream stream = new ObjectOutputStream(new FileOutputStream(fichier));
			stream.writeObject(this);
			stream.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * D�serialisation d'un objet � partir d'un fichier
	 * @param fichier chemin relatif vers le fichier
	 * @return instance de Pok�dex correspondante
	 */
	public static Pokedex lire(String fichier) {
		try {
			ObjectInputStream stream = new ObjectInputStream(new FileInputStream(fichier));
			Pokedex instance = (Pokedex) stream.readObject();
			stream.close();

			return (Pokedex) instance;
		} catch (IOException e) {
			System.out.println(e.getMessage());
			return null;
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
	
	public void clear() {
		listePokemon.clear();
	}

	public Object clone() {
		return listePokemon.clone();
	}

	public Pokemon get(int index) {
		return listePokemon.get(index);
	}

	public int size() {
		return listePokemon.size();
	}

	/**
	 * Tri de la liste � partir de la m�thode compareTo() de Pokemon
	 */
	public void sort() {
		Collections.sort(this.listePokemon);
	}

	/**
	 * Bouclage des �l�ments de la liste 
	 * @param poke instance de Pok�mon, it�rateur
	 */
	public void forEach(Consumer<? super Pokemon> poke) {
		listePokemon.forEach(poke);
	}
}
