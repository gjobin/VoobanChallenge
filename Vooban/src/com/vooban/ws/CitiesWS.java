package com.vooban.ws;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.vooban.ejb.CitiesBean;
import com.vooban.entity.City;
import com.vooban.ws.model.CitySuggestions;

/**
 * Définition du WS pour les villes.
 * 
 * @author Guillaume Jobin
 */
@Stateless
@Path("/cities")
public class CitiesWS {

	@EJB
	private CitiesBean bean;

	/**
	 * Web service pour la proposition de villes selon critères de recherche.
	 * 
	 * @param q
	 *            Critère sur le nom.
	 * @param gpsLat
	 *            Lattitude
	 * @param gpsLong
	 *            Longitude
	 * @return Réponse web au format JSON.
	 */
	@GET
	@Path("suggestions")
	@Produces(MediaType.APPLICATION_JSON)
	public Response suggestions(@QueryParam("q") String q, @QueryParam("lat") Double gpsLat,
			@QueryParam("long") Double gpsLong) {

		Response response = null;

		if (q == null || q.equals("")) {
			response = Response.status(Status.BAD_REQUEST).build();
		} else {

			List<City> cities = bean.suggestions(q, gpsLat, gpsLong);

			if (!cities.isEmpty()) {
				CitySuggestions suggestions = new CitySuggestions(cities, q, gpsLat, gpsLong);
				response = Response.ok(suggestions).build();

			} else {
				response = Response.status(Status.NOT_FOUND).build();
			}
		}

		return response;
	}
}
