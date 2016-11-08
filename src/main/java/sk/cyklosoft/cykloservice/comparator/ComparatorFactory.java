package sk.cyklosoft.cykloservice.comparator;

import java.util.Comparator;

import sk.cyklosoft.cykloservice.util.OrderByType;
import sk.cyklosoft.cykloservice.vo.SportActivity;

public class ComparatorFactory {
	public Comparator<SportActivity> getComparator(OrderByType orderBy) {
		Comparator<SportActivity> comparator = null;
		switch(orderBy) {
			case HRM_AVG_ASC:
				comparator =  new HrmAvgAscComparator();	
				break;
			case HRM_AVG_DESC:
				comparator =  new HrmAvgDescComparator();	
				break;
			case HRM_MAX_ASC:
				comparator =   new HrmMaxAscComparator();	
				break;
			case HRM_MAX_DESC:
				comparator =   new HrmMaxDescComparator();	
				break;
			case VELOCITY_AVG_DESC:
				comparator =   new VelocityAvgDescComparator();	
				break;
			case VELOCITY_AVG_ASC:
				comparator =   new VelocityAvgAscComparator();	
				break;				
			case DISTANCE_ASC:
				comparator =   new DistanceTripAscComparator();	
				break;				
			case DISTANCE_DESC:
				comparator =   new DistanceTripDescComparator();	
				break;				
				
		}
		return comparator;
	}
}
