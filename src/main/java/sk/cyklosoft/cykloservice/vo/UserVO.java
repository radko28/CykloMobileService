package sk.cyklosoft.cykloservice.vo;

import java.util.List;

import sk.cyklosoft.cykloservice.model.RoleType;
import sk.cyklosoft.cykloservice.model.UserInfo;
import sk.cyklosoft.cykloservice.util.SportType;

public class UserVO  {
    
    private Long userId;
    
    private String username;
    
    private String firstname;
    
    private String lastname;
    
    private String password;
    
    private boolean enabled;
    
    private AddressVO address;
    
    private UserInfo userInfo;
    
    private SportType currentActivity;
    
    private RoleType authority;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public AddressVO getAddress() {
		return address;
	}

	public void setAddress(AddressVO address) {
		this.address = address;
	}

	public SportType getCurrentActivity() {
		return currentActivity;
	}

	public void setCurrentActivity(SportType currentActivity) {
		this.currentActivity = currentActivity;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public UserInfo getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}

	public RoleType getAuthorityType() {
		return authority;
	}

	public void setAuthorityType(RoleType authority) {
		this.authority = authority;
	}


}
