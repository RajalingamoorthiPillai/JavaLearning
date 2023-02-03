class List{

	int items; //defaults to 0
	String itemsString=""; 

	void add(String item){
		items++;
		itemsString+=item+"\t";
	}

	void remove(String item){
		items--;
	}

	int count(){
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