package tij4.reusing;

//inheritance, constructor with argument
import static tij4.net.mindview.util.Print.*;

class Game {
	Game(int i) {
		print("Game constructor");
	}
}

class BoardGame extends Game {
	public BoardGame(int i) {
		super(i);
		print("BoardGame constructor");
	}
}



public class Chess extends BoardGame {
	public Chess(int i) {
		super(i);
		print("Chess constructor");
	}
	
	public static void main(String[] args) {
		Chess chess = new Chess(0);
	}
}
