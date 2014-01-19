package decorator;

public class Main {
	public static void main(String[] args){
		ComponentInterface c1 = new Component();
		ComponentInterface c2 = new Component2();
		
		c1 = new Decorator1(c1);
		c2 = new Decorator2(c2);
		
		System.out.println(c1.nameGet());
		System.out.println(c2.nameGet());
		
		System.out.println(c1.valueGet());
		System.out.println(c2.valueGet());
		
		c1 = new Decorator2(c1);
		c2 = new Decorator1(c2);
		
		System.out.println(c1.nameGet());
		System.out.println(c2.nameGet());

		
		System.out.println(c1.valueGet());
		System.out.println(c2.valueGet());
		
		c1 = new Decorator1(c1);
		c2 = new Decorator2(c2);
		
		System.out.println(c1.nameGet());
		System.out.println(c2.nameGet());
		
		System.out.println(c1.valueGet());
		System.out.println(c2.valueGet());
		
	}

}
