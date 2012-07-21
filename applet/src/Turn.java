/**
 *
 * @author kai
 */
public class Turn {

    public Turn(boolean white, int to) {
        this.white = white;
        this.to = to;
    }

    public boolean white = true;
    public int from = -1;
    public int to = 0;
    public int remove = -1;

}
	