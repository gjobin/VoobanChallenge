package com.vooban.ejb;

import java.io.Serializable;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.vooban.entity.City;

/**
 * EJB d'accès aux données de Cities.
 * 
 * @author Guillaume Jobin
 *
 */
@Stateless
@LocalBean
public class CitiesBean implements Cities, CitiesLocal, Serializable {
	private static final long serialVersionUID = 1L;

	@PersistenceContext(name = "Vooban")
	private EntityManager em;

	public CitiesBean() {
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<City> suggestions(String q, Double gpsLat, Double gpsLong) {
		List<City> result = null;

		Query query;
		if (gpsLat != null && gpsLong != null) {
			query = em.createNamedQuery("City.suggestionsGPS", City.class);
			query.setParameter("gpsLat", gpsLat);
			query.setParameter("gpsLong", gpsLong);
		} else {
			query = em.createNamedQuery("City.suggestions", City.class);
		}
		query.setParameter("q", "%" + q.toLowerCase() + "%");
		result = query.getResultList();
		return result;
	}
}
