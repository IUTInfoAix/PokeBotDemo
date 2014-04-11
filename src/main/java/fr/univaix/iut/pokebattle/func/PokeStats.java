package fr.univaix.iut.pokebattle.func;

import java.util.Calendar;
import java.util.Date;

import twitter4j.User;

public class PokeStats {

	private String m_Name   = null;
	private String m_Race   = null;
	private String m_Owner  = null;
	private int m_level     = 1;
	private int m_xp	    = 0;
	private int m_HP_max; 
	private int m_HP_curr;
	private boolean m_dispo = true;
	private Date m_lastact = Calendar.getInstance().getTime();

	private static PokeStats instance = null;

	// Singleton
	public static PokeStats getInstance()
	{			
		if (instance == null) { 	
			instance = new PokeStats();	
		}
		return instance;
	}

	// Getters 
	public String getName() {return m_Name;}
	public String getRace() {return m_Race;}
	public String getOwner() {return m_Owner;}
	public int getHPmax() {return m_HP_max;}
	public int getHPcurr() {return m_HP_curr;}
	public int getLevel() {return m_level;}
	public int getXp() {return m_xp;}
	public boolean isDispo(){ return m_dispo;}
	public Date getLastDate() {return m_lastact; }
	
	// Setters
	public void setOwner(String own) {m_Owner = own;}
	public void setName(String nam) {m_Name = nam;}
	public void setRace(String typ) {m_Race = typ;}
	public void setHPmax(int hpmax) {m_HP_max = hpmax;}
	public void setHPcurr(int hpcurr) {m_HP_curr = hpcurr;}
	public void setXp(int newxp) {m_xp = newxp;}
	public void setLevel(int newlvl) {m_level = newlvl;}
	public void setDispo(boolean bool){ m_dispo = bool;}
	public void setLastDate(Date laaast) {m_lastact = laaast; }
}