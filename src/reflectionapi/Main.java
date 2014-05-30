package reflectionapi;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

interface ExtendedDataClassFactory{
	public int addInt();
	public String addString();
}

public class Main {
	public static void main(String...args){
		 Class reflectClass = ExtendedDataClass.class;
		 String className = reflectClass.getName();
		 
		 int classModifiers = reflectClass.getModifiers();
		 
		 // such as isAbstract, isFinal, isInterface, isPrivate, isPublic, isProtected,
		 // isStatic, isStrict, isSynchronized, isVolatile
		 System.out.println(Modifier.isPublic(classModifiers));
		 
		 //if a class had interfaces
		 Class[] interfaces = reflectClass.getInterfaces();
		 
		 Class classSuper = reflectClass.getSuperclass();
		 System.out.println(classSuper.getName());
		 
		 Method[] methods = reflectClass.getMethods();
		 
		 
		 for(Method m : methods){
			 System.out.println("methods name is " + m.getName());
			 if(m.getName().startsWith("get"))
				 System.out.println("getter");
			 else if(m.getName().startsWith("set"))
				 System.out.println("setter");
			 System.out.println("the return type is" + m.getReturnType());
			 
			 Class[] params = m.getParameterTypes();
			 for(Class p : params)
				 System.out.println(p.getName());
		 }
		 
		 Constructor constructors = null;
		 Object constructorObj = null;
		 try {
			constructors = reflectClass.getConstructor(new Class[] {ExtendedDataClassFactory.class});
			try {
				constructorObj = reflectClass.getConstructor(int.class, String.class).newInstance(12,"hello");
			} catch (InstantiationException | IllegalAccessException
					| IllegalArgumentException | InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (NoSuchMethodException | SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		Class[] constructorParameters = constructors.getParameterTypes();
		for(Class cp : constructorParameters){
			System.out.println(cp.getName());
		}
		
		ExtendedDataClass edc = null;
		ExtendedDataClassFactory edcf = null;
		
		try {
			edc = (ExtendedDataClass) constructors.newInstance(edcf);
		} catch (InstantiationException | IllegalAccessException
				| IllegalArgumentException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		 edc.setData("new data");
		 System.out.println(edc.getName());
		 
		 Field privateStringData = null;
		 ExtendedDataClass edcPrivate = new ExtendedDataClass(edcf);
		 try {
		
			 String dataString = "data"; // dynamically access any field, with just acces to its name
			 
			 privateStringData = ExtendedDataClass.class.getDeclaredField("dataString");
			 
			 privateStringData.setAccessible(true);
			 
			 try {
				String valueOfData = (String) privateStringData.get(edcPrivate);
				
				System.out.println("private field name" + valueOfData); 
				
				
				String methodName = "PrivateMethod";
				try {
					Method privateMethod = ExtendedDataClass.class.getDeclaredMethod(methodName, null);
				
					privateMethod.setAccessible(true); // needed to make privates accesible
					
			
						String privateReturnVal = (String) privateMethod.invoke(edcPrivate, null);
						
						System.out.println("ExtendedDataClassprivate method " + privateReturnVal );
						
						//to execute a method that has parameters
						Class[] methodPrameters = new Class[]{Integer.TYPE, String.class};
						Object params = new Object[]{new Integer(10), new String("stringshehehe")};
						privateMethod = ExtendedDataClass.class.getDeclaredMethod("PrivateMethodWInput", methodPrameters);
						
						privateMethod.setAccessible(true);
						
						privateReturnVal = (String) privateMethod.invoke(edcPrivate, params);
						
						System.out.println("edc other private method with input" + privateReturnVal);
						
		
					
				
				
				} catch (NoSuchMethodException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			} catch (IllegalArgumentException | IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (NoSuchFieldException | SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		 
		 
		 
		 
		 
		 
		 
	}
}
