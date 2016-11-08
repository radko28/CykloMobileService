package sk.cyklosoft.cykloservice.comparator;

import java.util.Comparator;

import sk.cyklosoft.cykloservice.vo.SportActivity;

public class DistanceTripAscComparator implements Comparator<SportActivity> {

	@Override
	public int compare(SportActivity arg0, SportActivity arg1) {
		int result = arg0.getDistanceTrip() < arg1.getDistanceTrip() ? -1 : arg0.getDistanceTrip() > arg1.getDistanceTrip() ? 1 : 0;  
		return result;
	}

}
