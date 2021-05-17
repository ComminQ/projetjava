package net.stri.fdjava;

import net.stri.fdjava.controllers.CombatControleur;
import net.stri.fdjava.controllers.DonjonController;
import net.stri.fdjava.models.entity.Heros;
import net.stri.fdjava.test.RawCreerHerosControllerTest;
import net.stri.fdjava.utils.Console;
import net.stri.fdjava.views.CombatVue;
import net.stri.fdjava.views.SalleDonjonVue;

public class Main {

	public static void main(String[] args) {
		Heros heros = RawCreerHerosControllerTest.creerHeros();
		DonjonController controleur = new DonjonController(heros);
		SalleDonjonVue vue = new SalleDonjonVue(controleur);

		vue.afficherEntree();
		
		
		boolean estTermine = false;
		boolean aGagne = false;
		
		
		while (!estTermine) {
			boolean retourBoucle = vue.selectionnerSalle();
			if(retourBoucle) {
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
				combatVue.afficherFinCombat();
				if(combatControl.estTermine()) {
					// On supprime le combat
					controleur.setCombatActuel(null);
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
		
	}

}
