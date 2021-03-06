package sk.cyklosoft.cykloservice.comparator;

import java.util.Comparator;

import sk.cyklosoft.cykloservice.vo.SportActivity;

public class HrmMaxAscComparator implements Comparator<SportActivity> {

	@Override
	public int compare(SportActivity o1, SportActivity o2) {
		int result = o1.getHrmMax() < o2.getHrmMax() ? -1 : o1.getHrmMax() > o2.getHrmMax() ? 1 : 0;  
		return result;
	}

}
