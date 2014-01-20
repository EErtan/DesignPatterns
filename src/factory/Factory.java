package factory;

public class Factory extends FactoryAbstract{
// inherited method may be overloaded but due to dynamic binding, compiler will
// give an error that argument is no a string
	public Item itemProduce(int type){

		Item createdItem = null;
		
		switch(type){
		case 1:{createdItem = new Item1(); break;}
		case 2: {createdItem = new Item2(); break;}
		default: break;
		}
		
		return createdItem;
	}
}
