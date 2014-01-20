package factory;

public abstract class Item {
	public void namePrint(){
		System.out.println(this.getClass().getSimpleName());
	}
}
