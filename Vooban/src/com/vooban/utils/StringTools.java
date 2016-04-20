package com.vooban.utils;

import org.apache.commons.lang.StringUtils;

/**
 * Classe d'utilitaires pour cha�nes de caract�res.
 * 
 * @author Guillaume Jobin
 */
public class StringTools {

	/**
	 * Calcule un taux de correspondance entre 2 chaines de caract�res.
	 * 
	 * @param s1
	 *            Premi�re chaine � comparer
	 * @param s2
	 *            Deuxi�me chaine � comparer
	 * @return Taux arrondi � 4 d�cimales.
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
