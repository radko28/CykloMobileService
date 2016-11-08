package sk.cyklosoft.cykloservice.mobile.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import sk.cyklosoft.cykloservice.config.annotation.RestEndpoint;
import sk.cyklosoft.cykloservice.data.UserResponseData;
import sk.cyklosoft.cykloservice.data.UserResponseListData;
import sk.cyklosoft.cykloservice.mobile.UserInfo;
import sk.cyklosoft.cykloservice.service.SportService;
import sk.cyklosoft.cykloservice.service.UserService;
import sk.cyklosoft.cykloservice.vo.UserVO;

@RestEndpoint
public class UserInfoImpl implements UserInfo {
    @Autowired
    UserService userService;
    @Autowired
    SportService sportService;

    
    @Override
    @RequestMapping(value = "/register", method = RequestMethod.POST)
	public @ResponseBody void registerUser(@RequestBody UserVO user) {
    	
    	userService.registerUser(user);
		
	}

    @Override
    @RequestMapping(value = "/userdetail/{username}", method = RequestMethod.GET)
	public @ResponseBody
	ResponseEntity<UserResponseData> getUserDetail(@PathVariable String username) {
    	UserResponseData response = userService.getUserDetail(username);
    	return new ResponseEntity<UserResponseData>(response, HttpStatus.OK);
    }
	
	@Override
	@RequestMapping(value = "/{username}/{birthdate}/{weight}/{lenght}", method = RequestMethod.POST)
	public @ResponseBody
	void setUserDetail(@PathVariable String username,
			@PathVariable String birthdate, @PathVariable int weight,
			@PathVariable int lenght) {
		// TODO Auto-generated method stub
		
	}

	@Override
	@RequestMapping(value = "/delete/{username}", method = RequestMethod.DELETE)
    public @ResponseBody void deleteUser(@PathVariable("username") String username)	{
		 sportService.deleteTrainingDataHRM(username);
		 userService.deleteUser(username);
		
	}

	@Override
	@RequestMapping(value = "/{username}/{password}", method = RequestMethod.POST)
	public @ResponseBody
	void loginUser(@PathVariable String username,
			@PathVariable String birthdate, @PathVariable int weight,
			@PathVariable int lenght) {
		// TODO Auto-generated method stub
		
	}

	@Override
	@RequestMapping(value = "/{username}", method = RequestMethod.POST)
	public @ResponseBody
	void logoutUser(@PathVariable String username,
			@PathVariable String birthdate, @PathVariable int weight,
			@PathVariable int lenght) {
		// TODO Auto-generated method stub
		
	}

	@Override
	@RequestMapping(value = "/userlist", method = RequestMethod.GET)
	public @ResponseBody
	ResponseEntity<UserResponseListData> getUserList() {
    	UserResponseListData response = userService.getUserList();
    	return new ResponseEntity<UserResponseListData>(response, HttpStatus.OK);
	}

	

	
}
