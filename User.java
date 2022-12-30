package com.training.web.model;

public class User {
	private String prodName;
	private String proddesc;
	public User(String prodName, String proddesc) {
		super();
		this.prodName = prodName;
		this.proddesc = proddesc;
	}
	public User()
	{
		
	}
	public String getProdName() {
		return prodName;
	}
	public void setProdName(String prodName) {
		this.prodName = prodName;
	}
	public String getProddesc() {
		return proddesc;
	}
	public void setProddesc(String proddesc) {
		this.proddesc = proddesc;
	}
	
	
}
