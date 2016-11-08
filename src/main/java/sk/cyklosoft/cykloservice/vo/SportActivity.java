package sk.cyklosoft.cykloservice.vo;

import java.util.List;

public class SportActivity {
	
	private int hrmMax;
	private int hrmAvg;
	private float distanceTrip;
	private float velocityAvg;
	private float velocityMax;
	private String date;
	private List<Integer> hrm;
	private List<Float> distance;
	private List<Float> velocity;
	
	public int getHrmMax() {
		return hrmMax;
	}
	public void setHrmMax(int hrmMax) {
		this.hrmMax = hrmMax;
	}
	public int getHrmAvg() {
		return hrmAvg;
	}
	public void setHrmAvg(int hrmAvg) {
		this.hrmAvg = hrmAvg;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public List<Integer> getHrm() {
		return hrm;
	}
	public void setHrm(List<Integer> hrm) {
		this.hrm = hrm;
	}
	public List<Float> getDistance() {
		return distance;
	}
	public void setDistance(List<Float> distance) {
		this.distance = distance;
	}
	public List<Float> getVelocity() {
		return velocity;
	}
	public void setVelocity(List<Float> velocity) {
		this.velocity = velocity;
	}
	public float getDistanceTrip() {
		return distanceTrip;
	}
	public void setDistanceTrip(float distanceTrip) {
		this.distanceTrip = distanceTrip;
	}
	public float getVelocityAvg() {
		return velocityAvg;
	}
	public void setVelocityAvg(float velocityAvg) {
		this.velocityAvg = velocityAvg;
	}
	public float getVelocityMax() {
		return velocityMax;
	}
	public void setVelocityMax(float velocityMax) {
		this.velocityMax = velocityMax;
	}
	

}
