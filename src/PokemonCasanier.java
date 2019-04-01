import java.io.Serializable;

/**
 * Classe caractérisant les Pokemon casaniers
 * @author Nicolas Kirchhoffer
 * @version 1.0.0
 */
public class PokemonCasanier extends PokemonTerre implements Serializable {

	/**
	 * Nombre d'heures passées à regarder la TV
	 */
	protected float nbHeuresTV;

	/**
	 * Constructeur de PokemonCasanier
	 * @param nom nom du Pokémon
	 * @param poids poids du Pokémon
	 * @param nbPattes nombre de pattes
	 * @param taille taille du Pokémon
	 * @param nbHeuresTV nombre d'heures passées devant la TV
	 */
	public PokemonCasanier(String nom, float poids, int nbPattes, float taille, float nbHeuresTV) {
		super(nom, poids, nbPattes, taille);

		this.nbHeuresTV = nbHeuresTV;
	}
	
	/**
	 * Mise sous String de l'objet
	 */
	public String toString() {
		return super.toString() + " je regarde la télé " + this.nbHeuresTV + "h par jour";
	}

}
