package com.dev.nicemovie.data.model;

import com.google.gson.annotations.SerializedName;

public class Rating {

	@SerializedName("Value")
	private String value;

	@SerializedName("Source")
	private String source;

	public String getValue(){
		return value;
	}

	public String getSource(){
		return source;
	}

	@Override
 	public String toString(){
		return 
			"RatingsItem{" + 
			"value = '" + value + '\'' + 
			",source = '" + source + '\'' + 
			"}";
		}
}