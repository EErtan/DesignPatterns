package strategy;

abstract class Abs{
	Methods ms;
	public abstract void m1();
	public abstract void m2();
	public void setms(Methods m){
		ms = m;
	}
}

class B1 implements Methods{
	@Override
	public void m1() {
		// do like this
	}

	@Override
	public void m2() {
		// do like like that
	}	
}

class B2 implements Methods{
	@Override
	public void m1() {
		// do like this
	}

	@Override
	public void m2() {
		// do like like that
	}
	
}

class Con extends Abs{
	@Override
	public void m1() {
		ms.m1();
	}
	@Override
	public void m2() {
		ms.m2();
	}
}

interface Methods{
	public void m1();
	public void m2();
}

public class Strat {
	public static void main(String...s){
		Abs a = new Con();
		a.setms( new B1() );
		a.setms( new B2() );
	}
}
