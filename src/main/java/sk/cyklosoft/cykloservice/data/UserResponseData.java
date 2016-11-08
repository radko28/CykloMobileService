package sk.cyklosoft.cykloservice.data;

import sk.cyklosoft.cykloservice.vo.UserVO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UserResponseData {
	
	private UserVO user;

	public UserVO getUser() {
		return user;
	}

	public void setUser(UserVO user) {
		this.user = user;
	}
	

}
