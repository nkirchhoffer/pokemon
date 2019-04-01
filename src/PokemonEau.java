import java.io.Serializable;

public abstract class PokemonEau extends Pokemon implements Serializable {

	/**
	 * Nombre de nageoires du Pokemon
	 */
	protected int nageoires;

	/**
	 * Constructeur du Pokémon Eau
	 * @param nom nom du Pokémon
	 * @param poids poids du Pokémon
	 * @param nageoires nombre de nageoires du Pokemon
	 */
	public PokemonEau(String nom, float poids, int nageoires) {
		super(nom, poids);

		this.nageoires = nageoires;
	}

	/**
	 * Méthode retournant la vitesse du Pokemon
	 */
	abstract double calculVitesse();

	/**
	 * Retourne l'objet sous forme de texte
	 */
	public String toString() {
		return super.toString() + "j'ai " + this.nageoires + " nageoires, ";
	}

	/**
	 * Définit un nombre de nageoires
	 * @param nageoires nombre de nageoires
	 * @throws IllegalArgumentException
	 */
	public void setNageoires(int nageoires) throws IllegalArgumentException {
		if (nageoires < 0) {
			throw new IllegalArgumentException("Le nombre de nageoires doit être positif.");
		}

		this.nageoires = nageoires;
	}
}
