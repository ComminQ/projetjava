package net.stri.fdjava.views;

import static net.stri.fdjava.utils.Console.println;

import net.stri.fdjava.controllers.CreerHerosController;
import net.stri.fdjava.models.entity.TypeHeros;
import net.stri.fdjava.utils.Console;

public class CreerHerosVue {

	private CreerHerosController controleur;
	
	public CreerHerosVue(CreerHerosController controleur) {
		super();
		this.controleur = controleur;
	}
	
	public void demanderTypeHeros() {
		int index = -1;
		while(index < 0 || index >= TypeHeros.values().length) {
			println("§fVeuillez saisir le type de votre §eHeros§r!");
			println("§fVous pouvez choisir parmis :");
			for(TypeHeros typeHeros : TypeHeros.values()) {
				println(String.format("\t§e%s §f: §c%d point de dégats§f, §a%d point de vie §f(tapez %d)", typeHeros.toString(), typeHeros.getDegat(), typeHeros.getPointDeVie(), typeHeros.ordinal()));
			}
			try {
				index = Console.demanderEntier();
			}catch (Exception e) {
				Console.vider();
			}
		}
		println("§fVotre heros sera un §e"+TypeHeros.values()[index].toString()+"§r");
		controleur.setTypeHeros(index);
	}
	
	public void demanderNomHeros() {
		println("§fVeuillez saisir le nom de votre §eHéros§r!");
		String name = Console.demanderChaine();
		println("Votre nom sera donc §e"+name+"§r!");
		this.controleur.setNomHeros(name);
	}
	
	
	
	
}
