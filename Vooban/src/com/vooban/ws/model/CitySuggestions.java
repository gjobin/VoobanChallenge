package com.vooban.ws.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.vooban.entity.City;
import com.vooban.utils.StringTools;

/**
 * Entité correspondant à la réponse du Service Web de suggestion de villes
 * selon recherche.
 * 
 * @author Guillaume Jobin
 */
public class CitySuggestions {

	private static final String NAME_SEP = ", ";

	private List<CitySuggestion> suggestions = null;

	/**
	 * Construit l'objet de réponse à partir d'une liste de résultat de villes.
	 * 
	 * @param cities
	 *            Liste de résultat de villes.
	 * @param q
	 *            Critère de recherche texte pour déterminer le score.
	 * @param gpsLat
	 *            Critère de recherche lattitude pour déterminer le score.
	 * @param gpsLong
	 *            Critère de recherche longitude pour déterminer le score.
	 */
	public CitySuggestions(List<City> cities, String q, Double gpsLat, Double gpsLong) {
		suggestions = new ArrayList<CitySuggestion>();

		// Modeling for response
		for (City city : cities) {
			CitySuggestion cs = new CitySuggestion();
			cs.setId(city.getId().toString());
			cs.setName(city.getName() + NAME_SEP + city.getStateProv() + NAME_SEP + city.getCountry());
			cs.setLatitude(city.getGpsLat());
			cs.setLongitude(city.getGpsLong());
			cs.setScore(getScore(city, q, gpsLat, gpsLong));

			suggestions.add(cs);
		}

		// Sorting
		Collections.sort(suggestions, new Comparator<CitySuggestion>() {
			@Override
			public int compare(CitySuggestion city2, CitySuggestion city1) {
				return city1.getScore().compareTo(city2.getScore());
			}
		});
	}

	/**
	 * Calcul du score pour une ville.
	 * 
	 * @param city
	 *            Ville traitée.
	 * @param q
	 *            Critère de recherche texte pour déterminer le score.
	 * @param gpsLat
	 *            Critère de recherche lattitude pour déterminer le score.
	 * @param gpsLong
	 *            Critère de recherche longitude pour déterminer le score.
	 * @return
	 */
	private Float getScore(City city, String q, Double gpsLat, Double gpsLong) {
		Float result = 1f;
		if (!(gpsLat != null && gpsLong != null && gpsLat.equals(city.getGpsLat())
				&& gpsLong.equals(city.getGpsLong()))) {
			result = StringTools.getStringSimilarity(city.getName().toUpperCase(), q.toUpperCase());
		}
		return result;

	}

	public List<CitySuggestion> getSuggestions() {
		return suggestions;
	}
}
