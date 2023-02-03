class List{

	int items; //defaults to 0

	void add(String item){
		items++;
	}

	void remove(String item){
		items--;
	}

	int count(){
		return items;
	}

	public String toString(){
		if(items==1)
			return "List of "+items+" item";
		else
			return "List of "+items+" items";
	}

}