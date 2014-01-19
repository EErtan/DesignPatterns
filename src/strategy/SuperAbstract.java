package strategy;

public abstract class SuperAbstract{
	int ID;
	public static int counter = 0;
	String name = "void";
	BehaviourInterface bi;
	
	public SuperAbstract(){
		ID = ++counter;
		bi = new Behaviour1();
	}
	
	public void IDprint(){
		System.out.println(ID);
	}
	
	public void namePrint(){ // can make method abstract to force 
		//override and ensure concrete class data members are used
		bi.namePrint(name);
	}
	
}
