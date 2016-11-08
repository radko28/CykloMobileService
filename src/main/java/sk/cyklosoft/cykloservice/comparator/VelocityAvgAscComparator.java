package sk.cyklosoft.cykloservice.comparator;

import java.util.Comparator;

import sk.cyklosoft.cykloservice.vo.SportActivity;

public class VelocityAvgAscComparator implements Comparator<SportActivity> {

	@Override
	public int compare(SportActivity arg0, SportActivity arg1) {
		int result = arg0.getVelocityAvg() < arg1.getVelocityAvg() ? -1 : arg0.getVelocityAvg() > arg1.getVelocityAvg() ? 1 : 0;  
		return result;
	}

}
