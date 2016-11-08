package sk.cyklosoft.cykloservice.mobile;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import sk.cyklosoft.cykloservice.data.UserResponseData;
import sk.cyklosoft.cykloservice.data.UserResponseListData;
import sk.cyklosoft.cykloservice.vo.UserVO;


@RequestMapping("/userInfo")
public interface UserInfo {
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public @ResponseBody void registerUser(@RequestBody UserVO user);

	@RequestMapping(value = "/userdetail/{username}", method = RequestMethod.GET)
    public @ResponseBody ResponseEntity<UserResponseData> getUserDetail(@PathVariable String username);
	
	@RequestMapping(value = "/userlist", method = RequestMethod.GET)
    public @ResponseBody ResponseEntity<UserResponseListData> getUserList();
	
	@RequestMapping(value = "/{username}/{birthdate}/{weight}/{lenght}", method = RequestMethod.POST)
    public @ResponseBody void setUserDetail(@PathVariable String username, @PathVariable String birthdate,
    		@PathVariable int weight, @PathVariable int lenght);

	@RequestMapping(value = "/delete/{username}", method = RequestMethod.DELETE)
	public @ResponseBody void deleteUser(@PathVariable("username") String username);	
	
	@RequestMapping(value = "/{username}/{password}", method = RequestMethod.POST)
    public @ResponseBody void loginUser(@PathVariable String username, @PathVariable String birthdate,
    		@PathVariable int weight, @PathVariable int lenght);
	
	@RequestMapping(value = "/{username}", method = RequestMethod.POST)
    public @ResponseBody void logoutUser(@PathVariable String username, @PathVariable String birthdate,
    		@PathVariable int weight, @PathVariable int lenght);
    		
	
}
