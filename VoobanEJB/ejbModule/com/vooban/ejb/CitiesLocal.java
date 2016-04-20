package com.vooban.ejb;

import java.util.Collection;

import javax.ejb.Local;

import com.vooban.entity.City;

/**
 * Interface Locale pour l'EJB CitiesBean.
 * 
 * @author Guillaume Jobin
 *
 */
@Local
public interface CitiesLocal {

	/**
	 * Permet d'obtenir des villes correspondant à des critères de recherches.
	 * 
	 * @param q
	 *            Critère sur le nom.
	 * @param gpsLat
	 *            Lattitude
	 * @param gpsLong
	 *            Longitude
	 * @return Collection d'entités de ville.
	 */
	public Collection<City> suggestions(String q, Double gpsLat, Double gpsLong);

}
