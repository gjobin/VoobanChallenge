package com.vooban.utils;

import org.apache.commons.lang.StringUtils;

/**
 * Classe d'utilitaires pour chaînes de caractères.
 * 
 * @author Guillaume Jobin
 */
public class StringTools {

	/**
	 * Calcule un taux de correspondance entre 2 chaines de caractères.
	 * 
	 * @param s1
	 *            Première chaine à comparer
	 * @param s2
	 *            Deuxième chaine à comparer
	 * @return Taux arrondi à 4 décimales.
	 */
	public static Float getStringSimilarity(String s1, String s2) {
		float result = 1f;

		float distance = StringUtils.getLevenshteinDistance(s1, s2);
		float maxLength = Math.max(s1.length(), s2.length());
		result = (maxLength - distance) / maxLength;
		if (result == 1f) {
			result = result - 0.001f;
		}

		return result;
	}
}
