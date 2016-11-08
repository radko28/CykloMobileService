package sk.cyklosoft.cykloservice.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

import sk.cyklosoft.cykloservice.util.SportType;

@Entity
@Table(name = "CykloData")
public class CykloData implements Serializable {
	
	private static final long serialVersionUID = -7587262565191229835L;
	
   @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
   
	@Column(name = "hrm")
	private int hrm;
	
	@Column(name = "velocity")
	private float velocity;
	
	@Column(name = "distance")
	private float distance;

	@Column(name = "datetime")
	@Type(type = "jodaDateTime")
    private DateTime datetime;
	
	@Column(name = "sportActivity", nullable = false)
    private SportType sportActivity;
	
	@ManyToOne
    @JoinColumn(name = "user_id")
    private User users;

	public DateTime getDatetime() {
		return datetime;
	}

	public void setDatetime(DateTime datetime) {
		this.datetime = datetime;
	}

	public SportType getSportActivity() {
		return sportActivity;
	}

	public void setSportActivity(SportType sportActivity) {
		this.sportActivity = sportActivity;
	}

	public User getUsers() {
		return users;
	}

	public void setUsers(User users) {
		this.users = users;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public float getVelocity() {
		return velocity;
	}

	public void setVelocity(float velocity) {
		this.velocity = velocity;
	}

	public float getDistance() {
		return distance;
	}

	public void setDistance(float distance) {
		this.distance = distance;
	}

	public int getHrm() {
		return hrm;
	}

	public void setHrm(int hrm) {
		this.hrm = hrm;
	}

}
