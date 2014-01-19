package decorator;

public class Decorator1 extends DecoratorAbstract{

	public Decorator1(ComponentInterface c) {
		 ci = c;
		}

	@Override
	public int valueGet() {
		return ci.valueGet() + 1;
	}
	
	@Override
	public String nameGet() { // own implementation
		return ci.nameGet() + "D1 ";
	}
	
}
