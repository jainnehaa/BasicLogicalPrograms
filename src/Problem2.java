import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Problem2 {

    public static void main(String args[]) {

	// attributes for fetching array of integers
	Scanner sc = new Scanner(System.in);
	int arrCnt = 0;
	int arrSize = 0;
	System.out.println("enter count of arrays");

	arrCnt = sc.nextInt();
	// attributes for sorting
	ArrayList<Integer> lstInt = new ArrayList<Integer>();
	int[] numbers;
	ArrayList<Integer> newLstInt = new ArrayList<Integer>();

	// for fetching int arrays from console
	for (int i = 0; i < arrCnt; i++) {
	    System.out.println("enter count of elements for array[" + (i + 1) + "]");

	    arrSize = sc.nextInt();
	    numbers = new int[arrSize];
	    System.out.println("enter numbers");
	    for (int j = 0; j < arrSize; j++) {
		numbers[j] = sc.nextInt();
		lstInt.add(numbers[j]);
	    }
	}
	System.out.println("size of list :" + lstInt.size());
	// removing duplicate elements
	for (Integer intVar : lstInt) {
	    if (!newLstInt.contains(intVar)) {
		newLstInt.add(intVar);
	    }
	}

	Collections.sort(newLstInt); // sort in asc
	Collections.reverse(newLstInt); // order in desc

	for (int i = 0; i < 5; i++) {
	    System.out.println(newLstInt.get(i));

	}
    }
}
