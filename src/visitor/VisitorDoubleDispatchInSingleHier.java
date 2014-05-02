package visitor;

public class VisitorDoubleDispatchInSingleHier {
	interface Base{
		
		int numChildProcess = 3;
		
		void baseProcess(Base secondObject);
		
		void childProcess(A firstObject);
		void childProcess(B firstObject);
		void childProcess(C firstObject);
	}

	static class A implements Base{
		
		public void baseProcess(Base secondObject){ secondObject.childProcess(this);}
		
		public void childProcess(A firstObject){ System.out.println("first a second a");}
		public void childProcess(B firstObject){ System.out.println("first b second a");}
		public void childProcess(C firstObject){ System.out.println("first c second a");}
	}
	static class B implements Base{
		
		public void baseProcess(Base secondObject){ secondObject.childProcess(this);}
		
		public void childProcess(A firstObject){ System.out.println("first a second b");}
		public void childProcess(B firstObject){ System.out.println("first b second b");}
		public void childProcess(C firstObject){ System.out.println("first c second b");}
	}
	static class C implements Base{
		
		public void baseProcess(Base secondObject){ secondObject.childProcess(this);}
		
		public void childProcess(A firstObject){ System.out.println("first a second c");}
		public void childProcess(B firstObject){ System.out.println("first b second c");}
		public void childProcess(C firstObject){ System.out.println("first c second c");}
	}
	
	public static void main( String[] args ) {
		
		   Base array[] = { new A(), new B(), new C() };
		
		   for(Base b : array){
		      for (int j=0; j < Base.numChildProcess; j++) // no magic numbers
		         b.baseProcess( array[j] );
		   }
	}
}
