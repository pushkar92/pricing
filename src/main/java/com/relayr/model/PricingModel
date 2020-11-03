package com.relayr.model;

import com.opencsv.bean.CsvBindByName;

public class PricingModel {

	public PricingModel(String productName, String storeName, String link, double mrp, double sp, double discount,
			String category,int rating) {
		super();
		this.productName = productName;
		this.storeName = storeName;
		this.link = link;
		this.mrp = mrp;
		this.sp = sp;
		this.discount = discount;
		this.category = category;
		this.rating=rating;
	}

	public PricingModel() {
		super();
	}

	@CsvBindByName
	private String productName;

	@CsvBindByName
	private String storeName;

	@CsvBindByName
	private String link;

	@CsvBindByName
	private double mrp;

	@CsvBindByName
	private double sp;

	@CsvBindByName
	private double discount;

	@CsvBindByName
	private String category;
	
	@CsvBindByName
	private int rating;

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public double getMrp() {
		return mrp;
	}

	public void setMrp(double mrp) {
		this.mrp = mrp;
	}

	public double getSp() {
		return sp;
	}

	public void setSp(double sp) {
		this.sp = sp;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((category == null) ? 0 : category.hashCode());
		long temp;
		temp = Double.doubleToLongBits(discount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((link == null) ? 0 : link.hashCode());
		temp = Double.doubleToLongBits(mrp);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((productName == null) ? 0 : productName.hashCode());
		result = prime * result + rating;
		temp = Double.doubleToLongBits(sp);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((storeName == null) ? 0 : storeName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PricingModel other = (PricingModel) obj;
		if (category == null) {
			if (other.category != null)
				return false;
		} else if (!category.equals(other.category))
			return false;
		if (Double.doubleToLongBits(discount) != Double.doubleToLongBits(other.discount))
			return false;
		if (link == null) {
			if (other.link != null)
				return false;
		} else if (!link.equals(other.link))
			return false;
		if (Double.doubleToLongBits(mrp) != Double.doubleToLongBits(other.mrp))
			return false;
		if (productName == null) {
			if (other.productName != null)
				return false;
		} else if (!productName.equals(other.productName))
			return false;
		if (rating != other.rating)
			return false;
		if (Double.doubleToLongBits(sp) != Double.doubleToLongBits(other.sp))
			return false;
		if (storeName == null) {
			if (other.storeName != null)
				return false;
		} else if (!storeName.equals(other.storeName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "PricingModel [productName=" + productName + ", storeName=" + storeName + ", link=" + link + ", mrp="
				+ mrp + ", sp=" + sp + ", discount=" + discount + ", category=" + category + ", rating=" + rating + "]";
	}

}
