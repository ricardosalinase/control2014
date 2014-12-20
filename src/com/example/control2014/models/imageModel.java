package com.example.control2014.models;

public class imageModel {

	public String title;
	public String imageUrl;
	public String points;
	public String link;


	public imageModel() {
	}

	public imageModel(String title, String imageUrl, String points, String link,
			String genre) {
		this.title = title;
		this.imageUrl = imageUrl;
		this.points = points;
		this.link = link;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	
	public String getImageUrl() {
		return imageUrl;
	}

	public void setImage(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	
	
	public String getPoints() {
		return points;
	}

	public void setPoints(String points) {
		this.points = points;
	}
	
	
	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public static Object get(int location) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
