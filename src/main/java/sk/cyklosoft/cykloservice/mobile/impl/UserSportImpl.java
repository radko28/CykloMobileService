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
import sk.cyklosoft.cykloservice.data.CykloResponseData;
import sk.cyklosoft.cykloservice.data.UserResponseData;
import sk.cyklosoft.cykloservice.mobile.UserSport;
import sk.cyklosoft.cykloservice.service.SportService;
import sk.cyklosoft.cykloservice.service.UserService;
import sk.cyklosoft.cykloservice.vo.CykloVO;
import sk.cyklosoft.cykloservice.vo.HrmVO;
import sk.cyklosoft.cykloservice.vo.SportActivityList;
import sk.cyklosoft.cykloservice.util.OrderByType;
import sk.cyklosoft.cykloservice.util.SportType;

@RestEndpoint
public class UserSportImpl implements UserSport {
	
	@Autowired
    SportService sportService;
    @Autowired
    UserService userService;

	
	/*public void startTraining(@PathVariable String username, @PathVariable SportType sportType) {
		sportService.startTraining(username, sportType);
	}*/
//set training data
	//@RequestMapping(value = "/datahrm/{username}", method = RequestMethod.POST)
   // @Override
    //@RequestMapping(value = "/register", method = RequestMethod.POST)
	//public @ResponseBody void setTrainingDataHRM(@RequestBody HrmVO hrmVO) {
	//public void setTrainingDataHRM(@PathVariable("username") String username, @RequestBody HrmVO hrmVO) {
		//
    	//
	//}
	
	/*public void stopTraining(@PathVariable String username, @PathVariable SportType sportType) {
		sportService.stopTraining(username);
	}
	*/
	@Override
	@RequestMapping(value = "/cyklodata/{username}", method = RequestMethod.POST)
	@ResponseBody
	public void setTrainingDataHRM(@PathVariable("username") String username, @RequestBody CykloVO cyklo) {
		sportService.setTrainingDataHRM(username, cyklo);
	}

	@Override
	@RequestMapping(value = "/cyklodata/{username}/{sport_type}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<CykloResponseData> getTrainingData(@PathVariable("username") String username,
			@PathVariable("sport_type") String sportType) {
		CykloResponseData response = sportService.getTrainingData(username, SportType.valueOf(sportType));
		return new ResponseEntity<CykloResponseData>(response, HttpStatus.OK);
	}

	@Override
	@RequestMapping(value = "/cyklodatastat/{username}/{sport_type}/{dateFrom}/{dateTo}/{orderBy}", method = RequestMethod.GET)
	@ResponseBody
	public SportActivityList getTrainingStatisticList(
			@PathVariable("username") String username,
			@PathVariable("sport_type") String sportType,
			@PathVariable("dateFrom") String dateFrom,
			@PathVariable("dateTo") String dateTo,
			@PathVariable("orderBy") String orderBy) {
		SportActivityList sportAvtivityList = null;
		
		sportAvtivityList = sportService.getTrainingStatisticList(username, SportType.valueOf(sportType), dateFrom, dateTo, OrderByType.valueOf(orderBy));
		return sportAvtivityList;
	}

	@Override
	@RequestMapping(value = "/deletecyklodata/{username}/{sport_type}", method = RequestMethod.DELETE)
	@ResponseBody
	public void deleteTrainingDataHRM(
			@PathVariable("username") String username,
			@PathVariable("sport_type") String sportType) {
		sportService.deleteTrainingDataHRM(username, SportType.valueOf(sportType));
	}

	@Override
	@RequestMapping(value = "/deletecyklodata/{username}/{sport_type}/{date}", method = RequestMethod.DELETE)
	@ResponseBody
	public void deleteTrainingDataHRMByDate(
			@PathVariable("username") String username,
			@PathVariable("sport_type") String sportType,
			@PathVariable("date") String date) {
		sportService.deleteTrainingDataHRM(username, SportType.valueOf(sportType), date);
		
	}


}
