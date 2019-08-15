package com.gojek.parkinglot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

import com.gojek.parkinglot.entities.Car;

public class ParkingLotImpl {

	private static volatile ParkingLotImpl parkingLotinstance; 
	private int totalNoOfSlots;
	private Map<Integer,Car> slotCarMap;
	private TreeSet<Integer> freeSlots;

	//Private constructor initialization
	private ParkingLotImpl(int noOfSlots) {
		this.totalNoOfSlots=noOfSlots;
		slotCarMap = new HashMap<>();
		freeSlots=new TreeSet<>();
		for(int i=0;i<totalNoOfSlots;i++){
			slotCarMap.put(i, null);
			freeSlots.add(i);
		}
	}

	//Restrict creation of Parking Lot only once using Singleton Pattern
	public static ParkingLotImpl createParkingLot(int noOfSlots) {
		if(parkingLotinstance==null) {
			synchronized (ParkingLotImpl.class) {
				if(parkingLotinstance==null) {
					parkingLotinstance=new ParkingLotImpl(noOfSlots);
				}
			}
		}
		return parkingLotinstance;
	}

	public void parkCar(Car car) {
		if(totalNoOfSlots==0) {
			System.out.println("Sorry, you don't have any parking lot created");
			return;
		}
		if(freeSlots.size()==0) {
			System.out.println("Sorry, parking lot is full");
			return;
		}
		else {
			//Get the next free available slot from map and put the car there and Print slot+1 as index starts from 0
			int nextAvailableSlot=freeSlots.first();
			slotCarMap.put(nextAvailableSlot, car);
			freeSlots.remove(nextAvailableSlot);
			System.out.println("Allocated slot Number: "+(nextAvailableSlot+1));
		}
	}

	public void leaveCar(Integer slotNo) {
		if(slotNo<1 || slotCarMap.get(slotNo-1)==null) {
			System.out.println("There is no car at "+slotNo+".It is already free");
			return;
		}
		freeSlots.add(slotNo-1);
		slotCarMap.put(slotNo-1, null);
		System.out.println("Slot number "+slotNo+" is free");
	}

	public void getStatus(){
		System.out.print("Slot No.    Registration No    Colour\n");
		for(int i=0;i<totalNoOfSlots;i++){
			Car c = slotCarMap.get(i);
			if(c != null){
				System.out.print(i+1 +"\t    "+c.getRegistrationNo()+"      "+c.getColor()+"\n");
			}
		}
	}

	public void getRegistrationNumbers(String color){
		if(totalNoOfSlots==0) {
			System.out.println("Sorry, you don't have any parking lot created");
			return;
		}
		else {
			List<Object> result = new ArrayList<>();
			for(int i=0;i<totalNoOfSlots;i++){
				Car c = slotCarMap.get(i);
				if(c != null && color.equals(c.getColor())){
					result.add(c.getRegistrationNo());
				}
			}
			if(result.size()!=0) {
				printResultList(result);
			}
			else {
				System.out.println("Not found");
			}
		}
	}

	public void getSlotNumbersFromColor(String color){
		if(totalNoOfSlots==0) {
			System.out.println("Sorry, you don't have any parking lot created");
			return;
		}
		else {
			List<Object> result = new ArrayList<>();
			for(int i=0;i<totalNoOfSlots;i++){
				Car c = slotCarMap.get(i);
				if(c != null && color.equals(c.getColor())){
					result.add(i+1);
				}
			}
			if(result.size()!=0) {
				printResultList(result);
			}
			else {
				System.out.println("Not found");
			}
		}
	}

	public void getSlotNumberFromRegNo(String regNo){
		if(totalNoOfSlots==0) {
			System.out.println("Sorry, you don't have any parking lot created");
			return;
		}
		else {
			int res=-1;
			for(int i=0;i<totalNoOfSlots;i++){
				Car c = slotCarMap.get(i);
				if(c != null && regNo.equals(c.getRegistrationNo())){
					res = i+1;
					break;
				}
			}
			if(res==-1) {
				System.out.println("Not found");
			}
			else {
				System.out.println(res);
			}
		}
	}

	private void printResultList(List<Object> result) {
		for (int i = 0; i < result.size(); i++) {
			if (!(i == result.size() - 1)) {
				System.out.print(result.get(i) + ", ");
			} else {
				System.out.print(result.get(i));
			}
		}
		System.out.println();
	}

	public void destroy() {
		parkingLotinstance=null;
	}
}
