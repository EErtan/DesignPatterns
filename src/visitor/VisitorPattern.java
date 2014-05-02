package visitor;

// behavioral pattern of an operation to be performed on the elements of an object structure
// define new operation without changing classes of the elements


//good in hierarchy of elements allowing the elements to remain lightweight by removing functionality from them, and 
// added by inheriting the super to create an visitor subclass

// visitor implements double dispatch, single being name fo request and type  of receiver method(int i)
// where double operation execution depends on name, type of two receivers

interface Element{
	void accept(Visitor v); // which is the another interface
	//this is the first dispatch
}
class Obj1 implements Element{
	public void accept(Visitor v){ v.visit(this);}
	public void printme(){System.out.println(this.getClass().getSimpleName());}
}
class Obj2 implements Element{
	public void accept(Visitor v){ v.visit(this);}
	public void printme(){System.out.println(this.getClass().getSimpleName());}
}
class Obj3 implements Element{
	public void accept(Visitor v){ v.visit(this);}
	public void printme(){System.out.println(this.getClass().getSimpleName());}
}


interface Visitor{
	void visit(Obj1 o); // visit for every method type
	void visit(Obj2 o);
	void visit(Obj3 o); // second dispatch
}

class Operation1 implements Visitor{
	public void visit(Obj1 o){ System.out.print( this.getClass().getSimpleName() + " on "); o.printme(); }
	public void visit(Obj2 o){ System.out.print( this.getClass().getSimpleName() + " on "); o.printme(); }
	public void visit(Obj3 o){ System.out.print( this.getClass().getSimpleName() + " on "); o.printme(); }
}
class Operation2 implements Visitor{
	public void visit(Obj1 o){ System.out.print( this.getClass().getSimpleName() + " on "); o.printme(); }
	public void visit(Obj2 o){ System.out.print( this.getClass().getSimpleName() + " on "); o.printme(); }
	public void visit(Obj3 o){ System.out.print( this.getClass().getSimpleName() + " on "); o.printme(); }
}

public class VisitorPattern {
	
	public static Element[] list = { new Obj1(), new Obj2(), new Obj3()};
	
	public static void main(String...s){
		Operation1 op1 = new Operation1();
		Operation2 op2 = new Operation2();
		for(Element e : list){
			e.accept(op1);
			e.accept(op2);
			System.out.println();
		}
	}

}
