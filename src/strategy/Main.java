package strategy;

public class Main {
	public static void main(String[] args){
		
		SuperAbstract dc1 = new DerivedConcrete1(); // creation should
		// be encapsulated in class or in a factory
		SuperAbstract dc2 = new DerivedConcrete2();
		
		dc1.IDprint(); // incrementing ID, static counter
		dc2.IDprint();
		
		dc1.namePrint(); // will use super's data members
		dc2.namePrint(); // override, will use own data members
		
		dc1.bi = new Behaviour1(); // set should be encapsulated in class or in a factory, dynamic behaviour
		dc1.namePrint(); // will not change name until explicitly overriden in concrete
		
		dc2.bi = new Behaviour1(); // will work
		dc2.namePrint();
		
	}

}
