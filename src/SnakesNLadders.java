import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class SnakesNLadders {

    private static Map map = new HashMap();
    private static int P1Cnt = 0;
    private static int P2Cnt = 0;
    private static int currentPositionP1 = 0;
    private static int currentPositionP2 = 0;

    public static void main(String[] args) {
	fillEndPoints();
	System.out.println("Game starts :");
	play();
    }

    public static void play() {
	int p1 = 0, p2 = 0;
	while (currentPositionP1 != 100 || currentPositionP2 != 100) {

	    System.out.println(" P1's turn.");
	    p1 = rollDice();
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

	    System.out.println(" P2's turn");
	    p2 = rollDice();
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
		System.out.println(" P2's new position is " + currentPositionP2);
	    }
	    System.out.println("-------------");
	}
    }

    public static int rollDice() {
	Random r = new Random();
	return (1 + r.nextInt(6));
	// using Math.random()
	// return 1 + (int) (Math.random() * 5);
    }

    public static int getNewPosition(int currPos, int n) {
	int val = currPos + n;
	Integer snakeLadderPos = null;
	if ((Integer) map.get(Integer.valueOf(val)) != null) {
	    snakeLadderPos = (Integer) map.get(Integer.valueOf(val));
	}
	if (snakeLadderPos == null)
	    currPos += n;
	else {
	    currPos = snakeLadderPos.intValue();
	}
	return currPos;
    }

    private static void fillEndPoints() {

	map.put(new Integer(5), new Integer(20));
	map.put(new Integer(32), new Integer(52));
	map.put(new Integer(44), new Integer(80));
	map.put(new Integer(75), new Integer(91));
	map.put(new Integer(88), new Integer(97));
	map.put(new Integer(99), new Integer(8));
	map.put(new Integer(83), new Integer(12));
	map.put(new Integer(69), new Integer(39));
	map.put(new Integer(58), new Integer(27));
	map.put(new Integer(31), new Integer(3));

    }

}