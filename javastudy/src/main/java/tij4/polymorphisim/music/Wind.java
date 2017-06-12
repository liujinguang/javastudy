package polymorphisim.music;

import static net.mindview.util.Print.*;

/**Wind objects are instruments because they have the same interface
 * @author bob
 *
 */
public class Wind extends Instrument {
	@Override
	public void play(Note n) {
		print("Wind.play() " + n);
	}
}
