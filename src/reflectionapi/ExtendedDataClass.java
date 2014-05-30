package reflectionapi;

public class ExtendedDataClass extends DataClass{
	ExtendedDataClass(){System.out.println("created edc");}
	
	private String data = "Private data";
	private String PrivateMethod(){return "Private Method";}
	private String PrivateMethodWInput(int i, String s){ return "Private method with input " + i + s;}
	
	public void setData(String d){ data = d;}
	public String getName(){return data;}
	
	ExtendedDataClassFactory dataclassfactory;
	public ExtendedDataClass(ExtendedDataClassFactory dcf){dataclassfactory = dcf;}
	
	void addData(){
		intData = dataclassfactory.addInt();
		stringData = dataclassfactory.addString();
	}

}
