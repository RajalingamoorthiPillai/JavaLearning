class FurnitureApp{


	public static void main(String []args){

		List customerList=new List();
		customerList.add("Vivek");


		List furnitures=new List();
		furnitures.add("Chair");
		furnitures.add("Table");
		furnitures.add("Bed");


		System.out.printf("Total Customers: %d\n", customerList.count());
		System.out.printf("Furntitures: %d\n", furnitures.count());

		Chair c1=new Chair();
		Chair c2=new Chair();

		c1.price=3000;
		System.out.printf("c1.price=%d\tc2.price=%d\n",c1.price,c2.price);


		Bed b1=new Bed();

		Inventory inventory=new Inventory();

		Invoice invoice1=new Invoice();

		Invoice invoice2=new Invoice();


		Table t1=new Table();

		
		System.out.println(t1);
		System.out.println(b1);
		System.out.println(inventory);
		System.out.println(invoice1);
		System.out.println(invoice1.toString());
		System.out.println(invoice2);
		

		System.out.println("customerList "+customerList);
		System.out.println("furntiures "+furnitures);

		
	}

}