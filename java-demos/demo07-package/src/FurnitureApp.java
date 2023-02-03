
import finance.*; //get all the classes from finance packae
import data.*; 
import furnitures.*;

import furnitures.Table;


class FurnitureApp{


	public static void main(String []args){


		Invoice i1=new Invoice();
		Invoice i2=new Invoice();
		Inventory inventory=new Inventory();

		List customerList=new List();
		List furnitures=new List();

		Table t1=new Table();   //furnitures.Table

		data.Table t2=new data.Table(); //explicit selection

		Chair c1=new Chair();

		Bed b1=new Bed();


		System.out.println(i1);
		System.out.println(i2);
		System.out.println(inventory);

		System.out.println(customerList);
		System.out.println(furnitures);

		System.out.println(t1);
		System.out.println(t2);
		System.out.println(c1);
		System.out.println(b1);


		Search search=new Search();

		System.out.println(search);



	}

}