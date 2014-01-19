package decorator;

public class Decorator2 extends DecoratorAbstract{

	public Decorator2(ComponentInterface c) {
		ci = c;
	}

	@Override
	public int valueGet() {
		return ci.valueGet() + 2; // super cannot be called because the method
		// is an abstract in superclass
	}
	
	@Override
	public String nameGet() { // own implementation
		return ci.nameGet() + "D2 ";
	}
}
