package com.dev.nicemovie.data.model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class SearchResponse{

	@SerializedName("Response")
	private String response;

	@SerializedName("totalResults")
	private String totalResults;

	@SerializedName("Search")
	private List<SearchData> searchData;

	public String getResponse(){
		return response;
	}

	public String getTotalResults(){
		return totalResults;
	}

	public List<SearchData> getSearchData(){
		return searchData;
	}

	@Override
 	public String toString(){
		return 
			"SearchResponse{" + 
			"response = '" + response + '\'' + 
			",totalResults = '" + totalResults + '\'' + 
			",searchData = '" + searchData + '\'' +
			"}";
		}
}