package strategy;

public class DerivedConcrete2 extends SuperAbstract{
	// int ID
	String name = "DC2";
	
	public DerivedConcrete2(){ // explicit, predictable behaviour
		bi = new Behaviour2();
	}
	
	@Override // will use own data members
	public void namePrint(){
		bi.namePrint(name);
	}
}
