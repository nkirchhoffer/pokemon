import java.io.Serializable;

public class PokemonCroisiere extends PokemonEau implements Serializable {

	/**
	 * Constructeur du Pokemon Croisi�re
	 * @param nom nom du Pok�mon
	 * @param poids poids du Pok�mon
	 * @param nbPattes nombre de pattes du Pok�mon
	 */
	public PokemonCroisiere(String nom, float poids, int nbPattes) {
		super(nom, poids, nbPattes);
	}

	/**
	 * Vitesse du Pokemon (poids / 25 * nageoires)/2
	 * @return vitesse du Pokemon
	 */
	public double calculVitesse() {
		return (this.poids / 25 * this.nageoires) / 2;
	}

	/**
	 * Affichage de l'objet sous forme de texte
	 * @return String
	 */
	public String toString() {
		return super.toString() + "ma vitesse est de " + this.calculVitesse() + "km/h, j'ai " + this.nageoires + " nageoires";
	}

}
