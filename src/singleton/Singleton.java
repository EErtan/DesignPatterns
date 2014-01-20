package singleton;

public class Singleton {
	
	private static Singleton instance;// = new Singleton();
	static{ // on static method calls static members get wiped to default values ex. null
	// explicit static block or the explicit initialization will ensure that the instance will be
	// created before any first static method call or static member access
		instance = new Singleton();
	}
	
	private Singleton(){System.out.println("Created");} //
	// note that this must be a private constructor as you only want construction
	// done internally and not publicly
		
	static{
		instance = new Singleton();
	}
	
	public static Singleton instanceGet(){
		if(instance == null){ // redundant code if using above static block or initializer and limits
			//internal methods to be strictly non static methods
			instance = new Singleton();
		} // when static method will be called, creation is implicit but assignment is not done.
		// upon calling this method, a second Singleton will be created, only the second one will be
		// assigned to data member: instance *inefficient*
		// would rather use explicit creation with explicit assignment via static block, instead of a
		// possible implicit creation and a forced assignment from another method which may be
		// never called, dangling object with no reference
		return instance;
	}
	
	public void singletonPrint(){
		System.out.println("hello");
	}
	
	public static String doIExist(){ // implicitly calls the constructor and wipes all member to null/0
		return "yes";
	}

}
