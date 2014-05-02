package strategy;

abstract class Abs{
	Methods ms;
	Abs(Methods m){ms=m;}
	public abstract void m1();
	public abstract void m2();
	public void setms(Methods m){
		ms = m;
	}
}

class B1 implements Methods{
	@Override
	public void m1() {
		System.out.println("b1 m1");
	}

	@Override
	public void m2() {
		System.out.println("b1 m2");
	}	
}

class B2 implements Methods{
	@Override
	public void m1() {
		System.out.println("b2 m2");
	}

	@Override
	public void m2() {
		System.out.println("b2 m2");
	}
	
}

class Con extends Abs{
	Con(Methods m) {
		super(m);
		ms = m;
	}
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
		Abs a = new Con(new B1());
		a.m1();
		a.m2();
		a.setms( new B1() );
		a.setms( new B2() );
		a.m1();
		
		Con c = new Con(new B1());
		c.m1();
		c.m2();
		c.setms(new B2());
		c.m1();
		c.m2();
	}
}
