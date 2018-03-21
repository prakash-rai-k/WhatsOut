package com.model;

public class Rating {
	private int id;
	private int value;

	public Rating() {

	}

	public Rating(int id, int value) {
		super();
		this.id = id;
		this.value = value;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "Rating [id=" + id + ", value=" + value + "]";
	}
	
}
