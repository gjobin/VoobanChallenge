package com.vooban.ejb;

import java.util.Collection;

import javax.ejb.Remote;

import com.vooban.entity.City;

/**
 * Interface Remote pour l'EJB CitiesBean.
 * 
 * @author Guillaume Jobin
 */
@Remote
public interface Cities {

	/**
	 * Permet d'obtenir des villes correspondant � des crit�res de recherches.
	 * 
	 * @param q
	 *            Crit�re sur le nom.
	 * @param gpsLat
	 *            Lattitude
	 * @param gpsLong
	 *            Longitude
	 * @return Collection d'entit�s de ville.
	 */
	public Collection<City> suggestions(String q, Double gpsLat, Double gpsLong);

}
