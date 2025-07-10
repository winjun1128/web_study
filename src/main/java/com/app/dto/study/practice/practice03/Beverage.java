package com.app.dto.study.practice.practice03;

public class Beverage {
	String item;
	String type;
	@Override
	public String toString() {
		return "Beverage [item=" + item + ", type=" + type + "]";
	}
	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
}
