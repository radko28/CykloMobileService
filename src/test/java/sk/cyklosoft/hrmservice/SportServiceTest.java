package sk.cyklosoft.hrmservice;

import java.util.Random;

import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;
import org.springframework.web.client.RestTemplate;

import sk.cyklosoft.cykloservice.data.HrmResponseData;
import sk.cyklosoft.cykloservice.util.OrderByType;
import sk.cyklosoft.cykloservice.util.SportType;
import sk.cyklosoft.cykloservice.vo.CykloVO;
import sk.cyklosoft.cykloservice.vo.SportActivityList;

public class SportServiceTest {
	private static String URL = "http://localhost:8080/CykloMobileService/sport";
	private static String USERNAME = "radko28";
	private static String USERNAME2 = "admin";
	private static String USERNAME3 = "radko41";
	private RestTemplate restTemplate = null; 
	private HrmResponseData response = null;	
	 
	
	@Before
	public void setUp() {
		restTemplate = new RestTemplate();
	}	
	 
	@Test
	public void setTrainingDataCyklo() {
		int count = 5;
		String method = "/cyklodata/" + USERNAME;
		CykloVO cykloVO = new CykloVO(); 
		cykloVO.setSportType(SportType.ROAD_CYCLING);
		
		DateTime dateTime = new DateTime();
		float distance = 0f;
		//one training
		for(int i =0; i < count; i++) {
			dateTime = dateTime.plusSeconds(120);
			cykloVO.setDatetime(org.joda.time.format.DateTimeFormat.forPattern("dd-MM-yyyy HH:mm:ss").print(dateTime));
			cykloVO.setHrm(new Random().nextInt((175 - 150) + 1) + 150);
			cykloVO.setVelocity(new Random().nextFloat() * (40f - 20f) + 20f);
			distance++;
			cykloVO.setDistance(distance);
			response = restTemplate.postForObject(URL + method, cykloVO, HrmResponseData.class);
		}
		
		dateTime = dateTime.plusDays(1);
		distance = 0f;
		//one training
		for(int i =0; i < count; i++) {
			dateTime = dateTime.plusSeconds(120);
			cykloVO.setDatetime(org.joda.time.format.DateTimeFormat.forPattern("dd-MM-yyyy HH:mm:ss").print(dateTime));
			cykloVO.setHrm(new Random().nextInt((175 - 150) + 1) + 150);
			cykloVO.setVelocity(new Random().nextFloat() * (40f - 20f) + 20f);
			distance++;
			cykloVO.setDistance(distance);
			response = restTemplate.postForObject(URL + method, cykloVO, HrmResponseData.class);
		}

		dateTime = dateTime.plusDays(1);
		distance = 0f;
		//one training
		for(int i =0; i < count; i++) {
			dateTime = dateTime.plusSeconds(120);
			cykloVO.setDatetime(org.joda.time.format.DateTimeFormat.forPattern("dd-MM-yyyy HH:mm:ss").print(dateTime));
			cykloVO.setHrm(new Random().nextInt((175 - 150) + 1) + 150);
			cykloVO.setVelocity(new Random().nextFloat() * (40f - 20f) + 20f);
			distance++;
			cykloVO.setDistance(distance);
			response = restTemplate.postForObject(URL + method, cykloVO, HrmResponseData.class);
		}
		
		method = "/cyklodata/" + USERNAME2;
		
		dateTime = dateTime.plusDays(1);
		distance = 0f;
		//one training
		for(int i =0; i < count; i++) {
			dateTime = dateTime.plusSeconds(120);
			cykloVO.setDatetime(org.joda.time.format.DateTimeFormat.forPattern("dd-MM-yyyy HH:mm:ss").print(dateTime));
			cykloVO.setHrm(new Random().nextInt((175 - 150) + 1) + 150);
			cykloVO.setVelocity(new Random().nextFloat() * (40f - 20f) + 20f);
			distance++;
			cykloVO.setDistance(distance);
			response = restTemplate.postForObject(URL + method, cykloVO, HrmResponseData.class);
		}
		
		dateTime = dateTime.plusDays(1);
		distance = 0f;
		//one training
		for(int i =0; i < count; i++) {
			dateTime = dateTime.plusSeconds(120);
			cykloVO.setDatetime(org.joda.time.format.DateTimeFormat.forPattern("dd-MM-yyyy HH:mm:ss").print(dateTime));
			cykloVO.setHrm(new Random().nextInt((175 - 150) + 1) + 150);
			cykloVO.setVelocity(new Random().nextFloat() * (40f - 20f) + 20f);
			distance++;
			cykloVO.setDistance(distance);
			response = restTemplate.postForObject(URL + method, cykloVO, HrmResponseData.class);
		}

		dateTime = dateTime.plusDays(1);
		distance = 0f;
		//one training
		for(int i =0; i < count; i++) {
			dateTime = dateTime.plusSeconds(120);
			cykloVO.setDatetime(org.joda.time.format.DateTimeFormat.forPattern("dd-MM-yyyy HH:mm:ss").print(dateTime));
			cykloVO.setHrm(new Random().nextInt((175 - 150) + 1) + 150);
			cykloVO.setVelocity(new Random().nextFloat() * (40f - 20f) + 20f);
			distance++;
			cykloVO.setDistance(distance);
			response = restTemplate.postForObject(URL + method, cykloVO, HrmResponseData.class);
		}
		
	}	 
	
	@Test
	public void getTrainingData() {
		String method = "/cyklodata/{username}/{sport_type}";
		response = restTemplate.getForObject(URL + method, HrmResponseData.class, USERNAME, SportType.ROAD_CYCLING.name());
		System.out.println(response);
	}	
	
	@Test
	public void getTrainingStatisticList() {
		String method = "/cyklodatastat/{username}/{sport_type}/{dateFrom}/{dateTo}/{orderBy}";
		String dateFrom = org.joda.time.format.DateTimeFormat.forPattern("dd-MM-yyyy HH:mm:ss").print(new DateTime(2016,11,8,11,15));
		String dateTo = org.joda.time.format.DateTimeFormat.forPattern("dd-MM-yyyy HH:mm:ss").print(new DateTime(2016,11,13,19,15));
		String orderBy = OrderByType.HRM_MAX_ASC.name();
		SportActivityList response =  restTemplate.getForObject(URL + method, SportActivityList.class, USERNAME, SportType.ROAD_CYCLING.name(), dateFrom, dateTo, orderBy);
		System.out.println(response);
	}
	
	@Test
	public void deleteTrainingDataCyklo() {
		String method = "/deletecyklodata/{username}/{sport_type}";
		restTemplate.delete(URL + method, USERNAME, SportType.ROAD_CYCLING.name());
		restTemplate.delete(URL + method, USERNAME2, SportType.ROAD_CYCLING.name());
	}
	
	@Test
	public void deleteTrainingDataCykloByDate() {
		String method = "/deletecyklodata/{username}/{sport_type}/{date}";
		String date = org.joda.time.format.DateTimeFormat.forPattern("dd-MM-yyyy HH:mm:ss").print(new DateTime(2016,11,07,11,15));
		
		restTemplate.delete(URL + method, USERNAME, SportType.ROAD_CYCLING.name(), date);
	}		



	
}
