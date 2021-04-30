package net.stri.fdjava.views;

import static net.stri.fdjava.utils.Console.println;

import net.stri.fdjava.controllers.DonjonController;

/**
 * Représente la vue d'un donjon
 * @author Fabien CAYRE (Computer)
 *
 * @date 30/04/2021
 */
public class DonjonVue {

	public static final String DISPLAY_ROOM = "" +
		"    %s    \n" + "\n" +
		"%s       %s\n" + "\n" +
		"    %s    \n";

	private DonjonController controleur;

	public DonjonVue(DonjonController controleur) {
		this.controleur = controleur;
	}

	public void afficherEntree() {
		println("§e" + controleur.getNomHeros() + " §f, vous entrez dans le §edonjon§f !");
		println("§fVous êtes dans §ela salle principale");
		controleur.entrer();
	}

	public void selectionnerSalle() {
		boolean[] sallesDisponibles = this.controleur.getSalleDisponible();
		String affichageDesSalles = DISPLAY_ROOM;
		for (int i = 0; i < 4; i++) {
			affichageDesSalles = affichageDesSalles
				.replaceFirst(
					"%s",
					sallesDisponibles[i] ? Direction.getForDonjon(i).getTag() : "B");
		}
		println("§fVoici à quoi ressemble la salle dans la quelle vous vous trouvez :§r");
		println("§e" + affichageDesSalles + "§r");
		println("§fEntrez une direction pour rejoindre cette salle§r");
		String choix = "";
		for (Direction direction : Direction.values()) {
			choix += direction.toString() + " (" + direction.getTag() + "), ";
		}
		choix += "Bloqué (B)";

		println("§dChoix des directions : §f" + choix);

	}

}
