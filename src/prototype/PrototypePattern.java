package prototype;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// new object instances by cloning other objects
// add subclass instance of known super class during run time
// good for numerous potential of sub classes

class PrototypePattern {
	
	interface Clonable {
		Clonable clone();
	}

	static class One implements Clonable {
		public Clonable clone() {
			return new One();
		}

		public String toString() {
			return "this is one";
		}
	}

	static class Two implements Clonable {
		public Clonable clone() {
			return new Two();
		}

		public String toString() {
			return "this is two";
		}
	}

	static class Three implements Clonable {
		public Clonable clone() {
			return new Three();
		}

		public String toString() {
			return "this is three";
		}
	}
	
	static class Factory { // this version of the protoype can the clonable base type in the factory, to make a clone of an active object, you can pass in your specific instance of type clonable
		// and the factory will produce a clone of the live instance rather than the stored instance
		private static Map prototypes = new HashMap();
		static
		{
			prototypes.put("one", new One());
			prototypes.put("two", new Two());
			prototypes.put("three", new Three());
		}
		
		
		public static Clonable makeClone(String s) {
			Clonable c = ((Clonable)prototypes.get(s)).clone();
			return c;
		}
	}
	public static void main(String...strings){
		Scanner sc = new Scanner(System.in);
		while(true){
			 String s = sc.next();
			 
			 try{
				 System.out.println(Factory.makeClone(s));
			 }catch (Exception e){System.out.println("Cant make");}
		}
	}
}