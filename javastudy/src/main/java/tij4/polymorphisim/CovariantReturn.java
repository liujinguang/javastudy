package polymorphisim;

class Grain{
	@Override
	public String toString() {
		return "Grain";
	}
}

class Wheat extends Grain {
	@Override
	public String toString() {
		return "Wheat";
	}
}

class Mill {
	Grain process() {
		return new Grain();
	}
}

class WheatMill extends Mill {
	@Override
	Wheat process() {
		return new Wheat();
	}
}

public class CovariantReturn {
	public static void main(String[] args) {
		Mill mill = new Mill();
		Grain g = mill.process();
		System.out.println(g);
		
		mill  = new WheatMill();

		g = mill.process();
		System.out.println(g);
	}
}
