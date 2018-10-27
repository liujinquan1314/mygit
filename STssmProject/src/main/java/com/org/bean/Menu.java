package com.org.bean;

public class Menu {
	
	private Integer menuId;
	
	private Integer parentMenuId;  
	
	private String prentName;
	
	private String menuName;
	
	private String menuUrl;

	public Integer getMenuId() {
		return menuId;
	}

	public void setMenuId(Integer menuId) {
		this.menuId = menuId;
	}

	public Integer getParentMenuId() {
		return parentMenuId;
	}

	public void setParentMenuId(Integer parentMenuId) {
		this.parentMenuId = parentMenuId;
	}

	public String getPrentName() {
		return prentName;
	}

	public void setPrentName(String prentName) {
		this.prentName = prentName;
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public String getMenuUrl() {
		return menuUrl;
	}

	public void setMenuUrl(String menuUrl) {
		this.menuUrl = menuUrl;
	}

}
