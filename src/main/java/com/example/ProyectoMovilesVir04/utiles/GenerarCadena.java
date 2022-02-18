package com.example.ProyectoMovilesVir04.utiles;

public class GenerarCadena {

	public static String generarPalabras(int longitud) {
		 String theAlphaNumericS;
	     StringBuilder builder;
	        
	     theAlphaNumericS = "AAAABCDEEEEFGHIJLMNOOOOPRSTUZ";
	     builder = new StringBuilder(longitud); 

	        for (int m = 0; m < longitud; m++) { 
	            int myindex 
	                = (int)(theAlphaNumericS.length() 
	                        * Math.random()); 
	            builder.append(theAlphaNumericS 
	                        .charAt(myindex)); 
	        } 

	        return builder.toString(); 
	}
	
	public static String generarModelo(int longitud) {
		String theAlphaNumericS;
		StringBuilder builder;
		
		theAlphaNumericS = "AAAABCDEEEEFGHIJLMNOOOOPRSTUZ123456789";
		builder = new StringBuilder(longitud); 
		
		for (int m = 0; m < longitud; m++) { 
			int myindex 
			= (int)(theAlphaNumericS.length() 
					* Math.random()); 
			builder.append(theAlphaNumericS 
					.charAt(myindex)); 
		} 
		
		return builder.toString(); 
	}
}
