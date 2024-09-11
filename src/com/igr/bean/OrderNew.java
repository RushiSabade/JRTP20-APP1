package com.igr.bean;

import java.util.Objects;

public class OrderNew {
	
	private int dishId;
	private int locationCode;
	private double Cost;
	public OrderNew(int dishId, int locationCode, double cost) {
		super();
		this.dishId = dishId;
		this.locationCode = locationCode;
		Cost = cost;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(dishId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderNew other = (OrderNew) obj;
		return dishId == other.dishId;
	}

	@Override
	public String toString() {
		return "OrderNew [dishId=" + dishId + ", locationCode=" + locationCode + ", Cost=" + Cost + "]";
	}
	public int getDishId() {
		return dishId;
	}
	public void setDishId(int dishId) {
		this.dishId = dishId;
	}

	public int getLocationCode() {
		return locationCode;
	}
	public void setLocationCode(int locationCode) {
		this.locationCode = locationCode;
	}
	public double getCost() {
		return Cost;
	}
	public void setCost(double cost) {
		Cost = cost;
	}
	
	
	
}