package factory;

import java.util.ArrayList;

public class Main {
	public static void main(String[] args){
		
		ArrayList<Item> myItems = new ArrayList<Item>();
		FactoryAbstract myFactory = new Factory();
		
		// Item a = myFactory.itemProduce(1); Dynamic binding - will error
		Item a = myFactory.itemProduce("Item1");
		myItems.add(a);
		
		// but if you create factory object with out downcasting correct overloaded method will be called
		Factory myFact = new Factory();
		Item b = myFact.itemProduce(2);
		myItems.add(b);
		
		Item c = FactoryStatic.itemProduce("");
		myItems.add(c); // will trigger default case of null object
		
		for(Item i : myItems){
			try{
				i.namePrint();
			}
			catch(NullPointerException npe){
				System.out.println("Null Object");
			}
			
		}
		
		
	}

}
