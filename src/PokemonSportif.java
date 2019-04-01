import java.io.Serializable;

public class PokemonSportif extends PokemonTerre implements Serializable {

	private int freqCard;

	public PokemonSportif(String nom, float poids, int nbPattes, int taille, int freqCard) {
		super(nom, poids, nbPattes, taille);

		this.freqCard = freqCard;
	}

	public String toString() {
		return super.toString() + " ma fréquence cardiaque est de " + this.freqCard + " pulsations par minute";
	}

}
