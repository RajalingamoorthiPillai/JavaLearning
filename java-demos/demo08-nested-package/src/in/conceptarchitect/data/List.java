package in.conceptarchitect.data;

public class List{

	int items; //defaults to 0
	String itemsString=""; 

	public void add(String item){
		items++;
		itemsString+=item+"\t";
	}

	public void remove(String item){
		items--;
	}

	public int count(){
		return items;
	}

	/*
	public String toString(){
		if(items==1)
			return "List of "+items+" item";
		else
			return "List of "+items+" items";
	}
	*/

	public String toString(){
		if(items==0)
			return "(empty)";
		else
			return "[\t"+itemsString+"]";
	}

}