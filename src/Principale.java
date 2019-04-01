import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

import javax.swing.*;

public class Principale {
	
	public static void gui() {
		JFrame frame = new JFrame("Pokemon");
		frame.setSize(600, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel type = new JPanel();
		type.setLayout(new FlowLayout());
		frame.add(type);
		
		JLabel label = new JLabel("Choisir un type de Pokémon");
		type.add(label);
		
		String[] types = { "Casanier", "Croisière", "Sportif", "Terre" };
		
		JComboBox<String> pokemonList = new JComboBox<String>(types);
		pokemonList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JComboBox box = (JComboBox) e.getSource();
				
			}
		});
		
		type.add(pokemonList);
		
		JPanel nomPanel = new JPanel();
		nomPanel.setLayout(new FlowLayout(FlowLayout.TRAILING, 20, 400));
		type.add(nomPanel);
		
		nomPanel.add(new JLabel("Nom du Pokémon"));
		JTextField nom = new JTextField(25);
		nomPanel.add(nom);
		
		frame.pack();
		frame.setVisible(true);
	}
	
	public static void old(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				gui();
			}
		});
	}

	public static void main(String[] args) {
		Pokedex dex = null;
		
		Scanner input = new Scanner(System.in);

		System.out.print("Action à exécuter ? [read/save]");
		String action = input.next();
		
		if (!action.equals("read")) {
			System.out.println("Sauvegarde d'une nouvelle instance de Pokedex");
			dex = new Pokedex();
			
			PokemonMer mer = new PokemonMer("mer", 45.2f, 30);
			PokemonCroisiere croisiere = new PokemonCroisiere("croisi", 45.2f, 30);
			PokemonSportif sport = new PokemonSportif("sport", 45.2f, 30, 10, 120);
			PokemonCasanier casa = new PokemonCasanier("casa", 45.2f, 30, 10, 10);

			dex.add(new PokemonCasanier("théo", 45.2f, 30, 10, 10));
			
			dex.add(mer);
			dex.add(croisiere);
			dex.add(sport);
			dex.add(casa);
		} else {
			System.out.print("Chemin du fichier de sauvegarde?");
			String file = input.next();
			System.out.println("Lecture du fichier " + file);
			
			dex = Pokedex.lire(file);
		}
		
		dex.forEach(poke -> {
			System.out.println(poke.getNom());
		});
				
		System.out.println("\nListe triée:\n");
		
		dex.sort();
		
		System.out.println(dex.toString());
		
		System.out.println("\nVitesse moyenne : " + dex.vitesseMoyenne() + "km/h");
		
		if (action.equals("save")) {
			System.out.println("\nChemin du fichier à enregistrer ?");
			
			String file = input.next();
			dex.sauvegarder(file);
			
			System.out.println("Enregistrement du Pokédex dans " + file);
		}
	}

}
