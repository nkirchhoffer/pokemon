
abstract class PokemonTerre extends Pokemon {

	private float taille;
	private int nbPattes;

	public PokemonTerre(String nom, float poids, int nbPattes, float taille) {
		super(nom, poids);

		this.nbPattes = nbPattes;
		this.taille = taille;
	}

	public String toString() {
		return super.toString() + "ma vitesse est de " + this.calculVitesse() + "km/h, j'ai " + this.nbPattes
				+ " pattes, ma taille est de " + this.taille + "m, ";
	}

	public double calculVitesse() {
		return this.taille * this.nbPattes * 3;
	}

	public float getTaille() {
		return this.taille;
	}

	public void setTaille(float taille) throws IllegalArgumentException {
		if (taille < 0) {
			throw new IllegalArgumentException("La taille indiquée ne peut pas être négative.");
		}

		this.taille = taille;
	}

}
