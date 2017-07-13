package tij4.generics;

import tij4.typeinfo.pets.Mouse;
import tij4.typeinfo.pets.Pet;

public class E01PetsHolder {
	public static void main(String[] args) {
		Holder3<Pet> h3 = new Holder3<Pet>(new Mouse("Mickey"));
		System.out.println(h3.get());
	}
}
