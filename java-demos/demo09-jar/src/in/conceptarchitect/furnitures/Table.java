package in.conceptarchitect.furnitures;

public class Table{

	int price=5000;

	public int getPrice(){return price; }
	public void setPrice(int newPrice){
		if(newPrice>0)
			price=newPrice;
	}
}