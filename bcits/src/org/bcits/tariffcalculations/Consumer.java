package org.bcits.tariffcalculations;

public class Consumer {
	private String name;
	private int id;
	private String typeOfUser;
	private double bill;
	public Consumer(String name, int id, String typeOfUser, double bill) {
		super();
		this.name = name;
		this.id = id;
		this.typeOfUser = typeOfUser;
		this.bill = bill;
	}
	@Override
	public String toString() {
		return "User [name=" + name + ", id=" + id + ", typeOfUser=" + typeOfUser + ", bill=" + bill + "]";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTypeOfUser() {
		return typeOfUser;
	}
	public void setTypeOfUser(String typeOfUser) {
		this.typeOfUser = typeOfUser;
	}
	public double getBill() {
		return bill;
	}
	public void setBill(double bill) {
		this.bill = bill;
	}
	
	
	
	
}
