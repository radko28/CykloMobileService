package sk.cyklosoft.hrmservice;

import org.junit.Before;
import org.junit.Test;
import org.springframework.web.client.RestTemplate;

import sk.cyklosoft.cykloservice.data.UserResponseData;
import sk.cyklosoft.cykloservice.data.UserResponseListData;
import sk.cyklosoft.cykloservice.model.RoleType;
import sk.cyklosoft.cykloservice.vo.UserVO;

public class UserServiceTest {
	
	private static String URL = "http://localhost:8080/CykloMobileService/userInfo";
	private static String USERNAME = "radko28";
	private static String USERNAME2 = "admin";
	private static String USERNAME3 = "radko41";
	private RestTemplate restTemplate = null; 
	private UserResponseData response = null;	
	private UserResponseListData userResponseListData = null;
	
	 @Before
	 public void setUp() {
		 restTemplate = new RestTemplate();
	 }

	@Test
	public void registerUser() {
		String method = "/register";
		UserVO user = new UserVO();
		user.setFirstname("Radoslav");
		user.setLastname("Kuzma");
		user.setPassword("rado");
		user.setUsername(USERNAME);
		user.setAuthorityType(RoleType.ROLE_USER);
		response = restTemplate.postForObject(URL + method, user, UserResponseData.class);
		
		user.setUsername(USERNAME2);
		user.setAuthorityType(RoleType.ROLE_ADMIN);
		response = restTemplate.postForObject(URL + method, user, UserResponseData.class);
	}
	
	@Test
	public void getUserDetail() {
		String method = "/userdetail/{username}";
		response = restTemplate.getForObject(URL + method, UserResponseData.class, USERNAME);
		System.out.println(response);
	}
	
	@Test
	public void deleteUser() {
		String method = "/delete/{username}";
		restTemplate.delete(URL + method, USERNAME);
		restTemplate.delete(URL + method, USERNAME2);
	}
	
	@Test
	public void userList() {
		String method = "/userlist";
		userResponseListData = restTemplate.getForObject(URL + method, UserResponseListData.class);
		System.out.println(userResponseListData);
	}

	
	void setUserDetail() {
		
	}
	
	void loginUser() {
		
	}
	
	void logoutUser() {
		
	}
}
