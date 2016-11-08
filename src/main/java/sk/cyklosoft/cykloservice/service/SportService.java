package sk.cyklosoft.cykloservice.service;

import sk.cyklosoft.cykloservice.data.CykloResponseData;
import sk.cyklosoft.cykloservice.util.OrderByType;
import sk.cyklosoft.cykloservice.util.SportType;
import sk.cyklosoft.cykloservice.vo.CykloVO;
import sk.cyklosoft.cykloservice.vo.HrmVO;
import sk.cyklosoft.cykloservice.vo.SportActivityList;


public interface SportService {
	
	void startTraining(String username, SportType sportType);
	
	void stopTraining(String username);
	
	CykloResponseData getTrainingData(String username, SportType sportType);

	SportActivityList getTrainingStatisticList(String username, SportType sportType, String dateFrom, String dateTo, 
			OrderByType orderBy);

	void setTrainingDataHRM(String username, CykloVO cykloVO);
	
	void deleteTrainingDataHRM(String username);
	
	void deleteTrainingDataHRM(String username, SportType sportType);
	
	void deleteTrainingDataHRM(String username, SportType sportType, String date);
	
}
