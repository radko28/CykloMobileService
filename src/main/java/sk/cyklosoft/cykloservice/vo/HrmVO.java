package sk.cyklosoft.cykloservice.vo;

import sk.cyklosoft.cykloservice.util.SportType;

public class HrmVO {

	private int hrm;
	private String datetime;
	private SportType sportType;
	
	public int getHrm() {
		return hrm;
	}
	public void setHrm(int hrm) {
		this.hrm = hrm;
	}
	public String getDatetime() {
		return datetime;
	}
	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}
	public SportType getSportType() {
		return sportType;
	}
	public void setSportType(SportType sportType) {
		this.sportType = sportType;
	}
 
}
