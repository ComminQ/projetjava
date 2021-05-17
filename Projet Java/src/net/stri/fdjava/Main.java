package net.stri.fdjava;


import static net.stri.fdjava.utils.Console.println;

import net.stri.fdjava.controllers.ChargerSauvegardeController;
import net.stri.fdjava.controllers.CombatControleur;
import net.stri.fdjava.controllers.DonjonController;
import net.stri.fdjava.models.Sauvegarde;
import net.stri.fdjava.models.entity.Heros;
import net.stri.fdjava.test.RawCreerHerosControllerTest;
import net.stri.fdjava.utils.Console;
import net.stri.fdjava.views.ChargerSauvegardeVue;
import net.stri.fdjava.views.CombatVue;
import net.stri.fdjava.views.SalleDonjonVue;

public class Main {

	public static void main(String[] args) {
		Console.nettoyerEcran();
		ChargerSauvegardeController saveControleur = new ChargerSauvegardeController();
		ChargerSauvegardeVue saveVue = new ChargerSauvegardeVue(saveControleur);
		Sauvegarde save = saveVue.chargerSauvegarder();
		
		Heros heros = null;
		DonjonController controleur = null;
		SalleDonjonVue vue = null;
		if(save == null) {
			println("§aCréation d'une nouvelle partie...");
			// On créer une nouvelle partie
			heros = RawCreerHerosControllerTest.creerHeros();
			controleur = new DonjonController(heros);
			vue = new SalleDonjonVue(controleur);
			vue.afficherEntree();
		}else {
			println("§aChargement d'une partie...");
			// On charge une partie
			heros = save.getHeros();
			controleur = new DonjonController(save);
			vue = new SalleDonjonVue(controleur);
		}
		
		
		
		boolean estTermine = false;
		boolean aGagne = false;
		Console.nettoyerEcran();
		
		while (!estTermine) {
			boolean retourBoucle = vue.selectionnerSalle();
			if(retourBoucle) {
				if(controleur.isQuitterJeu()) {
					break;
				}
				Console.nettoyerEcran();
				continue;
			}
			if (controleur.estCombatDisponible()) {
				controleur.demarrerCombat();
				CombatControleur combatControl = new CombatControleur(heros, controleur);
				CombatVue combatVue = new CombatVue(combatControl);
				while(!combatControl.estTermine()) {
					// Le tour commence par le héros
					combatVue.attaqueHeros();
					// On doit vérifier si l'utlisateur veut fuir
					if(combatVue.isFuir()) {
						Console.nettoyerEcran();
						break;
					}
					// C'est au tour du monstre d'attaquer
					combatVue.attaqueMonstre();
					if(!heros.estEnVie()) {
						// Si le héros est mort lors de l'attaque du monstre, la partie est terminé
						combatVue.herosMort();
						estTermine = true;
						Console.nettoyerEcran();
						break;
					}
				}
				if(combatVue.isFuir()) {
					// le combat est fuit, il faut changer de salle vers la salle prédècente
					// on supprime le combat
					controleur.setCombatActuel(null);
					// on déplace dans l'ancienne salle
					controleur.getHeros().setSalle(controleur.getHeros().getSallePrecedente());
				}
				controleur.remplirVieHeros();
				combatVue.afficherFinCombat();
				if(combatControl.estTermine()) {
					// On supprime le combat
					controleur.setCombatActuel(null);
					// Est ce que le combat est terminé ET que c'est la dernière salle ??
					if(controleur.estDerniereSalle()) {
						estTermine = true;
						aGagne = true;
						break;
					}
				}
			}
			
			// Si l'issue de la partie n'est pas déterminé dans cette boucle
			if(!estTermine) {
				// On demande alors au contrôleur du donjon de savoir l'état de la partie
				estTermine = controleur.estTerminer();
			}
			if(estTermine) {
				Console.nettoyerEcran();
				break;
			}
			Console.nettoyerEcran();
		}
		if(aGagne && !estTermine) {
			println("");
			println("");
			println("§cVotre partie à été sauvegardée ");
		}
		
		
		if(aGagne) {
			println("");
			println("");
			println("§aVOUS AVEZ GAGNÉ ! Bravo ! ");
		}else {
			println("");
			println("");
			println("§cDommage... Ré-essayez!");
		}
		
	}

}
