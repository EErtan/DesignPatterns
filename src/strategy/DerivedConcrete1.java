package strategy;

public class DerivedConcrete1 extends SuperAbstract{
	// int ID
	String name = "DC1";
	// concrete class relying on abstract's method will get abstracts data field
	// override in concrete to use its own members
	// warning, when no overriden constructor, will use abstracts
	// my initialize with abstracts fields
}
