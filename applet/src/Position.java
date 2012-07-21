import java.util.Vector;

/**
 *
 * @author kai
 */
public class Position {

    public byte[] board = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    public byte whiteDeck = 9;
    public byte blackDeck = 9;
    public short turns = 1;

    public boolean whitesTurn() {
        return turns % 2 == 1;
    }

    public void doTurn(Turn t) {
        // Paranoia checking
        if(t.white != whitesTurn())
            throw new RuntimeException("It is not " + (t.white ? "whites" : "blacks") + " turn!");
        if(board[t.to] != 0)
            throw new RuntimeException("Field " + t.to + " occupied!");
        if(t.from == -1) {
            if(t.white && whiteDeck < 1)
                throw new RuntimeException("Whites deck is empty!");
            if(!t.white && blackDeck < 1)
                throw new RuntimeException("Blacks deck is empty!");
        }
        // Now do the turn
        if(t.white) {
            board[t.to] = 1;
            whiteDeck--;
        } else {
            board[t.to] = -1;
            blackDeck--;
        }
        turns++;
    }

    public Turn[] genTurnList() {
        Vector turns = new Vector();
        turns.add(new Turn(true, 0));
        turns.add(new Turn(false, 3));
        return (Turn[]) turns.toArray(new Turn[0]);
    }

}
