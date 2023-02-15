package in.conceptarchitect.utils;

import java.util.ArrayList;
import java.util.List;

public class CollectionUtils {

	public <X>  List<X> duplicate(List<X> values){

		var target=new ArrayList<X>();
		
		for(var value : values)
			target.add(value);
		
		return target;
		
	}
	
	public <X>  List<X> create(X... params){
		var list =new ArrayList<X>();
		for(var value :params) {
			list.add(value);
		}
		
		return list;
	}
	
	public <X> List<X> search(List<X> list,Matcher<X> matcher){
		
		var target=new ArrayList<X>();
		
		for(var value : list)
			if(matcher.match(value))
			target.add(value);
		
		return target;
		
	}
	
	
}
