package proxy;

// structural pattern: consisting of the same interface of the class it holds, similar to a facade, but does not necessarily collaborate with different modules to produce a finalized interface
// more of a raw 1:1.2 mapping, can also to object accounting see code

interface Image {
	void display();
	void RotateImage(int degree);
}

class Picture implements Image {

	Picture(String fn) {
		filename = fn;
		LoadFile();
	}

	private String filename;
	private int loadTime = 0;

	private void LoadFile() {
		System.out.println("loading file..." + filename);
		loadTime = 10;
	}

	@Override
	public void display() {
		System.out.println("displayed");
	}

	public void RotateImage(int degree) {
		System.out.println("Rotated by " + degree);
	}

	public String getFN() {return filename;}

	public int getLT() {return loadTime;}

}

class Proxy implements Image {

	Proxy(String fn) {filename = fn;}
	String filename;
	Picture p = null;
	int timeRotated;
	
	private void LoadImage(){
		p = new Picture(filename); // lazy instantiation
	}
	
	@Override
	public void display() {
		if(p == null) LoadImage();
		p.display();
	}

	@Override
	public void RotateImage(int degree) {
		if(p == null) LoadImage();
		p.RotateImage(degree);
		display();
		++timeRotated;
	}

	public String getFilename() {return p.getFN();}

	public int getLoadTime() {return p.getLT();}
}

public class Main {

	public static void main(String... s) {
		Image i = new Proxy("Easter.jpg");
		i.display();
		i.RotateImage(15);
	}

}
