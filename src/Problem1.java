import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Problem1 {

	public static void main(String args[]) {
		String str = null;
		Scanner sc = new Scanner(System.in);

		str = sc.nextLine();

		String strArr[] = str.split(" ");
		int sizeArr = strArr.length;
		String[] array = new String[sizeArr];
		Map<String, Integer> map = new HashMap<String, Integer>();

		for (int loopCnt = 0; loopCnt < sizeArr; loopCnt++) {
			array[loopCnt] = strArr[loopCnt].trim();
		}
		int a = 0;
		for (int loopCnt = 0; loopCnt < sizeArr; loopCnt++) {
			if (!map.containsKey(array[loopCnt])) {
				map.put(array[loopCnt], 1);
			} else {
				a = map.get(array[loopCnt]);
				a++;
				map.put(array[loopCnt], a);
			}
		}
		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			System.out.println(entry.getKey() + " has count "
					+ entry.getValue());
		}

		Map.Entry<String, Integer> maxEntry = null;
		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			if (maxEntry == null
					|| entry.getValue().compareTo(maxEntry.getValue()) > 0) {
				maxEntry = entry;
			}
		}
		System.out.println(maxEntry.getKey() + " has max value "
				+ maxEntry.getValue());
	}
}
