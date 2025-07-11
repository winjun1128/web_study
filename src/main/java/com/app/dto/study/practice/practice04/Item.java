package com.app.dto.study.practice.practice04;

public class Item {
	String category;
	String product;
	@Override
	public String toString() {
		return "Item [category=" + category + ", product=" + product + "]";
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getProduct() {
		return product;
	}
	public void setProduct(String product) {
		this.product = product;
	}
}
