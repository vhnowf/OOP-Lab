import java.util.Scanner;
import java.util.Arrays;
public class SortNumericArray {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Enter length of array");
		int n = keyboard.nextInt();
		double[] arr = new double[n+1];
		for(int i = 0; i<n ; i++) {
			System.out.println("Enter element " + i + " of array");
			int elem = keyboard.nextInt();
			arr[i] = elem;
		}
		Arrays.sort(arr);
		System.out.printf("Sorted arr[] : %s",
                Arrays.toString(arr));
		keyboard.close();
		System.exit(0);
	}

}
