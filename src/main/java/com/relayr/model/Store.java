package com.relayr.model;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Store {
	
	public Store(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public Store() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Store(String name) {
		this.name = name;
	}
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
    private String name;
    
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public int hashCode() {
		return Objects.hash(id, name);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Store other = (Store) obj;
		return Objects.equals(id, other.id) && Objects.equals(name, other.name);
	}

}
