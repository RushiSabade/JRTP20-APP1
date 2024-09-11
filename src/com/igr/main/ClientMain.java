package com.igr.main;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.igr.bean.DishNew;
import com.igr.bean.LocationNew;
import com.igr.bean.OrderNew;
import com.igr.util.DominozPizaDeliveryImpl1;
import com.igr.util.DominozPizzaDelivery1;

public class ClientMain {
	public static void main(String[] args) {

		List<DishNew> list = new ArrayList<DishNew>();
		Set<LocationNew> set = new HashSet<LocationNew>();
		DominozPizzaDelivery1 dm1 = new DominozPizaDeliveryImpl1();
		// dm1.populateData("dish.txt", "location.txt", list, set);
		dm1.populateData(list, set);

		System.out.println("---Dishesh---");
		System.out.println(dm1);
		for (DishNew d : list) {
			System.out.println(d);
		}
		System.out.println(list.size());
		System.out.println("\n");
		System.out.println("---Locations---");
		System.out.println(dm1);
		for (LocationNew l : set) {
			System.out.println(l);
		}

		System.out.println(set.size());
		System.out.println("\n");
		dm1.calculateLocationForDish(list, set);
		System.out.println("----------dishs-----------");
		for (DishNew d : list) {
			System.out.println(d);
			System.out.println(d.getLocationSetForDish().size());
		}
//		
		System.out.println(list.size());
		System.out.println("\n");
		List<OrderNew> order = dm1.calculateOrder(list, set);

		for (OrderNew o : order) {
			System.out.println(o);
		}
		System.out.println(order.size());
		System.out.println("\n");
		dm1.freeDelivery(order, list, set);

	}
}