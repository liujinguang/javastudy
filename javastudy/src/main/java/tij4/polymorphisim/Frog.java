package polymorphisim;

import static net.mindview.util.Print.*;

class Characteristic {
	public Characteristic(String s) {
		this.s = s;
		print("Creating Characteristic " + s);
	}
	
	protected void dispose() {
		print("disposing Characteristic " + s);
	}
	
	private String s;
}

class Description {
	public Description(String s) {
		this.s = s;
		print("Creating Description " + s);
	}
	
	protected void dispose() {
		print("disposing Description " + s);
	}
	
	private String s;
}

class LivingCreature {
	private Characteristic p = new Characteristic("is alive");
	private Description t = new Description("Basic living creatue");
	
	public LivingCreature() {
		print("LivingCreature");
	}
	
	protected void dispose() {
		print("LivingCreature dispose");
		t.dispose();
		p.dispose();
	}
}

class Animal extends LivingCreature {
	private Characteristic p = new Characteristic("has heart");
	private Description t = new Description("Animal not Vegetable");
	
	public Animal() {
		print("Animal()");
	}
	
	protected void dispose() {
		print("Animal dispose");
		t.dispose();
		p.dispose();
		
		super.dispose();
	}
}

class Amphibian extends Animal {
	private Characteristic p = new Characteristic("can live in water");
	private Description t = new Description("both water and land");
	public Amphibian() {
		print("Amphibian()");
	}
	
	protected void  dispose() {
		print("Amphibian dispose");
		t.dispose();
		p.dispose();
		super.dispose();
		
	}
}

public class Frog extends Amphibian {
	private Characteristic p = new Characteristic("Croaks");
	private Description t = new Description("eats bugs");
	public Frog() {
		print("Frog()");
	}
	
	protected void  dispose() {
		print("Frog dispose");
		t.dispose();
		p.dispose();
		super.dispose();
	}
	
	public static void main(String[] args) {
		Frog frog = new Frog();
		print("=============bye==============");
		frog.dispose();
	}

}
