import java.io.Serializable;

/**
 * Classe caract�risant les Pokemon casaniers
 * @author Nicolas Kirchhoffer
 * @version 1.0.0
 */
public class PokemonCasanier extends PokemonTerre implements Serializable {

	/**
	 * Nombre d'heures pass�es � regarder la TV
	 */
	protected float nbHeuresTV;

	/**
	 * Constructeur de PokemonCasanier
	 * @param nom nom du Pok�mon
	 * @param poids poids du Pok�mon
	 * @param nbPattes nombre de pattes
	 * @param taille taille du Pok�mon
	 * @param nbHeuresTV nombre d'heures pass�es devant la TV
	 */
	public PokemonCasanier(String nom, float poids, int nbPattes, float taille, float nbHeuresTV) {
		super(nom, poids, nbPattes, taille);

		this.nbHeuresTV = nbHeuresTV;
	}
	
	/**
	 * Mise sous String de l'objet
	 */
	public String toString() {
		return super.toString() + " je regarde la t�l� " + this.nbHeuresTV + "h par jour";
	}

}
