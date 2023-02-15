package testapp10.collections;

import in.conceptarchitect.utils.Matcher;

public class DivisibilityMatcher implements Matcher<Integer> {

	int divider;
	
	
	
	public DivisibilityMatcher(int divider) {
		super();
		this.divider = divider;
	}



	@Override
	public boolean match(Integer value) {
		// TODO Auto-generated method stub
		return value%divider==0;
	}

}
