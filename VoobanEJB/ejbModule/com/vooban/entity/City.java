package com.vooban.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * Représentation de l'entité Ville.
 * 
 * @author Guillaume Jobin
 */
@Entity
@Table(name = "CITIES")
@NamedQueries({ @NamedQuery(name = "City.suggestions", query = "select c from City c where lower(c.name) like :q"),
		@NamedQuery(name = "City.suggestionsGPS", query = "select c from City c where lower(c.name) like :q and c.gpsLat = :gpsLat and c.gpsLong = :gpsLong") })
public class City {

	private Integer id;
	private String name;
	private Double gpsLat;
	private Double gpsLong;
	private String country;
	private String stateProv;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "GPS_LAT")
	public Double getGpsLat() {
		return gpsLat;
	}

	public void setGpsLat(Double gpsLat) {
		this.gpsLat = gpsLat;
	}

	@Column(name = "GPS_LONG")
	public Double getGpsLong() {
		return gpsLong;
	}

	public void setGpsLong(Double gpsLong) {
		this.gpsLong = gpsLong;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getStateProv() {
		return stateProv;
	}

	public void setStateProv(String stateProv) {
		this.stateProv = stateProv;
	}

}
