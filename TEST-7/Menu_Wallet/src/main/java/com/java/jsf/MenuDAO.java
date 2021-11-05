package com.java.jsf;

import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;





@ManagedBean(name="menuDao")
public class MenuDAO {
	private Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
	SessionFactory sf;
	
	public Menu[] showMenu() {
		sf=SessionHelper.getConnection();
		Session s=sf.openSession();
		Query q = s.createQuery("from Menu");
		List<Menu>menuList=q.list();
		return menuList.toArray(new Menu[menuList.size()]);
	}
	
	public String addMenu(Menu menu) {
		sf=SessionHelper.getConnection();
		Session s=sf.openSession();
		Transaction t=s.beginTransaction();
		s.save(menu);
		t.commit();
		return "Tab.xhtml?faces-redirect=true";
	}
	
public String searchMenu(Menu menu) {
		
		sessionMap.put("e1", menu);  
		return "updatemenu.xhtml";
		
	}
	
	public String updateMenu(Menu menu) {
		 sf =SessionHelper.getConnection();
			Session s = sf.openSession();
			Transaction t=s.beginTransaction();
			s.update(menu);
			t.commit();
			return "Tab.xhtml";
	}
	
	public String deleteMenu(int menuId) {
		 sf =SessionHelper.getConnection();
			Session s = sf.openSession();
			Menu menu= new Menu();
			Query q = s.createQuery("from Menu where MENU_ID="+menuId);
			List<Menu> ulist = q.list();
			if (ulist.size() == 1) {
				 menu = ulist.get(0);
				Transaction t = s.beginTransaction();
			    s.delete(menu);
			    t.commit();
			    System.out.println("Record Deleted...");
			}
			return"Tab.xhtml";
			
		}
}
