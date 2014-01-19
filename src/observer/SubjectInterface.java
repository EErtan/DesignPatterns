package observer;

import java.util.ArrayList;

public interface SubjectInterface {
	public void observerRegister(Observer o);
	public void observerGroupRegister(ArrayList<Observer> obs);
	
	public void observerRemove(Observer o);
	public void observerGroupRemove(ArrayList<Observer> obs);
	
	public void notificationPushAll();
	public void notificationPushGroup(ArrayList<Observer> og);
	public void notificationPushSingle(Observer o);
}
