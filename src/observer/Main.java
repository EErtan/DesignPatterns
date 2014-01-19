package observer;
// observer pattern.  Single and groups of observers can be registered/removed to subject. Groups, single, and all observers can be notified

// not included: method to dataSet and isDataChanged boolean state to stop unnecessary pushes to observers

// will work with any data type, as it packages the data into an arraylist of objects
// during the information push, the subject also send a parser type interface that the observer uses
// to extract the data from the package
import java.util.ArrayList;

public class Main {
	public static void main(String[] args){
		
		Subject sub = new Subject();
		
		Observer o1 = new Observer();
		Observer o2 = new Observer();
		Observer o3 = new Observer();
		
		ArrayList<Observer> obsGroup = new ArrayList<Observer>();
		obsGroup.add(o2);
		obsGroup.add(o3);
		
		sub.observerGroupRegister(obsGroup);
		sub.observerRegister(o1);
			
		sub.notificationPushSingle(o1);
		
		sub.DataParserSet(new DataParser2());
		sub.notificationPushGroup(obsGroup);
		
		o1.dataParse();
		o2.dataParse();
		o3.dataParse();
		
	}

}
