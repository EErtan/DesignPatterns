package template;

// used to provide structure and create inversion of control for the concrete classes to override


abstract class Template {

	protected void BuildRobot() {

		DesignFrame();
		AddHardware();
		AddOS();
		PackageRobot();
	}


	protected void DesignFrame() {
		System.out.println("Frame Version 1.0\n------------------");
	}

	protected abstract void AddHardware();

	protected abstract void AddOS();

	protected void PackageRobot() {
		System.out.println("Ready to ship");
	}
}

abstract class LuxModel extends Template {
	@Override
	protected void AddHardware() {
		
		AddHardware_PowerSuspention();
		AddHardware_ImprovedBattery();
	}
	protected void AddHardware_PowerSuspention() {
		System.out.println("PowerSuspen Added");
	}
	protected void AddHardware_ImprovedBattery() {
		System.out.println("ImprovedBatt Added\n------------------");
	}

	protected abstract void AddOS();
}

class LuxFighter extends LuxModel{

	@Override
	protected void AddOS() {
		System.out.println("OS Fighter-3.2v");
		System.out.println("OS Plug-In: Liquid Style");
	}
	@Override
	protected void PackageRobot() {
		System.out.println("\n------------------\nLiquid Style Activated");
		super.PackageRobot();
	}
}

public class TemplatePattern {
	public static void main(String...s){
		Template fighter = new LuxFighter();
		fighter.BuildRobot();
		
		System.out.println();
		
	}
}
