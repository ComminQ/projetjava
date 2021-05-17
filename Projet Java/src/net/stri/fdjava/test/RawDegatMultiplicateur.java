package net.stri.fdjava.test;

public class RawDegatMultiplicateur {

	public static double getDegatReductionPerc(double armor) {
		return (1-getDegatMultiplicateur(armor))*100;
	}
	
	/**
	 * 
	 * @author Fabien CAYRE (Computer)
	 *
	 * @return
	 * @date 17/05/2021
	 */
	public static double getDegatMultiplicateur(double armor) {
		return 100 / (100 + armor);
	}
	
	public static void main(String[] args) {
		System.out.println(getDegatReductionPerc(10));
		System.out.println(getDegatReductionPerc(20));
		System.out.println(getDegatReductionPerc(30));
		System.out.println(getDegatReductionPerc(40));
		System.out.println(getDegatReductionPerc(50));
		System.out.println(getDegatReductionPerc(100));
		System.out.println(getDegatReductionPerc(200));
	}
	
}
