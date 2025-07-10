package com.app.controller.study.practice.practice03.DTO;

public class Drink {
	String item;
	String type;
	@Override
	public String toString() {
		return "Drink [item=" + item + ", type=" + type + "]";
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
