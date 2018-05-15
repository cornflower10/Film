package com.jiangpw.utils;


public enum CacheTimes {
	ONE_MINUTE(60),
	FIVE_MINUTE(300),
	TEN_MINUTES(600),
	TWENTY_MINUTES(1200),
	HALF_HOUR(1800),
	ONE_HOUR(3600),
	SIX_HOURS(21600),
	HALF_DAY(43200),
	ONE_DAY(86400),
	ONE_WEEK(604800),
	THIRTY_DAYS(2592000),
	PERMENANT(0),
	HSSESSIONKEY_EXPIRE_TIME(900),
	HSROLE_EXPIRE_TIME(21600);
	
	private int time;
	
	private CacheTimes(int time){
		this.time = time;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}
	
}
