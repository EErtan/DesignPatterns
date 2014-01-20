package singleton;

public class Main {
	public static void main(String[] args){
		
		// Singleton mySingleton = new Singleton(); // not allowed
		
		// Singleton mySingleton = Singleton.instanceGet(); // ok if you want an assignment
		// mySingleton.singletonPrint();
		
		
		//Singleton.instanceGet().singletonPrint(); // ok will create the singleton, print method is accessible after creation
		
		System.out.println( Singleton.doIExist() ); // does exist, implicitly created due to first time access
		
	}

}
