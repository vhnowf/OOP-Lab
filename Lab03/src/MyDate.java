import java.time.LocalDate;
import java.util.Scanner;
import java.util.List;
import java.util.Arrays;

public class MyDate {
	int day;
	int month;
	int year;
	
	public MyDate(int day, int month, int year) {
		super();
		if((day >=1 && day <=31) && (month >=1 && month <= 12) && (year >= 0)){
	            this.day = day;
	            this.month = month;
	            this.year = year;
	        }
	        else{
	            if(day < 1 || day > 31)
	                System.out.println("Error : Invalid day");
	            if(month < 1 || month > 12)
	                System.out.println("Error : Invalid month");
	            if (year < 0)
	                System.out.println("Error : Invalid year");
	       }
	}
	public MyDate() {
		super();
		this.day = LocalDate.now().getDayOfMonth();
        this.month = LocalDate.now().getMonthValue();
        this.year = LocalDate.now().getYear(); 
	}
	public MyDate(String strDate){
		// date-format: mm-dd-yyyy 
		 int [] Date = validDate(strDate);
	     if(Date != null){
	            this.month = Date[0];
	            this.day = Date[1];
	            this.year = Date[2];
	     }
	}

    private int[] validDate(String date){
        int error = 0 ;
        String[] dspl = date.split("\\s");
        String month = dspl[0], day = dspl[1], year = dspl[2];
        int m = checkValidMonth(month,validMonth);
        if(m == 0) {
            System.out.println("Error Month!");
            error = 1;
        }
        int d = checkValidDay(day) ;
        if(d == 0){
            System.out.println("Error Day!");
            error = 1;
        }
        int y = 0;
        if(isNumeric(year)) {
            y = Integer.parseInt(year);
            if(y < 0)
            {
                System.out.println( "Error Year!");
                error = 1;
            }
        }
        else{
            System.out.println("Error Year!");
            error = 1;
        }
        if(error == 0){
            if(d < getDaysOfMonth(m,y)) {
                int[] Date = {m, d, y};
                return Date;
            }
            else{
                System.out.println("Error invalid day!");
                return null;
            }
        }
        else {
            return null;
        }
    }
    private List<String> validMonth = Arrays.asList("January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December",
            "Jan.", "Feb.", "Mar.", "Apr.", "Aug.", "Sept.", "Oct.", "Nov.", "Dec.",
            "Jan","Feb","Mar","Apr","Jul","Aug","Aug","Sep","Oct","Nov","Dec"
    );
    private int checkValidMonth(String month, List<String> validMonth){
        if(isNumeric(month) && Integer.parseInt(month) >= 1 && Integer.parseInt(month)<=12)
            return Integer.parseInt(month);
        if(validMonth.stream().filter(o-> o.toLowerCase().equals(month.toLowerCase())).findFirst()!=null){
            String m = month.toLowerCase();
            if(m.equals("january") || m.equals("jan.") || m.equals("jan"))
                return 1;
            else if (m.equals("february") || m.equals("feb.") || m.equals("feb"))
                return 2;
            else if (m.equals("march") || m.equals("mar.") || m.equals("mar"))
                return 3;
            else if (m.equals("april") || m.equals("apr.") || m.equals("apr"))
                return 4;
            else if (m.equals("may"))
                return 5;
            else if (m.equals("june") || m.equals("jun"))
                return 6;
            else if (m.equals("july") || m.equals("jul"))
                return 7;
            else if (m.equals("august") || m.equals("aug.") || m.equals("aug"))
                return 8;
            else if (m.equals("september") || m.equals("sep.") || m.equals("sep"))
                return 9;
            else if (m.equals("october") || m.equals("oct.") || m.equals("oct"))
                return 10;
            else if (m.equals("november") || m.equals("nov.") || m.equals("nov"))
                return 11;
            else if (m.equals("december") || m.equals("dec.") || m.equals("dec"))
                return 12;
        }
        return 0;
    }
    private boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    private int checkValidDay(String strDate){
        int date;
        if(isNumeric(strDate))
        	date =  Integer.parseInt(strDate);
        else{
            String dateFormat = strDate.substring(strDate.length()-2).toLowerCase();
            if(dateFormat.equals("st")||dateFormat.equals("nd")||dateFormat.equals("rd")||dateFormat.equals("th")){
            	strDate = strDate.substring(0,strDate.length()-2);
            }
            if(isNumeric(strDate))
            	date =  Integer.parseInt(strDate);
            else
                return 0;
        }
        if(date >= 1 && date <= 31)
            return date;
        else
            return 0;
    }
    private int getDaysOfMonth (int month, int year) {
        if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12)
            return 31;
        else if (month == 2 && year % 4 == 0) {
            return 29;
        } else if (month == 2 && year % 4 != 0)
            return 28;
        else
            return 30;
    }
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		if(day >= 1 && day <= getDaysOfMonth(month,year))
            this.day = day;
      else {
      System.out.println("Error: Invalid Day.");
      		}
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
	    if(month >=1 && month <=12)
            this.month = month;
        else {
            System.out.println("Error: Invalid Month.");
        }
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		if(year >=0 )
	        this.year = year;
	    else {
	        System.out.println("Error: Invalid Year.");
	    }

	}
	public void accept(){
        // date-format: mm-dd-yyyy 
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter the date:");
        String date = keyboard.nextLine();
        int [] Date = validDate(date);
        if(Date != null){
            this.month = Date[0];
            this.day  = Date[1];
            this.year = Date[2];
        }
       keyboard.close();
    }
	public void print() {
		System.out.println("Date: " + this.day + "/" + this.month + "/" + this.year);
	}
}
