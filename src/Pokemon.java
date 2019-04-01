import java.io.Serializable;

/**
 * Classe abstraite Pokemon
 * @author Nicolas Kirchhoffer
 * @version 1.0.0
 */
abstract class Pokemon implements Serializable, Comparable<Pokemon> {

	/**
	 * Attributs d'un Pokemon
	 */
	private String nom;
	protected float poids;

	/**
	 * Constructeur de Pokemon
	 * @param nom nom du Pokémon
	 * @param poids poids du Pokémon
	 */
	public Pokemon(String nom, float poids) {
		this.nom = nom;
		this.poids = poids;
	}

	/**
	 * Mise sous String de l'objet
	 */
	public String toString() {
		return "Je suis le pokémon " + this.nom + ", mon poids est de " + this.poids + "kg, ";
	}

	/**
	 * Méthode abstraite caractérisant la vitesse individuelle des filles
	 * @return vitesse du Pokémon
	 */
	abstract double calculVitesse();

	/**
	 * Getter du nom
	 * @return nom du Pokémon
	 */
	public String getNom() {
		return this.nom;
	}

	/**
	 * Setter du nom
	 * @param nom nom du Pokémon
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * Getter du poids
	 * @return poids du Pokémon (kg)
	 */
	public float getPoids() {
		return this.poids;
	}

	/**
	 * 
	 * @param b instance de Pokémon à comparer
	 * @return -1, 0 ou 1 en fonction du résultat de la comparaison
	 */
	@Override
	public int compareTo(Pokemon b) {
		if (b.getNom().equals(this.nom)) {
			if (b.getPoids() > this.poids) {
				return -1;
			}
		}

		return this.nom.compareTo(b.nom);
	}
	
	/**
	 * Vérifier l'égalité avec un Pokemon
	 * @param b instance de Pokémon
	 * @return vrai ou faux
	 */
	public boolean equals(Pokemon b) {
		if (this.nom != b.getNom()) {
			return false;
		}

		if (this.poids != b.getPoids()) {
			return false;
		}

		return true;
	}

}