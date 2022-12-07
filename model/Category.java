package com.cartana.model;

public class Category {
	private int categoryId;
	private String categoryName;
	//default constructor
	public Category()
	{
		
	}
	//parameterized constructor
	public Category(int id,String name)
	{
		this.categoryId=id;
		this.categoryName=name;
	}
	//getters and setters
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public String getCategoryName() {
		return categoryName;
	}
	
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Category [categoryId=" + categoryId + ", categoryName="
				+ categoryName + "]";
	}
	
	
}
