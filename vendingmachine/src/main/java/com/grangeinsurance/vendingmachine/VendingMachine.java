package com.grangeinsurance.vendingmachine;

import java.util.HashMap;

public class VendingMachine {

	float currentTotal = 0;
	float returnTotal = 0;
	float priceOfItem = 0;
	boolean itemSelected = false;
	String priceFormat = "$%.2f";
	private static HashMap<String, Float> acceptedCoins = new HashMap<>();
	static {
	acceptedCoins.put("Quarter", 0.25f);
	acceptedCoins.put("Dime", 0.10f);
	acceptedCoins.put("Nickel", 0.05f);
	}
	
	
	private static HashMap<String, Float> availableItems = new HashMap<>();
	static {
	availableItems.put("Cola", 1.00f);
	availableItems.put("Chips", 0.50f);
	availableItems.put("Candy", 0.65f);
	}
	public Object machineDisplay() {
		if (currentTotal > 0 && !(itemSelected)) {
			return String.format(priceFormat, currentTotal);
		} else if (priceOfItem > currentTotal && itemSelected) {
			return "PRICE " + String.format(priceFormat, priceOfItem);
		} else if (priceOfItem <= currentTotal && itemSelected) {
			currentTotal -= priceOfItem;
			return "THANK YOU";
		} else {
			return "INSERT COINS";
		}
	}
	
	public Object coinReturn() {
		return String.format(priceFormat, returnTotal);
	}
	
	public void insertCoin (float total) {
		if (acceptedCoins.containsValue(total)) {
			currentTotal += total;
		} else {
			returnTotal += total;
		}
	}

	public void makeSelection(String item) {
		if (availableItems.containsKey(item)) {
			priceOfItem = availableItems.get(item);
			itemSelected = true;
		}
		
	}


}
