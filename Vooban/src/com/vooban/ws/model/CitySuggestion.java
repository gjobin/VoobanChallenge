package com.vooban.ws.model;

/**
 * Entité définissant une ville dans le résultat des suggestions.
 * 
 * @author Guillaume Jobin
 *
 */
public class CitySuggestion {

	private String id;
	private String name;
	private Double latitude;
	private Double longitude;
	private Float score;
	
	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public Float getScore() {
		return score;
	}

	public void setScore(Float score) {
		this.score = score;
	}

}