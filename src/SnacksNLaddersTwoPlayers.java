import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class SnacksNLaddersTwoPlayers {

    private Map endPointsLadder = new HashMap();
    private Map endPointsSnake = new HashMap();
    int P1Cnt = 0;
    int P2Cnt = 0;

    private int currentPositionP1 = 0, currentPositionP2 = 0;

    public static void main(String[] args) {

	SnacksNLaddersTwoPlayers snl = new SnacksNLaddersTwoPlayers();
	snl.fillEndPoints();

	System.out.println("Game starts :");
	snl.play();

    }

    private void play() {
	int p1 = 0, p2 = 0;

	while (currentPositionP1 != 100 || currentPositionP2 != 100) {
	    // start with Player 1
	    p1 = rollDice();
	    System.out.println(" P1's turn.");
	    System.out.println(" P1 gets " + p1);

	    currentPositionP1 = getNewPosition(currentPositionP1, p1);

	    if (currentPositionP1 == 100) {
		P1Cnt++;
		System.out.println("P1 wins in " + P1Cnt + " turns");
		break;
	    } else if (currentPositionP1 > 100) {
		P1Cnt++;
		currentPositionP1 -= p1;
	    } else {
		P1Cnt++;
		System.out.println(" P1's new position is " + currentPositionP1);
	    }

	    System.out.println("-------------");

	    p2 = rollDice();
	    System.out.println(" P2's turn");
	    System.out.println(" P2 gets " + p2);

	    currentPositionP2 = getNewPosition(currentPositionP2, p2);

	    if (currentPositionP2 == 100) {
		P2Cnt++;
		System.out.println("P2 wins in " + P2Cnt + " turns");
		break;
	    } else if (currentPositionP2 > 100) {
		P2Cnt++;
		currentPositionP2 -= p2;
	    } else {
		P2Cnt++;
		System.out.println(" P2's new position is" + currentPositionP2);
	    }
	    System.out.println("-------------");
	}
    }

    private int rollDice() {
	Random r = new Random();
	return (1 + Math.round(r.nextInt(6)));
    }

    private int getNewPosition(int currPos, int n) {

	int val = currPos + n;

	Integer snakeLadderPos = isSnakeOrLadder(Integer.valueOf(val));
	if (snakeLadderPos == null)
	    currPos += n;
	else {
	    currPos = snakeLadderPos.intValue();
	}
	return currPos;
    }

    private Integer isSnakeOrLadder(Integer n) {
	Integer ret = null;
	if ((ret = (Integer) endPointsLadder.get(n)) != null) {
	    return ret;
	}

	if ((ret = (Integer) endPointsSnake.get(n)) != null) {
	    return ret;
	}
	return ret;
    }

    private void fillEndPoints() {
	// ladders
	endPointsLadder.put(new Integer(5), new Integer(20));
	endPointsLadder.put(new Integer(32), new Integer(52));
	endPointsLadder.put(new Integer(44), new Integer(80));
	endPointsLadder.put(new Integer(75), new Integer(91));
	endPointsLadder.put(new Integer(88), new Integer(97));

	// snakes
	endPointsSnake.put(new Integer(99), new Integer(8));
	endPointsSnake.put(new Integer(83), new Integer(12));
	endPointsSnake.put(new Integer(69), new Integer(39));
	endPointsSnake.put(new Integer(58), new Integer(27));
	endPointsSnake.put(new Integer(31), new Integer(3));

	System.out.println("Details :- ");
	Set kl = endPointsLadder.keySet();
	for (Iterator iterator = kl.iterator(); iterator.hasNext();) {
	    Integer k = (Integer) iterator.next();
	    System.out.println("Ladder Foot " + k + " Ladder Head " + endPointsLadder.get(k));

	}

	Set ks = endPointsSnake.keySet();
	for (Iterator iterator = ks.iterator(); iterator.hasNext();) {
	    Integer k = (Integer) iterator.next();
	    System.out.println("Snake Mouth " + k + " Snake Tail " + endPointsSnake.get(k));

	}

    }

}