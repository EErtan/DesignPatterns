package servant;

// provides similar objects an interface in which to have encapsulated functions, and a separate class to take in the obj and the param for the function
// mover is the servant moving the object my x amount;
// mover does not even have to be instantiated

interface IMovable{
	void setPos(int i);
	int getPos();
}

class Obj implements IMovable{

	Obj(int pos){myPos = pos;}
	int myPos = 0;
	
	@Override
	public void setPos(int i) {
		myPos = i;
		
	}
	@Override
	public int getPos() {
		return myPos;
	}
}

class Mover{
	public static void moveTo(IMovable im, int posToMove){
		int oldPos = im.getPos();
		im.setPos(posToMove);
	}
	
	public static void moveBy(IMovable im, int posToMoveBy){
		im.setPos(im.getPos() + posToMoveBy);
	}
	
}

public class ServantPattern{
	ServantPattern(){}
	public static void main(String...strings){
		Obj myObj = new Obj(1);
		System.out.println(myObj.getPos() + " Before");
		
		Mover.moveTo(myObj, 10);
		System.out.println(myObj.getPos()+ " After");
		
		Mover.moveBy(myObj, 5);
		System.out.println(myObj.getPos()+ " After move by");
		
	}
	
}
