package visitor;

import java.util.*;

interface Component {
	void printme();
}

class Leaf implements Component {
	private int value;

	public Leaf(int num) {
		value = num;
	}

	public void printme() {
		System.out.print(value + " ");
	}
}

class Composite implements Component {
	private static char next = 'a';
	private List<Component> children = new ArrayList<Component>();
	private char letter = next++;

	public void add(Component c) {
		children.add(c);
	}

	public void printme() {
		System.out.print(letter + " ");
		for (int i = 0; i < children.size(); i++)
			children.get(i).printme();
	}
}

public class VisitorTraversal {
	public static void main(String[] args) {
		Composite[] containers = new Composite[3];

		for (int i = 0; i < containers.length; i++) { // double array implementation for the single steam of info
			// used to pack and unpack a 1d array with 2d data, could probably be used in a 3d array as well
			containers[i] = new Composite();
			for (int j = 1; j < 4; j++){
				containers[i].add(new Leaf(i * containers.length + j));
			}
		}

		for (int i = 1; i < containers.length; i++)
			containers[0].add(containers[i]); // consolidation for the print

		containers[0].printme();
		System.out.println();
	}
}