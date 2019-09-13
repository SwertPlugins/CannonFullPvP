package com.cannonnetwork.fullpvp.sorte;

import java.util.Random;

public class PlayerSorteCapa {
	
	public static boolean playerSorte(double sorte) {
		if (sorte > 100 || sorte < 0) {
			throw new IllegalArgumentException("Percentage cannot be greater than 100 or less than 0!");
		}
		double resultado = new Random().nextDouble() * 100;
		return resultado <= sorte;
	}

}
