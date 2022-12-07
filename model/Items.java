package com.cartana.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Items {
	//Hashmap to store list
	private static HashMap<Integer,ArrayList<String>> map=new HashMap<Integer,ArrayList<String>>();
	private static Scanner input=new Scanner(System.in);
	
	public static void main(String[] args)
	{
	}
	//Adding new product logic
	public static void addNewProduct(int itemId,String itemName,String buyingPrice,String sellingPrice,String categoryId,String taxInPercent,String quantity)
	{
		if(!map.containsKey(itemId))
		{
			ArrayList<String> list=new ArrayList<String>();
			list.add(itemName);
			list.add(buyingPrice);
			list.add(sellingPrice);
			list.add(categoryId);
			list.add(taxInPercent);
			list.add(quantity);
			map.put(itemId,list);
		}
		else
		{
			System.out.println("Item already available");
		}
		
	}
	//Seraching item by id and name logic
	public static void searchItem(int itemId,String itemName)
	{
		if(map.containsKey(itemId))
		{
			if(map.get(itemId).get(0).equals(itemName))
			{
				System.out.println("-----------------Item Found!!!-------------------");
				System.out.println("--------------------------------------------------");
				System.out.format("%10s%15s%20s%20s%20s%20s%20s%n","Item id","Item Name","Buying Price","Selling Price","Category id","Tax(in percent)","Quantity");
				System.out.println("-------------------------------------------------------------------------------------------------------------------------------------");
				System.out.format("%10d%15s%20s%20s%20s%20s%20s%n",itemId,itemName,map.get(itemId).get(1),map.get(itemId).get(2),map.get(itemId).get(3),map.get(itemId).get(4),map.get(itemId).get(5));
			}
		}
		else
		{
			System.out.println("Item not found...");
		}
	}
	//display whole list
	public static void displayList() {
		System.out.format("%10s%15s%20s%20s%20s%20s%20s%n","Item id","Item Name","Buying Price","Selling Price","Category id","Tax(in percent)","Quantity");
		System.out.println("--------------------------------------------------------------------------------------------------------------");
		for (Integer itemId : map.keySet())
		{
			System.out.format("%10d%15s%20s%20s%20s%20s%20s%n",itemId,map.get(itemId).get(0),map.get(itemId).get(1),map.get(itemId).get(2),map.get(itemId).get(3),map.get(itemId).get(4),map.get(itemId).get(5));
		}
	}
	//Searching by category id
	public static void serachByCategory() {
		try{
			System.out.println("Enter category id to search: ");
			int categoryid=input.nextInt();
			System.out.format("%10s%15s%20s%20s%20s%20s%20s%n","Item id","Item Name","Buying Price","Selling Price","Category id","Tax(in percent)","Quantity");
			System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------");
			boolean check=false;
			for(Integer itemId : map.keySet())
			{
				if(categoryid==Integer.parseInt(map.get(itemId).get(3)))
				{
					System.out.format("%10d%15s%20s%20s%20s%20s%20s%n",itemId,map.get(itemId).get(0),map.get(itemId).get(1),map.get(itemId).get(2),map.get(itemId).get(3),map.get(itemId).get(4),map.get(itemId).get(5));
					check=true;
				}
			}
			if(!check)
			{
				System.out.println("No items With this category id");
			}
		}
		catch(Exception e)
		{
			System.out.println("Invalid Input...");
		}
		
	}
}
