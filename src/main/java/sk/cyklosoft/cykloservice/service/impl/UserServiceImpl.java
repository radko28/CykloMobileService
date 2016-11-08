package sk.cyklosoft.cykloservice.service.impl;

import java.util.List;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import sk.cyklosoft.cykloservice.dao.AuthorityDao;
import sk.cyklosoft.cykloservice.dao.UserDao;
import sk.cyklosoft.cykloservice.data.UserResponseData;
import sk.cyklosoft.cykloservice.data.UserResponseListData;
import sk.cyklosoft.cykloservice.model.Authority;
import sk.cyklosoft.cykloservice.model.EmailType;
import sk.cyklosoft.cykloservice.model.User;
import sk.cyklosoft.cykloservice.service.UserService;
import sk.cyklosoft.cykloservice.util.SportType;
import sk.cyklosoft.cykloservice.vo.AddressVO;
import sk.cyklosoft.cykloservice.vo.UserVO;



@Service("userService")
@Component
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserDao userDao;
    @Autowired
    AuthorityDao authorityDao;

	public UserResponseData getUserDetail(String username) {
		User user = userDao.findUserByUsername(username);
		
		UserResponseData response = new UserResponseData();
		UserVO userVO = getUserVO(user);
    	//userVO.setEnabled(true);
    	response.setUser(userVO);

         /*Authority authAdmin = new Authority();
         authAdmin.setAuthority(RoleType.ROLE_ADMIN);
         authAdmin.setUsername(admin.getUsername());
         authAdmin.setUsers(admin);
         session.save(authAdmin);*/
    	
    	AddressVO addressVO = new AddressVO();
    	addressVO.setAddressId(1027L);
    	addressVO.setCity("Terany");
    	addressVO.setCountry("Slovakia");
    	addressVO.setPhone("0911760775");
    	addressVO.setZip("96268");
    	addressVO.setAddress("27");
    	//response.setAddress(address);
    	
		return response;
	}

	@Override
	public void registerUser(UserVO userVO) {
		User user = new User();
		user.setFirstname(userVO.getFirstname());
		user.setLastname(userVO.getLastname());
		user.setPassword(userVO.getPassword());
		user.setUsername(userVO.getUsername());
		user.setCurrentActivity(SportType.STOP);
		user.setEnabled(true);
	    user.setCreated(new DateTime());
		userDao.register(user);
		
        Authority auth = new Authority();
        auth.setAuthority(userVO.getAuthorityType());
        auth.setUsername(userVO.getUsername());
        auth.setUsers(user);
        authorityDao.save(auth);
        sendUserMail(user,EmailType.REGISTER_USER);		
		
	}

	private void sendUserMail(User user, EmailType registerUser) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteUser(String username) {
		authorityDao.remove(username);
		userDao.delete(username);
		
	}

	@Override
	public UserResponseListData getUserList() {
		UserResponseListData result = new UserResponseListData();
		List<User> userList = userDao.findAllUsers();
		for(User user : userList) {
			UserVO userVO = getUserVO(user);
			UserResponseData userResponseData = new UserResponseData();
			userResponseData.setUser(userVO);
			result.getUserResponseData().add(userResponseData);
		}
		return result;
	}
	
	private UserVO getUserVO(User user) {
		UserVO userVO = new UserVO();
    	userVO.setUsername(user.getUsername());
    	userVO.setFirstname(user.getFirstname());
    	userVO.setLastname(user.getLastname());
    	userVO.setPassword(user.getPassword());
    	userVO.setUserId(user.getUserId());
    	userVO.setCurrentActivity(user.getCurrentActivity());

		return userVO;
	}


}
