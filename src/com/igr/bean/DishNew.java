package com.igr.bean;

import java.util.Objects;
import java.util.Set;

public class DishNew {
	private int dishId;
	private String dishName;
	private double cost;
	private double timeToCook;
	private Set<LocationNew> locationSetForDish;

	@Override
	public String toString() {
		return "DishNew [dishId=" + dishId + ", dishName=" + dishName + ", cost=" + cost + ", timeToCook=" + timeToCook
				+ ", locationSetForDish=" + locationSetForDish + "]";
	}

	public DishNew(int dishId, String dishName, double cost, double timeToCook) {
		super();
		this.dishId = dishId;
		this.dishName = dishName;
		this.cost = cost;
		this.timeToCook = timeToCook;
		this.locationSetForDish = locationSetForDish;
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
		DishNew other = (DishNew) obj;
		return dishId == other.dishId;
	}

	public DishNew(int dishId) {
		super();
		this.dishId = dishId;
	}

	public int getDishId() {
		return dishId;
	}

	public void setDishId(int dishId) {
		this.dishId = dishId;
	}

	public String getDishName() {
		return dishName;
	}

	public void setDishName(String dishName) {
		this.dishName = dishName;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public double getTimeToCook() {
		return timeToCook;
	}

	public void setTimeToCook(double timeToCook) {
		this.timeToCook = timeToCook;
	}

	public Set<LocationNew> getLocationSetForDish() {
		return locationSetForDish;
	}

	public void setLocationSetForDish(Set<LocationNew> locationSetForDish) {
		this.locationSetForDish = locationSetForDish;
	}
}
