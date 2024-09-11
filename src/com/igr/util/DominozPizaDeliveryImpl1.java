package com.igr.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.igr.bean.DishNew;
import com.igr.bean.LocationNew;
import com.igr.bean.OrderNew;

public class DominozPizaDeliveryImpl1 implements DominozPizzaDelivery1 {
//	public void populateData(String dishFile, String locationFile, List<DishNew> dishs, Set<LocationNew> locations) {
//		Scanner scan = null;
//		try {
//			scan = new Scanner(new File(dishFile));
//			while (scan.hasNext()) {
//				String line[] = scan.nextLine().split(",");
//				int dishId = Integer.parseInt(line[0].trim());
//				String dishName = line[1].trim();
//				Double cost = Double.parseDouble(line[2].trim());
//				Double timeToCook = Double.parseDouble(line[3].trim());
////				DishNew dish =new DishNew(dishId,dishName,cost,timeToCook);
////				dishs.add(dish);
//				dishs.add(new DishNew(dishId, dishName, cost, timeToCook));
//			}
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} finally {
//			scan.close();
//		}
//		try {
//			scan = new Scanner(new File(locationFile));
//			while (scan.hasNext()) {
//				String line[] = scan.nextLine().split(",");
//				int locationCode = Integer.parseInt(line[0].trim());
//				int locationDistance = Integer.parseInt(line[1].trim());
//				double locationTime = Double.parseDouble(line[2].trim());
////			LocationNew location = new LocationNew();
////			locations.add(LocationNew(locationId, locationDistance, locationTime));
//				locations.add(new LocationNew(locationCode, locationDistance, locationTime));
//			}
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		} finally {
//			scan.close();
//		}
//
//	}
//
//	@Override
//	public void calculateLocationForDish(List<DishNew> dishs, Set<LocationNew> locations) {
//		for (DishNew d : dishs) {
//			for (LocationNew l : locations) {
//				if (d.getTimeToCook() + l.getLocationTime() <= 30) {
//					if (d.getLocationSetForDish() == null) {
//						d.setLocationSetForDish(new HashSet<LocationNew>());
//						d.getLocationSetForDish().add(l);
//					}
//				}
//
//			}
//		}
//
//	}
//
//	@Override
//	public List<OrderNew> calculateOrder(String orderFile, List<DishNew> dishs, Set<LocationNew> locations) {
////		Scanner scan=null;
////		List<OrderNew> list =new ArrayList<OrderNew>();
////		try {
////			scan=new Scanner(new File(orderFile));
////			while(scan.hasNext()) {
////			String line[]= scan.nextLine().split(",");
////			int dishId=Integer.parseInt(line[0].trim());
////			int locationCode=Integer.parseInt(line[1].trim());
////			for (DishNew d : dishs) {
////				for (LocationNew l : locations) {
////					if(d.getDishId() == dishId && l.getLocationCode() == locationCode) {
////					if(d.getTimeToCook() + l.getLocationCode()) <=30 {
////						double cost = d.getCost() + l.getLocationDistance() * 1;
////					list.add(new OrderNew(dishId, locationCode, cost));
////				}
////
////					}
////					
////				}
////				}
////			}
////			//list.add(new OrderNew(dishId, locationCode, cost));
////			}
////		}catch(Exception e)
////	{
////			// TODO: handle exception
////		}return null;
////}
//
//		Scanner scan = null;
//		List<OrderNew> list = new ArrayList<OrderNew>();
//		try {
//			scan = new Scanner(new File(orderFile));
//			while (scan.hasNext()) {
//				String t[] = scan.nextLine().split(",");
//				int dishId = Integer.parseInt(t[0].trim());
//				int locationCode = Integer.parseInt(t[1].trim());
//				for (DishNew d : dishs) {
//					for (LocationNew l : locations) {
//						if (d.getDishId() == dishId && l.getLocationCode() == locationCode) {
//							if (d.getTimeToCook() + l.getLocationTime() <= 30) {
//								double cost = d.getCost() + l.getLocationDistance() * 1;
//								list.add(new OrderNew(dishId, locationCode, cost));
//							}
//						}
//					}
//				}
//			}
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} finally {
//			scan.close();
//		}
//		return list;
//	}
//
//	@Override
//	public void freeDelivery(List<OrderNew> orders, List<DishNew> dishs, Set<LocationNew> locations) {
//		for (OrderNew o : orders) {
//			for (DishNew d : dishs) {
//				for (LocationNew l : locations) {
//					if (o.getDishId() == d.getDishId() && o.getLocationCode() == l.getLocationCode()) {
//						if (d.getCost() > 200 && l.getLocationDistance() <= 10) {
//							o.setCost(d.getCost());
//							System.out.println(o);
//						}
//					}
//				}
//			}
//		}
//	}
//
	@Override
	public void populateData(List<DishNew> dishes, Set<LocationNew> locations) {
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dishdb", "root", "Root");
			Statement statment;
			statment = con.createStatement();
			ResultSet resultSet;
			resultSet = statment.executeQuery("select * from dish1");
			int dishId;
			String dishName;
			double cost;
			double timeToCook;
			while (resultSet.next()) {
				dishId = resultSet.getInt("dishId");
				dishName = resultSet.getString("dishName");
				cost = resultSet.getDouble("cost");
				timeToCook = resultSet.getDouble("timeToCook");
				dishes.add(new DishNew(dishId, dishName, cost, timeToCook));
			}
			resultSet.close();
			statment.close();
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dishdb", "root", "Root");
			Statement statement;
			statement = con.createStatement();
			ResultSet resultSet;
			resultSet = statement.executeQuery("select * from location1");

			int locationCode;
			int locationDistance;
			double locationTime;
			while (resultSet.next()) {
				locationCode = resultSet.getInt("locationCode");
				locationDistance = resultSet.getInt("locationDistance");
				locationTime = resultSet.getDouble("locationTime");
				locations.add(new LocationNew(locationCode, locationDistance, locationTime));
			}
			resultSet.close();
			statement.close();
			con.close();

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	public void calculateLocationForDish(List<DishNew> dishes, Set<LocationNew> locations) {
		Connection con = null;
		try {
			for (DishNew d : dishes) {
				for (LocationNew l : locations) {
					if (d.getTimeToCook() + l.getLocationTime() <= 30) {
						if (d.getLocationSetForDish() == null) {
							d.setLocationSetForDish(new HashSet<LocationNew>());
							d.getLocationSetForDish().add(l);

						}
					}
				}
			}
		}

		catch (Exception e) {
			e.printStackTrace();

		}

	}

	@Override
	public List<OrderNew> calculateOrder(List<DishNew> dishes, Set<LocationNew> locations) {
		Connection con = null;
		List<OrderNew> list = new ArrayList<OrderNew>();
		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dishdb", "root", "Root");
			Statement statement;
			statement = con.createStatement();
			ResultSet rs;
			rs = statement.executeQuery("select * from order1");

			int dishId;
			int locationCode;
			while (rs.next()) {
				dishId = rs.getInt("dishId");
				locationCode = rs.getInt("locationCode");
				for (DishNew d : dishes) {
					for (LocationNew l : locations) {
						if (d.getDishId() == dishId && l.getLocationCode() == locationCode)
							if (d.getTimeToCook() + l.getLocationTime() < 30) {
								double cost = (d.getCost() + l.getLocationDistance()) * 1;
								list.add(new OrderNew(dishId, locationCode, cost));

							}
					}

				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public void freeDelivery(List<OrderNew> orders, List<DishNew> dishes, Set<LocationNew> locations) {
		for (DishNew d : dishes) {
			for (LocationNew l : locations) {
				for (OrderNew o : orders) {
					if (d.getDishId() == o.getDishId() && l.getLocationCode() == o.getLocationCode()) {
						if (d.getCost() > 200 && l.getLocationDistance() < 10) {
							o.setCost(d.getCost());
							System.out.println(o);
						}
					}

				}

			}

		}

	}
}
