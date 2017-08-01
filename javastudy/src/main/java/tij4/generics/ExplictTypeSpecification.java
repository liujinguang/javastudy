package tij4.generics;

import java.util.List;
import java.util.Map;

import tij4.net.mindview.util.New;
import tij4.typeinfo.pets.Pet;

public class ExplictTypeSpecification {
	public static void f(Map<Person, List<Pet>> petPeople) {
	}

	public static void main(String[] args) {
		f(New.<Person, List<Pet>>map());
	}
}
