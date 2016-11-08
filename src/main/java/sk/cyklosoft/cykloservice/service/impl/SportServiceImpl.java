package sk.cyklosoft.cykloservice.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import sk.cyklosoft.cykloservice.comparator.ComparatorFactory;
import sk.cyklosoft.cykloservice.dao.SportDao;
import sk.cyklosoft.cykloservice.dao.UserDao;
import sk.cyklosoft.cykloservice.data.CykloResponseData;
import sk.cyklosoft.cykloservice.model.CykloData;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import sk.cyklosoft.cykloservice.model.User;
import sk.cyklosoft.cykloservice.service.SportService;
import sk.cyklosoft.cykloservice.util.OrderByType;
import sk.cyklosoft.cykloservice.util.SportType;
import sk.cyklosoft.cykloservice.vo.CykloVO;
import sk.cyklosoft.cykloservice.vo.HrmVO;
import sk.cyklosoft.cykloservice.vo.SportActivity;
import sk.cyklosoft.cykloservice.vo.SportActivityList;

@Service("sportService")
@Component
public class SportServiceImpl implements SportService {
	
	@Autowired
	SportDao sportDao;
	@Autowired
	UserDao userDao;
	
	private static DateTimeFormatter DFT = DateTimeFormat.forPattern("dd-MM-yyyy HH:mm:ss");
	
	public void startTraining(String username, SportType sportType) {
		userDao.updateUser(username, sportType);
	}
	
	public void stopTraining(String username) {
		userDao.updateUser(username, SportType.STOP);
	}

	public CykloResponseData getTrainingData(String username, SportType sportType) {
		CykloResponseData result = null;
		CykloData cykloData = null;
		
		switch(sportType) {
			case MTB_CYCLING:
				break;
			case ROAD_CYCLING:
				cykloData = sportDao.getTrainingDataIndoorCyclo(username, SportType.ROAD_CYCLING);
				result = new CykloResponseData();
				CykloVO cykloVO = new CykloVO();
				cykloVO.setHrm(cykloData.getHrm());
				cykloVO.setDistance(cykloData.getDistance());
				cykloVO.setVelocity(cykloData.getVelocity());
				cykloVO.setSportType(SportType.ROAD_CYCLING);
				cykloVO.setDatetime(org.joda.time.format.DateTimeFormat.forPattern("dd-MM-yyyy HH:mm:ss").print(cykloData.getDatetime()));
				result.setCyklo(cykloVO);
				break;
		}
		return result;
	}

	public SportActivityList getTrainingStatisticList(String username, SportType sportType, String dateFrom, String dateTo, 
			OrderByType orderBy) {
		SportActivityList result = null;
		List<CykloData> cykloData = null;

		switch(sportType) {
			case MTB_CYCLING:
				break;
			case ROAD_CYCLING:
				cykloData = sportDao.getTrainingStatisticList(username, sportType, DFT.parseDateTime(dateFrom), DFT.parseDateTime(dateTo));
				result = countSportActivityList(cykloData, orderBy);
				break;
		}
		result.setDateFrom(dateFrom);
		result.setDateTo(dateTo);
		result.setOrderBy(orderBy);
		result.setSportType(sportType);
		return result;
	}

	
	private SportActivityList countSportActivityList(List<CykloData> cykloData, OrderByType orderBy) {
		SportActivityList result = new SportActivityList();
		List<SportActivity> sportActivityList = new ArrayList<SportActivity>();
		SportActivity sportActivity = new SportActivity();
		List<Integer> hrm = new ArrayList<Integer>();
		List<Float> velocity = new ArrayList<Float>();
		List<Float> distance = new ArrayList<Float>();
		int hrmMax = 0;
		int hrmCurrent = 0;
		float velocityMax = 0;
		float velocityCurrent = 0;
		for(CykloData item : cykloData) {
			
			String date = org.joda.time.format.DateTimeFormat.forPattern("dd-MM-yyyy").print(item.getDatetime());
			
//first item			
			if(sportActivity.getDate() == null) {
				sportActivity.setDate(date);
			}
			
			if(sportActivity.getDate() != null && sportActivity.getDate().equals(date)){
//hrm				
				hrmCurrent = item.getHrm(); 
				hrm.add(hrmCurrent);
				hrmMax = hrmCurrent > hrmMax ? hrmCurrent : hrmMax;
//velocity
				velocityCurrent = item.getVelocity(); 
				velocity.add(velocityCurrent);
				velocityMax = velocityCurrent > velocityMax ? velocityCurrent : velocityMax;				
//distance				
				distance.add(item.getDistance());
			} else if(!sportActivity.getDate().equals(date)) {
//hrm				
				sportActivity.setHrm(hrm);
				sportActivity.setHrmAvg(getHrmAvg(hrm));
				sportActivity.setHrmMax(hrmMax);
//velocity
				sportActivity.setVelocity(velocity);
				sportActivity.setVelocityAvg(getVelocityAvg(velocity));
				sportActivity.setVelocityMax(velocityMax);				
//distance				
				sportActivity.setDistance(distance);
				sportActivity.setDistanceTrip(getDistanceMax(distance));
				
				sportActivityList.add(sportActivity);
				
				sportActivity = new SportActivity();
				sportActivity.setDate(date);
				
//hrm			
				hrm = new ArrayList<>();
				hrmMax = 0;
				hrmCurrent = item.getHrm(); 
				hrm.add(hrmCurrent);
				hrmMax = hrmCurrent > hrmMax ? hrmCurrent : hrmMax;
//velocity
				velocity = new ArrayList<>();
				velocityMax = 0;
				velocityCurrent = item.getVelocity(); 
				velocity.add(velocityCurrent);
				velocityMax = velocityCurrent > velocityMax ? velocityCurrent : velocityMax;				
//distance
				distance = new ArrayList<>();
				distance.add(item.getDistance());
				
			}
			
		}
		
//last item
//hrm		
		sportActivity.setHrmAvg(getHrmAvg(hrm));
		sportActivity.setHrmMax(hrmMax);
		sportActivity.setHrm(hrm);
//velocity
		sportActivity.setVelocityAvg(getVelocityAvg(velocity));
		sportActivity.setVelocityMax(velocityMax);
		sportActivity.setVelocity(velocity);
//distance
		sportActivity.setDistance(distance);
		sportActivity.setDistanceTrip(getDistanceMax(distance));
		
		sportActivityList.add(sportActivity);
//sort		
		ComparatorFactory comparatorFactory = new ComparatorFactory();
		Collections.sort(sportActivityList, comparatorFactory.getComparator(orderBy));
		result.setSportActivity(sportActivityList);
		return result;
	}

	private float getVelocityAvg(List<Float> velocity) {
		float sum = 0;
		for(float item : velocity) {
			sum += item;
		}
		return sum/velocity.size();
	}

	private float getDistanceMax(List<Float> distance) {
		return distance.get(distance.size() - 1);
	}

/**
 * average value
 * 	
 */
	private int getHrmAvg(List<Integer> hrm) {
		int sum = 0;
		for(int item : hrm) {
			sum += item;
		}
		return sum/hrm.size();
	}

	@Override
	public void setTrainingDataHRM(String username, CykloVO cykloVO) {
		
		User user = userDao.findUserByUsername(username);
		switch(cykloVO.getSportType()) {
			case MTB_CYCLING:
				break;
			case ROAD_CYCLING:
				CykloData cyklo = new CykloData();
				cyklo.setDatetime(DFT.parseDateTime(cykloVO.getDatetime()));
				cyklo.setHrm(cykloVO.getHrm());
				cyklo.setSportActivity(cykloVO.getSportType());
				cyklo.setUsers(user);
				cyklo.setVelocity(cykloVO.getVelocity());
				cyklo.setDistance(cykloVO.getDistance());
				sportDao.setTrainingDataIndoorCyclo(cyklo);
			break;
		}
		
	}
	
	@Override
	public void deleteTrainingDataHRM(String username) {
		deleteTrainingDataHRM(username, null);
	}

	@Override
	public void deleteTrainingDataHRM(String username, SportType sportType) {
		User user = userDao.findUserByUsername(username);
		if(user != null) {
			sportDao.deleteTrainingDataHRM(user, sportType);
		}
	}

	@Override
	public void deleteTrainingDataHRM(String username,
			SportType sportType, String date) {
		DateTime deleteDate = null;
		if(date != null && date.length() > 0) {
			deleteDate = DFT.parseDateTime(date);
		} 
		sportDao.deleteTrainingDataHRM(username, sportType, deleteDate);
	}



}
