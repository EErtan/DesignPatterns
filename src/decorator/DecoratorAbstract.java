package decorator;

public abstract class DecoratorAbstract  implements ComponentInterface{ 
	ComponentInterface ci;
	
	// making method or constructor concrete will bring complexity to the calls
	// super(c) will called in derived constructor
	
	public abstract int valueGet(); // both abstract and non methods can be used based on requirements
	public abstract String nameGet();
	// remember concrete methods in abstract class will use the abstract classes data fields
	// references sent as argument will provide the correct data for method augmentation
	
	
}
