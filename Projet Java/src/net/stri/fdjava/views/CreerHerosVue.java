package net.stri.fdjava.views;

import static net.stri.fdjava.utils.Console.println;

import java.util.Scanner;

import net.stri.fdjava.utils.Console;

public class CreerHerosVue {

	public CreerHerosVue() {
		super();
	}
	
	public String demanderNomHeros() {
		println("§fVeuillez saisir le nom de votre §eHéros§r!");
		String name = Console.demanderChaine();
		println("Votre nom sera donc §e"+name+"§r!");
		return name;
	}
	
	
	
}
