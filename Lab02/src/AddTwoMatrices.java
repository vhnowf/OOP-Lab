import java.util.Scanner;
public class AddTwoMatrices {
	public static void sum(int[][] first, int[][] second) {
		int row = first.length;
		int column = first[0].length;
		int[][] sum = new int[row][column];

		for (int r = 0; r < row; r++) {
			for (int c = 0; c < column; c++) {
				sum[r][c] = first[r][c] + second[r][c];
			}
		}
		printArray(sum);
	}

	public static void printArray(int[][] matrix) {
		for (int r = 0; r < matrix.length; r++) {
			for (int c = 0; c < matrix[0].length; c++) {
				System.out.print(matrix[r][c] + "\t");
			}
			System.out.println();
		}
	}
	public static void main(String[] args) {
		
		System.out.println("Please enter the rows in the matrix");
		Scanner keyboard = new Scanner(System.in);
		int row = keyboard.nextInt();
		System.out.println("Please enter the columns in the matrix");
		int column = keyboard.nextInt();

		int[][] first = new int[row][column];
		int[][] second = new int[row][column];

		for (int r = 0; r < row; r++) {
			for (int c = 0; c < column; c++) {
				System.out.println(String.format("Enter first matrix's element [%d][%d] ", r, c));
				first[r][c] = keyboard.nextInt();
			}
		}

		for (int r = 0; r < row; r++) {
			for (int c = 0; c < column; c++) {
				System.out.println(String.format("Enter second matrix's element[%d][%d] ", r, c));
				second[r][c] = keyboard.nextInt();
			}
		}
		keyboard.close();
		System.out.println("First matrix:");
		printArray(first);
		
		System.out.println("Second matrix:");
		printArray(second);
		System.out.println("Sum of two same size matrixes:");
		sum(first, second);
	}

	
}
