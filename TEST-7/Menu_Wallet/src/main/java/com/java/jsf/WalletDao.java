package com.java.jsf;

import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

@ManagedBean(name="walletDao")

public class WalletDao {
	
	private Map<String,Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();

	SessionFactory sf;

	public Wallet[] showWallet() {
		sf = SessionHelper.getConnection();
		Session s = sf.openSession();
		Query q = s.createQuery("from Wallet");
		List<Wallet> walletList= q.list();
		return walletList.toArray(new Wallet[walletList.size()]);
	}
	
	public String addWallet(Wallet wallet) {
	    sf = SessionHelper.getConnection();
		Session s = sf.openSession();
		Transaction t = s.beginTransaction();
		s.save(wallet);
		t.commit();
		System.out.println( "Wallet Stored in Database...");
		return "Tab.xhtml";
	}
	
public String searchWallet(Wallet wallet) {
		sessionMap.put("editWallet", wallet);
		return "editWallet.xhtml";
	}
	
	public String updateWallet(Wallet wallet) {
		sf = SessionHelper.getConnection();
		Session s = sf.openSession();
		Transaction t=s.beginTransaction();
		s.update(wallet);
		t.commit();
		return "Tab.xhtml?faces-redirect=true";
		}
	
	public String deleteWallet(int walletId) {
		sf =SessionHelper.getConnection();
		Session s = sf.openSession();
		Wallet wallet= new Wallet();
		Query q = s.createQuery("from Wallet where Wal_Id="+walletId);
		List<Wallet> ulist = q.list();
		if (ulist.size() == 1) {
		wallet = ulist.get(0);
		Transaction t = s.beginTransaction();
		s.delete(wallet);
		t.commit();
		System.out.println("Record Deleted...");
		}
		return"Tab.xhtml";

		}
}
