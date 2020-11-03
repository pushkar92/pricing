package com.relayr.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Product_Store_Details {


	public Product_Store_Details(Long id, String link, Long storeId, Long productId, double mrp, double sp,
			double discount, int rating) {
		super();
		this.id = id;
		this.link = link;
		this.storeId = storeId;
		this.productId = productId;
		this.mrp = mrp;
		this.sp = sp;
		this.discount = discount;
		this.rating = rating;
	}
	public Product_Store_Details() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Product_Store_Details(String link, Long storeId, Long productId, double mrp, double sp,
			double discount,int rating) {
		this.link = link;
		this.storeId = storeId;
		this.productId = productId;
		this.mrp = mrp;
		this.sp = sp;
		this.discount = discount;
		this.rating=rating;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String link;
	private Long storeId;
	private Long productId;
	private double mrp;
	private double sp;
	private double discount;
	private int rating;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public Long getStoreId() {
		return storeId;
	}
	public void setStoreId(Long storeId) {
		this.storeId = storeId;
	}
	public Long getProductId() {
		return productId;
	}
	public void setProductId(Long productId) {
		this.productId = productId;
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
		long temp;
		temp = Double.doubleToLongBits(discount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((link == null) ? 0 : link.hashCode());
		temp = Double.doubleToLongBits(mrp);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((productId == null) ? 0 : productId.hashCode());
		result = prime * result + rating;
		temp = Double.doubleToLongBits(sp);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((storeId == null) ? 0 : storeId.hashCode());
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
		Product_Store_Details other = (Product_Store_Details) obj;
		if (Double.doubleToLongBits(discount) != Double.doubleToLongBits(other.discount))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (link == null) {
			if (other.link != null)
				return false;
		} else if (!link.equals(other.link))
			return false;
		if (Double.doubleToLongBits(mrp) != Double.doubleToLongBits(other.mrp))
			return false;
		if (productId == null) {
			if (other.productId != null)
				return false;
		} else if (!productId.equals(other.productId))
			return false;
		if (rating != other.rating)
			return false;
		if (Double.doubleToLongBits(sp) != Double.doubleToLongBits(other.sp))
			return false;
		if (storeId == null) {
			if (other.storeId != null)
				return false;
		} else if (!storeId.equals(other.storeId))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Product_Store_Details [id=" + id + ", link=" + link + ", storeId=" + storeId + ", productId="
				+ productId + ", mrp=" + mrp + ", sp=" + sp + ", discount=" + discount + ", rating=" + rating + "]";
	}

}
