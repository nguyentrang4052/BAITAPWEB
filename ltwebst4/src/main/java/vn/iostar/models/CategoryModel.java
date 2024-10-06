package vn.iostar.models;

import java.io.Serializable;

public class CategoryModel implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5922474969648010292L;
	private int categoryid;
	private String categoryname;
	private String images;
	private boolean active;

	public CategoryModel() {
		super();
	}
	
	public int getCategoryid() {
		return categoryid;
	}
	
	public void setCategoryid(int categoryid) {
		this.categoryid = categoryid;
	}
	
	public String getCategoryname() {
		return categoryname;
	}
	
	public void setCategoryname(String categoryname) {
		this.categoryname = categoryname;
	}
	
	public String getImages() {
		return images;
	}
	
	public void setImages(String images) {
		this.images = images;
	}
	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
	
	@Override
	public String toString() {
		return "CategoryModel [categoryid=" + categoryid + ", categoryname=" + categoryname + ", images=" + images
				+ "]";
	}
	public void setStatus(int status) {
		// TODO Auto-generated method stub
		
	}
}
