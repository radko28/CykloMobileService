package sk.cyklosoft.cykloservice.dao;

import java.util.List;

import org.joda.time.DateTime;

import sk.cyklosoft.cykloservice.model.CykloData;
import sk.cyklosoft.cykloservice.model.User;
import sk.cyklosoft.cykloservice.util.SportType;
import sk.cyklosoft.cykloservice.util.TrainType;
import sk.cyklosoft.cykloservice.vo.SportActivity;

public interface SportDao {

	void setTrainingDataRun(String username, SportType runnig, long datetime, double hrm);

	void setTrainingDataIndoorCyclo(final CykloData hrm);

	SportActivity getTrainingDataRun(String username, SportType runnig, TrainType trainType);

	CykloData getTrainingDataIndoorCyclo(String username, SportType indoorCycling);

	List<CykloData> getTrainingStatisticList(String username, SportType sportType, DateTime dateFrom, DateTime dateTo);
	
	void deleteTrainingDataHRM(User user, SportType sportType);
	
	void deleteTrainingDataHRM(String username, SportType sportType, DateTime deleteDate);

}
