package singleton;

class sing{
	private sing(){}
	private static sing s;
	public static sing get(){
		if(s == null){
			System.out.println("null");
			s = new sing();
			return s;
		}
		else System.out.println("not");
		return s;
	}
}

public class Main {
	public static void main(String[] args){
		
		// Singleton mySingleton = new Singleton(); // not allowed
		
		// Singleton mySingleton = Singleton.instanceGet(); // ok if you want an assignment
		// mySingleton.singletonPrint();
		
		
		//Singleton.instanceGet().singletonPrint(); // ok will create the singleton, print method is accessible after creation
		
		//System.out.println( Singleton.doIExist() ); // does exist, implicitly created due to first time access
		
		System.out.println(sing.get());
		System.out.println(sing.get());
		
	}

}
