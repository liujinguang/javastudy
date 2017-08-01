package tij4.generics;

import java.util.List;
import java.util.Map;

import tij4.net.mindview.util.New;
import tij4.typeinfo.pets.Pet;

class Person {
	
}

public class LimitsOfInference {
	public static void f(Map<Person, List<? extends Pet>> petPeople) {
		
	}
	
	public static void main(String[] args) {
//		f(New.map()); Does not compile
	}
}
