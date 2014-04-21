package facade;

// intent: wrapper-facade: encapsulate low level functions and data structures within a more robust, concise, and portable, higher-level object oriented class interface for mostly lower level native calls
// facade - used just to simplify the interface for a sub system	

// implementation: --identify the cohesive abstractions and relationships among existing functions
// -- cluster cohesive groups of methods into a wrapper facade class : minimize unnecessary coupling
// -- identify what is static and what is dynamic
// -- select the level of indirection, see bridge pattern if dynamic dispatch is used to implement wf methods
// -- determine where to handle platform specific variation

// -- determine error handling: extensible, type safe, impact on resource management, time/space efficiency
// -- define helper functions

// Known uses: gui frameworks, database class libs

interface Questioner{
	public String type(String s);
}

class Facade implements Questioner{

	Factory myFactory = new Factory();
	Questioner myQ;
	
	Facade(String s){
		String[] q = s.split(" ");
		myFactory.create(q[0]);
		System.out.println(type(q[0]));
	}
	
	@Override
	public String type(String s) {
		return myQ.type(s);
	}
	
	class What implements Questioner{

		@Override
		public String type(String s) {
			return "what isn't";
		}
		
	}
	class Why implements Questioner{

		@Override
		public String type(String s) {
			return "why not";
		}
	}
	class Factory{
		public void create(String s){
			switch(s){
			case "Why": myQ  = new Why(); break;
			case "What":myQ = new What(); break;
			}
		}
	}
	
}

public class Main {
	public static void main(String... strings) {
		Facade f = new Facade("What time is it?");
	}
}
