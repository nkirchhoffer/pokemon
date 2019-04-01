import java.io.Serializable;

public class PokemonMer extends PokemonEau implements Serializable {

	/**
	 * Constructeur du Pokemon Mer
	 * @param nom nom du Pokémon
	 * @param poids poids du Pokémon (kg)
	 * @param nbPattes nombre de pattes
	 */
	public PokemonMer(String nom, float poids, int nbPattes) {
		super(nom, poids, nbPattes);
	}

	/**
	 * Vitesse du Pokemon ((poids / 25) * nageoires)
	 */
	public double calculVitesse() {
		return (this.poids / 25) * this.nageoires;
	}

	/**
	 * Affiche l'objet sous forme de texte
	 */
	public String toString() {
		return super.toString() + "ma vitesse est de " + this.calculVitesse() + "km/h, j'ai " + this.nageoires + " nageoires";
	}

}
