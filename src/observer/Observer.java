package observer;

import java.util.ArrayList;

public class Observer implements ObserverInterface{
	DataParserInterface dpi = new DataParser1();	
	ArrayList<Object> data = new ArrayList<Object>();
	
	@Override
	public void dataPull(ArrayList<Object> d, DataParserInterface dp) {
		data = d;
		dpi = dp;
	}
	
	public void dataParse(){
		dpi.dataParse();
	}

}
