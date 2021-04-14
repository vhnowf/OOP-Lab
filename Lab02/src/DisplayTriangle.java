import java.util.Scanner;
public class DisplayTriangle {

	public static void main(String[] args) {

		Scanner keyboard = new Scanner(System.in);
		System.out.print("n = ");
		int height  = keyboard.nextInt();
		if(height>0) {
		for (int r = 1; r <= height	; r++) {
			for (int sp = height - r; sp > 0; sp--) {
					System.out.print(" ");
			}
			for (int c = 1; c <= r; c++) {
					System.out.print("*");
			}
			for (int k = 2; k <= r; k++) {
					System.out.print("*");
				}
				System.out.println();
			}		 
		}else {
			System.out.println("n must be than 0 !");
		}
		keyboard.close();
		System.exit(0);
	}

}
