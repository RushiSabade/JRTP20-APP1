package com.igr.util;

import java.util.List;
import java.util.Set;

import com.igr.bean.DishNew;
import com.igr.bean.LocationNew;
import com.igr.bean.OrderNew;

public interface DominozPizzaDelivery1 {
	void populateData(List<DishNew> dishes, Set<LocationNew> Locations);

	void calculateLocationForDish(List<DishNew> dishes, Set<LocationNew> locations);

	List<OrderNew> calculateOrder(List<DishNew> dishes, Set<LocationNew> locations);

	void freeDelivery(List<OrderNew> orders, List<DishNew> dishes, Set<LocationNew> locations);

}
