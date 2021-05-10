package net.stri.fdjava.views;

import static net.stri.fdjava.utils.Console.println;

import lombok.Getter;
import net.stri.fdjava.controllers.CombatControleur;
import net.stri.fdjava.models.entity.Monstre;
import net.stri.fdjava.utils.Console;

public class CombatVue {

	private CombatControleur controleur;
	@Getter
	private boolean fuir = false;

	public CombatVue(CombatControleur combatControl) {
		this.controleur = combatControl;
	}

	private void afficherEtatMonstres(boolean inclureIndex) {
		if(!inclureIndex) {
			println("§fEtats des monstres:");
		}
		for(String string : this.controleur.getMonstres(inclureIndex)) {
			println(string);
		}
	}
	
	public void attaqueHeros() {
		int nbMonstre = this.controleur.nombreMonstre();
		println("§fVous vous battez contre §c"+nbMonstre+"§f monstres!");
		afficherEtatMonstres(false);
		// Il n'y a qu'un seul monstre à affronter
		if(nbMonstre == 1) {
			// Choix de l'utilisateur
			int choix = 0;
			while(choix != 1 && choix != 2) {
				println("§fFaites votre choix :");
				println("§f- §c(1) Fuir §f: vous repartez dans l'ancienne salle");
				println("§f- §e(2) Combattre §f: vous combattez le monstre en face de vous");
				choix = Console.demanderEntier();
			}
			// Il décide de fuir
			if(choix == 1) {
				println("§fVous avez décidé de §cfuir§f.");
				println("§fVous retournez §edans la salle prècedente.");
				fuir = true;
				return;
			}
			// Il décide de combattre
			if(choix == 2) {
				println("§fVous vous apprétez à combattre un §c"+this.controleur.getNomMonstre(0)+"§f!");
				println("§fVous avez infligez §c"+this.controleur.attaqueHeros());
			}
		}else {
			// Il y a plus d'un monstre à affronter
			println("§fIl y a plusieurs monstres en face de vous:");
			afficherEtatMonstres(true);
			println("§f - ("+nbMonstre+ ") §cFuir");
			int pos = -1;
			while(pos < 0 || pos > nbMonstre) {
				println("§fSaisissez le §cnuméro §fdu monstre que vous voulez attaquer");
				pos = Console.demanderEntier();
			}
			if(pos == nbMonstre) {
				println("§fVous avez décidé de §cfuir§f.");
				println("§fVous retournez §edans la salle prècedente.");
				fuir = true;
				return;
			}else {
				println("§fVous attaquez le monstre §cn°"+pos+"§f.");
				println("§fVous avez infligez §c"+this.controleur.attaqueHeros(pos)+" pts de dégats§f!");
			}
		}
	}

	public void attaqueMonstre() {
		for(String attaqueMonstre : this.controleur.attaqueMonstres()) {
			println(attaqueMonstre);
		}
	}

	public void herosMort() {
		println("");
		println("");
		println("§cVous êtes mort au combat ...");
		println("");
		println("");
	}

	public void afficherFinCombat() {
		println("§fLe §ecombat§f est terminé!");
	}

}
