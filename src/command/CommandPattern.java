package command;

import java.util.ArrayList;
import java.util.List;

interface ElectronicDevice{
	void on();
	void off();
	void volU();
	void volD();
}

interface Command{void execute(); void undo();}

class GlobalOff implements Command{
	List<ElectronicDevice> eds;
	GlobalOff(List<ElectronicDevice> ed){ eds = ed;}
	@Override
	public void execute() {for(ElectronicDevice e : eds) e.off();}
	public void undo(){for(ElectronicDevice e : eds) e.on();}
}

class Television implements ElectronicDevice{
	private int vol = 0;
	@Override
	public void on(){System.out.println("tv on");}
	@Override
	public void off(){System.out.println("tv off");}
	@Override
	public void volU(){++vol;System.out.println("tv vol up" + vol);}
	@Override
	public void volD(){--vol;System.out.println("tv vol down" + vol);}
}

class Radio implements ElectronicDevice{
	private int vol = 0;
	@Override
	public void on(){System.out.println(" rad on");}
	@Override
	public void off(){System.out.println("rad off");}
	@Override
	public void volU(){++vol;System.out.println("rad vol up" + vol);}
	@Override
	public void volD(){--vol;System.out.println("rad vol down" + vol);}
}

class TVRemote{
	public static ElectronicDevice getDevice(){return new Television();}
}

class TurnTVOn implements Command{
	ElectronicDevice ed;
	TurnTVOn(ElectronicDevice in){ed = in;}
	@Override
	public void execute() {ed.on();}
	public void undo(){ed.off();}
}

class TurnTVOff implements Command{
	ElectronicDevice ed;
	TurnTVOff(ElectronicDevice in){ed = in;}
	@Override
	public void execute() {ed.off();}
	public void undo(){ed.on();}
}

class TurnTVUp implements Command{
	ElectronicDevice ed;
	TurnTVUp(ElectronicDevice in){ed = in;}
	@Override
	public void execute() {ed.volU();}	
	public void undo(){ed.volD();}
}

class TurnTVDown implements Command{
	ElectronicDevice ed;
	TurnTVDown(ElectronicDevice in){ed = in;}
	@Override
	public void execute() {ed.volD();}
	public void undo(){ed.volU();}
}

class DeviceButton{ // this is the invoker
	Command c;
	DeviceButton(Command cc){c = cc;}
	void press(){c.execute();}
	void undo(){c.undo();}
}

public class CommandPattern {				// where we use the remote object
	public static void main(String...strings){
		ElectronicDevice ed = TVRemote.getDevice();
		
		DeviceButton onPressed = new DeviceButton( turnOn(ed) );
		onPressed.press();
		
		onPressed = new DeviceButton( turnOff(ed) );
		onPressed.press();
		System.out.println();
		
		onPressed = new DeviceButton( turnUp(ed) );
		onPressed.press();
		onPressed.press();
		onPressed.press();
		
		onPressed = new DeviceButton( turnDown(ed) );
		onPressed.press();
		System.out.println();
		
		
		Television tv = new Television();
		Radio rad = new Radio();
		List<ElectronicDevice> eds = new ArrayList<ElectronicDevice>();
		eds.add(tv);
		eds.add(rad);
		
		GlobalOff go = new GlobalOff(eds);
		DeviceButton allOffonPressed = new DeviceButton(go);
		allOffonPressed.press();
		
	}
	// added to remove code duplication and to keep instantiation low
	static TurnTVOn turnOn(ElectronicDevice ed){
		TurnTVOn onCommand = new TurnTVOn(ed);
		return onCommand;
	}
	
	static TurnTVOff turnOff(ElectronicDevice ed){
		TurnTVOff offCommand = new TurnTVOff(ed);
		return offCommand;
	}
	
	static TurnTVUp turnUp(ElectronicDevice ed){
		TurnTVUp offCommand = new TurnTVUp(ed);
		return offCommand;
	}
	
	static TurnTVDown turnDown(ElectronicDevice ed){
		TurnTVDown offCommand = new TurnTVDown(ed);
		return offCommand;
	}
}