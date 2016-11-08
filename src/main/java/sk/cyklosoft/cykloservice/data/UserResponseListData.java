package sk.cyklosoft.cykloservice.data;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UserResponseListData {
	private List<UserResponseData> userResponseData = new ArrayList<>();

	public List<UserResponseData> getUserResponseData() {
		return userResponseData;
	}

	public void setUserResponseData(List<UserResponseData> userResponseData) {
		this.userResponseData = userResponseData;
	}
}
