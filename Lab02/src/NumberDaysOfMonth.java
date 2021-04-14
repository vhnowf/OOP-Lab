import java.util.Scanner;
public class NumberDaysOfMonth {
	public static boolean isNumeric(String s) {  
	    return s != null && s.matches("[-+]?\\d*\\.?\\d+");  
	} 
	public static void main(String[] args) {
		int src[] = {31,28,31,30,31,30,31,31,30,31,30,31};
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Enter month:");
		String strmonth = keyboard.nextLine();
		System.out.println("Enter year:");
		int year = keyboard.nextInt();
		if(year < 0) {
			System.out.println("Invalid year!");
			System.exit(0);
		}
		if(isNumeric(strmonth)==true) {
			int month = Integer.parseInt(strmonth);
			if(year % 4 != 0 || month != 2) {
				for(int i = 0; i <= src.length; i++) {
					if ( i == month-1) {
						System.out.println(src[i]);
					}
				}
			} else {
				System.out.println("29");
			}
		
		}else {
			switch(strmonth) {
			  case "Jannuary":
				  System.out.println(src[0]);
				  break;
			  case "February":
				  if(year % 4 == 0 ) {
					  System.out.println("29");
				  }else {
					  System.out.println(src[1]);
				  }
				  break;
			  case "March":
				  System.out.println(src[2]);
				  break;
			  case "April":
				  System.out.println(src[3]);
				  break;
			  case "May":
				  System.out.println(src[4]);
				  break;
			  case "June":
				  System.out.println(src[5]);
				  break;
			  case "July":
				  System.out.println(src[6]);
				  break;
			  case "August":
				  System.out.println(src[7]);
				  break;
			  case "September":
				  System.out.println(src[8]);
				  break;
			  case"October":
				  System.out.println(src[9]);
				  break;
			  case"November":
				  System.out.println(src[10]);
				  break;
			  case"December":
				  System.out.println(src[11]);
				  break;
			  case "Jan":
				  System.out.println(src[0]);
				  break;
			  case "Feb":
				  if(year % 4 == 0 ) {
					  System.out.println("29");
				  }else {
					  System.out.println(src[1]);
				  }
				  break;
			  case "Mar":
				  System.out.println(src[2]);
				  break;
			  case "Apr":
				  System.out.println(src[3]);
				  break;
			  case "Jun":
				  System.out.println(src[5]);
				  break;
			  case "Jul":
				  System.out.println(src[6]);
				  break;
			  case "Aug":
				  System.out.println(src[7]);
				  break;
			  case "Sep":
				  System.out.println(src[8]);
				  break;
			  case"Oct":
				  System.out.println(src[9]);
				  break;
			  case"Nov":
				  System.out.println(src[10]);
				  break;
			  case"Dec":
				  System.out.println(src[11]);
				  break;
			  case "Jan.":
				  System.out.println(src[0]);
				  break;
			  case "Feb.":
				  if(year % 4 == 0 ) {
					  System.out.println("29");
				  }else {
					  System.out.println(src[1]);
				  }
				  break;
			  case "Mar.":
				  System.out.println(src[2]);
				  break;
			  case "Apr.":
				  System.out.println(src[3]);
				  break;
			  case "Aug.":
				  System.out.println(src[7]);
				  break;
			  case "Sept.":
				  System.out.println(src[8]);
				  break;
			  case"Oct.":
				  System.out.println(src[9]);
				  break;
			  case"Nov.":
				  System.out.println(src[10]);
				  break;
			  case"Dec.":
				  System.out.println(src[11]);
				  break;
			  default:
				  System.out.println("Invalid month!");
			}
		}
		keyboard.close();
		System.exit(0);
	}
	
}
