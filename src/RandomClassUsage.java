import java.util.Random;

public class RandomClassUsage {

    public static final void main(String... aArgs) {
	// System.out.println("Generating 10 random integers in range 0..99.");
	Random randomGenerator = new Random();
	for (int i = 0; i < 10; i++) {
	    System.out.println(randomGenerator.nextInt(100));
	}

	System.out.println("Generating random integers in the range 1..10.");
	int START = 1;
	int END = 4;
	long range = (long) END - (long) START + 1;
	System.out.println("range: " + range);

	for (int i = 0; i < 10; i++) {
	    long fraction = (long) (range * randomGenerator.nextDouble());
	    System.out.println(randomGenerator.nextDouble());
	    System.out.println(range * randomGenerator.nextDouble());
	    System.out.println(fraction);
	    int randomNumber = (int) (fraction + START);
	    System.out.println("Generated : " + randomNumber);
	}

    }

}
