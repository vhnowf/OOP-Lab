
public class DateTest {

	public static void main(String[] args)throws Exception {
		MyDate date1 = new MyDate("February 18th 2000");
		date1.print();
		MyDate date2 = new MyDate();
		date2.print();
		MyDate date3 = new MyDate(12,1,2000);
		date3.print(); 
		MyDate date4 = new MyDate();
		date4.setDay(2);
		date4.setMonth(4);
		date4.setYear(2021);
		date4.print();
		date3.accept();
		date3.print();
	}

}
