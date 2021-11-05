package com.java.jsf;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;



@RequestScoped
@Entity
@ManagedBean(name="menu")
@Table(name="Menu")
public class Menu {

	@Id
	@Column(name="MENU_ID")
	private int menuId;
	@Column(name="MENU_ITEM")
	private String menuItem;
	@Column(name="MENU_PRICE")
	private double menuPrice;
	@Column(name="MENU_CALORIES")
	private double menuCalories;
	@Column(name="MENU_STATUS")
	private String menuStatus;
	@Column(name="MENU_RATING")
	private String menuRating;
	@Column(name="MENU_TYPE")
	private String menuType;
	
	public int getMenuId() {
		return menuId;
	}
	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}
	public String getMenuItem() {
		return menuItem;
	}
	public void setMenuItem(String menuItem) {
		this.menuItem = menuItem;
	}
	public double getMenuPrice() {
		return menuPrice;
	}
	public void setMenuPrice(double menuPrice) {
		this.menuPrice = menuPrice;
	}
	public double getMenuCalories() {
		return menuCalories;
	}
	public void setMenuCalories(double menuCalories) {
		this.menuCalories = menuCalories;
	}
	@Enumerated(EnumType.STRING)
	public String getMenuStatus() {
		return menuStatus;
	}
	public void setMenuStatus(String menuStatus) {
		this.menuStatus = menuStatus;
	}
	
	
	public String getMenuRating() {
		return menuRating;
	}
	public void setMenuRating(String menuRating) {
		this.menuRating = menuRating;
	}
	public String getMenuType() {
		return menuType;
	}
	public void setMenuType(String menuType) {
		this.menuType = menuType;
	}
	
}

