package com.fball.dto;

import java.util.List;

public class MatchSTTClub {

	private int id;
	private int idSTTClub;
	private String timeStart;
	private String timeEnd;
	private String rs;
	private List<CardPlayer> listPlayer;
	private int state;
	private String timeUpdate;
	private String date;
	private String month;
	private String year;
	
	
	
	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public String getRs() {
		return rs;
	}

	public void setRs(String rs) {
		this.rs = rs;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdSTTClub() {
		return idSTTClub;
	}

	public void setIdSTTClub(int idSTTClub) {
		this.idSTTClub = idSTTClub;
	}

	public String getTimeStart() {
		return timeStart;
	}

	public void setTimeStart(String timeStart) {
		this.timeStart = timeStart;
	}

	public String getTimeEnd() {
		return timeEnd;
	}

	public void setTimeEnd(String timeEnd) {
		this.timeEnd = timeEnd;
	}

	public List<CardPlayer> getListPlayer() {
		return listPlayer;
	}

	public void setListPlayer(List<CardPlayer> listPlayer) {
		this.listPlayer = listPlayer;
	}


	public String getTimeUpdate() {
		return timeUpdate;
	}

	public void setTimeUpdate(String timeUpdate) {
		this.timeUpdate = timeUpdate;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

}
