package observer;

import java.util.ArrayList;

public class Subject implements SubjectInterface {
	DataParserInterface dpi = new DataParser1();
	ArrayList<Observer> observerList = new ArrayList<Observer>();
	ArrayList<Object> data = new ArrayList<Object>();
	
	@Override
	public void observerRegister(Observer o) {
		observerList.add(o);		
	}

	@Override
	public void observerGroupRegister(ArrayList<Observer> obs) {
		observerList.addAll(obs);
	}

	@Override
	public void observerRemove(Observer o) {
		observerList.remove(o);
	}

	@Override
	public void observerGroupRemove(ArrayList<Observer> obs) {
		observerList.removeAll(obs);
	}

	@Override
	public void notificationPushAll() { 
		for(Observer o : observerList){
			o.dataPull(data, dpi);
		}
	}
	
	@Override
	public void notificationPushGroup(ArrayList<Observer> og) { 
		for(Observer o : og){
			o.dataPull(data, dpi);
		}
	}

	@Override
	public void notificationPushSingle(Observer o) {
		o.dataPull(data, dpi);		
	}
	
	public void DataParserSet(DataParserInterface d){
		dpi = d;
	}
	
}
