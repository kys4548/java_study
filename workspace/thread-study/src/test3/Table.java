package test3;

import java.util.ArrayList;
import java.util.List;

public class Table {
	private String[] dishNames = {"donut", "donut", "burger"};
	final int MAX_FOOD = 6;
	private List<String> dishes = new ArrayList<String>();
	
	public String[] getDishNames() {
		return dishNames;
	}
	
	public synchronized void add(String dish) {
		while(dishes.size() >= MAX_FOOD) {
			String name = Thread.currentThread().getName();
			System.out.println(name+ " is waiting.");
			try {
				wait();
			} catch(Exception e) {}
		}
		dishes.add(dish);
		notify();
		System.out.println("Dished: " + dishes.toString());
	}
	
	public synchronized boolean remove(String dishName) {
			while(dishes.size() ==0) {
				String name = Thread.currentThread().getName();
				System.out.println(name+" is waiting.");
				try {
					Thread.sleep(500);
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
			
			for(int i=0; i<dishes.size(); i++) {
				if(dishName.equals(dishes.get(i))) {
					dishes.remove(i);
					return true;
				}
			}
		
		return false;
	}
	
	public int dishNum() {
		return dishNames.length;
	}
}
