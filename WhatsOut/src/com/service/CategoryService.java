package com.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale.Category;

public class CategoryService {
	private List<String> categoryList;

	public CategoryService() {
		this.categoryList = new ArrayList<>();
	}

	public List<String> getCategoryList() {
		categoryList.add("Sports");
		categoryList.add("Festival");
		categoryList.add("Cinema");
		categoryList.add("Music");
		categoryList.add("Photography");
		return categoryList;
	}

}
