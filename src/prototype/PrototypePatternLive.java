package prototype;


interface Prototype extends Cloneable{ // clonable from the java lang
	Prototype makeCopy();
	int getVal();
}

class Worker implements Prototype{
	int i;
	Worker(int ii){i = ii;}
	Worker(){System.out.println("Worker made");}

	public int getVal(){
		return i;
	}
	@Override
	public Prototype makeCopy() {
		Worker w = null;
		
		try{
			w = (Worker) super.clone();
		}catch(CloneNotSupportedException e){e.printStackTrace();}
			return w;
		}
	}

class Factory{
	public static Prototype getCopyObj(Prototype toCopy){
		Prototype p = toCopy.makeCopy();
		System.out.println(System.identityHashCode(p));
		return p;
	}
	 
}

public class PrototypePatternLive {
	public static void main(String...strings){
		
		Worker w = new Worker(5);
		System.out.println(System.identityHashCode(w));
		
		Prototype p = Factory.getCopyObj(w);
		
		// or
		
		Worker ww = (Worker) Factory.getCopyObj(w);
	
	}

}
























