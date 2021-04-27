package com.dev.nicemovie.data.model;

import com.google.gson.annotations.SerializedName;

public class SearchData {

	@SerializedName("Type")
	private String type;

	@SerializedName("Year")
	private String year;

	@SerializedName("imdbID")
	private String imdbID;

	@SerializedName("Poster")
	private String poster;

	@SerializedName("Title")
	private String title;

	public String getType(){
		return type;
	}

	public String getYear(){
		return year;
	}

	public String getImdbID(){
		return imdbID;
	}

	public String getPoster(){
		return poster;
	}

	public String getTitle(){
		return title;
	}

	@Override
 	public String toString(){
		return 
			"SearchItem{" + 
			"type = '" + type + '\'' + 
			",year = '" + year + '\'' + 
			",imdbID = '" + imdbID + '\'' + 
			",poster = '" + poster + '\'' + 
			",title = '" + title + '\'' + 
			"}";
		}
}