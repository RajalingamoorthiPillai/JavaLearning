
package in.conceptarchitect.app;

import in.conceptarchitect.finance.*; //get all the classes from finance packae
import in.conceptarchitect.data.*; 
import in.conceptarchitect.furnitures.*;

import in.conceptarchitect.furnitures.Table;
import in.co.sanjay.data.Search;


class FurnitureApp{


	public static void main(String []args){


		Invoice i1=new Invoice();
		Invoice i2=new Invoice();
		Inventory inventory=new Inventory();

		List customerList=new List();
		List furnitures=new List();

		Table t1=new Table();   //furnitures.Table

		in.conceptarchitect.data.Table t2=new in.conceptarchitect.data.Table(); //explicit selection

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