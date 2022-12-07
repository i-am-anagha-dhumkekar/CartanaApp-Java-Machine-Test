package com.cartana.app;

import java.util.ArrayList;
import java.util.Scanner;

import com.cartana.model.Items;
import com.cartana.model.Category;

public class CartanaStore {
	private static int adminPin=1998;
	private static int startItemId=999;
	private static Scanner input=new Scanner(System.in);
	private static Items obj=new Items();
	private static int categoryId=0;
	private static ArrayList<Category> categories = new ArrayList<Category>();
	public static void main(String[] args)
	{
		char choice='n';
		addedCategories();
		do
		{
			try
			{	//Choose user type
				System.out.println("Please select type of user: ");
				System.out.println("1.Admin \n2.Guest");
				int user=input.nextInt();
				switch (user)
				{
					case 1:
						System.out.println("Please enter pin for admin privilages: ");
						int pin=input.nextInt();
						if(pin==adminPin)
						{
							adminUser();
						}
						else
						{
							System.out.println("Incorrect pin!!!");
						}
						break;
					case 2:
						guestUser();
						break;
					default:
						System.out.println("Please select proper option...");
				}
				
			}
			catch(Exception e)
			{
				System.out.println("Invaild Input...");
			}
			System.out.println("Do you want to enter more? (y/n)");
			choice=input.next().charAt(0);
		}
		while(choice=='y'||choice=='Y');
		
	}
	//Guest user logic
	private static void guestUser()
	{
		char choose='n';
		do
		{
			System.out.println("Choose appropriate option from below: ");
			System.out.println("1.Add a new product to list \n 2.Display list of products \n 3.Search product \n Search By Category");
			int option=input.nextInt();
			if(option==1)
			{
				System.out.println("You do not have permission to access this field.");
			}
			else if(option==2)
			{
				obj.displayList();
			}
			else if(option==3)
			{
				searchItem();
			}
			else if(option==4)
			{
				obj.serachByCategory();
			}
			else
			{
				System.out.println("Invalid option...");
			}
			System.out.println("Do you want to enter more?(y/n): ");
			choose=input.next().charAt(0);
		}
		while(choose=='y'|| choose=='Y');
		
	}
	//Admin user logic
	private static void adminUser() {
		char choose='n';
		do{
			try
			{
				System.out.println("Choose appropriate option from below: ");
				System.out.println("1.Add a new product to list \n 2.Display list of products \n 3.Search product \n 4.Search products by Category");
				int option=input.nextInt();
				switch(option)
				{
					case 1:
						getInputForAddingUser();
						break;
					case 2:
						obj.displayList();
						break;
					case 3:
						searchItem();
						break;
					case 4:
						obj.serachByCategory();
						break;
					default:
						System.out.println("Please enter appropriate option..");
				}
				System.out.println("Do you want to enter more?(y/n): ");
				choose=input.next().charAt(0);
			}
			catch(Exception e)
			{
				System.out.println("Invalid Input....");
			}
		}
		while(choose=='y'|| choose=='Y');
	}
	
	//Search item calling from Items class
	private static void searchItem() {
		try
		{
			System.out.println("Enter item id and item name to search:");
			int id=input.nextInt();
			String name=input.next();
			obj.searchItem(id, name);
		}
		catch(Exception e)
		{
			System.out.println("Invalid input...");
		}
		
	}
	//Getting input to add Item
	private static void getInputForAddingItem() {
		try
		{
			//System.out.println("Enter item id: ");
			//int itemId=input.nextInt();
			Scanner scanner=new Scanner(System.in);
			System.out.println("Enter item Name: ");
			String itemName=scanner.next();
			System.out.println("Enter buying price: ");
			String buyingPrice=scanner.next();
			System.out.println("Enter selling Price: ");
			String sellingPrice=scanner.next();
			displayCategories();
			System.out.println("Enter category id from above table: ");
			String categoryId=scanner.next();
			if(checkCategoriesisAvailable(categoryId))
			{
				System.out.println("Enter tax in percentage (eg.15% then enter 15): ");
				String taxInPercent=scanner.next();
				System.out.println("Enter quantity of item: ");
				String quantity=scanner.next();
				startItemId=startItemId+1;
				Items.addNewProduct(startItemId, itemName, buyingPrice, sellingPrice,categoryId, taxInPercent, quantity);
			}
			else
			{
				System.exit(0);
			}			
		}
		catch(Exception e)
		{
			System.out.println("Invaild Input....");
		}
		
	}
	//Checking category entered is available or not
	private static boolean checkCategoriesisAvailable(String categoryId2) {
		for(Category category:categories)
		{
			if(category.getCategoryId()==Integer.parseInt(categoryId2))
			{
				return true;
			}
		}
		return false;
	}
	//Added categories
	private static void addedCategories()
	{
		categoryId=categoryId+1;
		categories.add(new Category(categoryId,"Laptops"));
		categoryId=categoryId+1;
		categories.add(new Category(categoryId,"Mobiles"));
		categoryId=categoryId+1;
		categories.add(new Category(categoryId,"Watches"));
	}
	//display available categories
	public static void displayCategories()
	{

		System.out.format("%15s%20s%n","CategoryId","Category Name");
		System.out.println("-------------------------------------------------------");
		for(Category object:categories)
		{
			
			System.out.format("%10d%20s%n",object.getCategoryId(),object.getCategoryName());
		}
	}
}
