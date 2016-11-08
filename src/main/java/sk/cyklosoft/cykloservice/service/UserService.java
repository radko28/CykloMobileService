package sk.cyklosoft.cykloservice.service;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import sk.cyklosoft.cykloservice.data.UserResponseData;
import sk.cyklosoft.cykloservice.data.UserResponseListData;
import sk.cyklosoft.cykloservice.vo.UserVO;

public interface UserService {
	public @ResponseBody UserResponseData getUserDetail(@PathVariable String username);

	public void registerUser(UserVO user);

	public void deleteUser(String username);

	public UserResponseListData getUserList();

}
