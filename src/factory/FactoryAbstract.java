package factory;

public abstract class FactoryAbstract {
	public Item itemProduce(String type){
		
		Item createdItem = null;
		
		switch(type){
		case "Item1":{createdItem = new Item1(); break;}
		case "Item2": {createdItem = new Item2(); break;}
		default: break;
		}
		
		return createdItem;
	}
}
