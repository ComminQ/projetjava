package net.stri.fdjava.views;

import static net.stri.fdjava.utils.Console.println;

import net.stri.fdjava.controllers.BoutiqueController;
import net.stri.fdjava.controllers.DonjonController;
import net.stri.fdjava.controllers.InventaireController;
import net.stri.fdjava.utils.Console;

/**
 * Représente la vue d'un donjon
 * 
 * @author Fabien CAYRE (Computer)
 *
 * @date 30/04/2021
 */
public class SalleDonjonVue {

	public static final String DISPLAY_ROOM = "" +
		"+------+------+\n" +
		"|      %s      |\n" +
		"+             +\n" +
		"| %s         %s |\n" +
		"+             +\n" +
		"|      %s      |\n"+ 
		"+------+------+";

	private DonjonController controleur;

	public SalleDonjonVue(DonjonController controleur) {
		this.controleur = controleur;
	}

	public void afficherEntree() {
		println("§e" + controleur.getNomHeros() + " §f, vous entrez dans le §edonjon§f !");
		println("§fVous êtes dans §ela salle principale");
		controleur.entrer();
	}

	public boolean selectionnerSalle() {
		boolean[] sallesDisponibles = this.controleur.getSalleDisponible();
		String affichageDesSalles = DISPLAY_ROOM;
		for (int i = 0; i < 4; i++) {
			affichageDesSalles = affichageDesSalles
				.replaceFirst(
					"%s",
					sallesDisponibles[i] ? Direction.getForDonjon(i).getTag() : "B");
		}
		println(controleur.afficherStatistique());
		println("§fVoici à quoi ressemble la salle dans la quelle vous vous trouvez :§r");
		println("§e" + affichageDesSalles + "§r");
		println("§fEntrez une direction pour rejoindre cette salle§r");
		String choix = "";
		for (Direction direction : Direction.values()) {
			choix += direction.toString() + " (" + direction.getTag() + " : " + direction.getDirectionForDonjon() + "), ";
		}
		choix += "Bloqué (B)";

		println("§dChoix des directions : §f" + choix);
		println("§dOuvrir l'inventaire: §f"+Direction.values().length);
		println("§dOuvrir la boutique: §f"+(Direction.values().length + 1));
		int direction = -1;
		while (!this.controleur.estDisponible(direction)) {
			while (direction < 0 || direction > Direction.values().length+1) {
				direction = Console.demanderEntier();
			}
			if (this.controleur.estDisponible(direction)) break;
			if (direction == Direction.values().length) {
				// Ouvrir l'inventaire
				InventaireController controleurInv = new InventaireController(controleur.getHeros()); 
				InventaireVue inventaireVue = new InventaireVue(controleurInv);
				inventaireVue.utiliserInventaire();
				return true;
			}
			if(direction == Direction.values().length + 1) {
				// Ouvrir la boutique
				BoutiqueController controleurBoutique = new BoutiqueController(controleur);
				BoutiqueVue boutiqueVue = new BoutiqueVue(controleurBoutique);
				boutiqueVue.utiliserBoutique();
				return true;
			}
			println("§cCette direction n'est pas disponible");
			println("§fEcrivez le numéro de la direction : ");
			direction = -1;
		}
		if (this.controleur.estUnidirectionelle(direction)) {
			println("§l§c! Oh non ! Vous êtes tombé dans un trou, vous ne pouvez pas revenir en arrière !§r");
		}
		this.controleur.changerSalle(direction);
		return false;
	}

}
