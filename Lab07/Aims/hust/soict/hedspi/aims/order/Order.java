package hust.soict.hedspi.aims.order;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.utils.MyDate;
import java.util.ArrayList;


public class Order {
	public ArrayList<Media> itemsOrdered = new ArrayList<Media>();
	
	public static final int MAX_NUMBERS_ORDERED = 10;
	public static final int MAX_LIMITTED_ORDERED = 5;
	
	private	MyDate dateOrdered = new MyDate();
	public static int nbOrder = 0; 
	
	public Order() {
		if (nbOrder >= MAX_LIMITTED_ORDERED) {
			System.out.print("ERR: Number of orders must be less than 5!");
			return;
		} else {
		nbOrder++;
		}
	}
	public void addMedia(Media item){	
		if(itemsOrdered.contains(item)) {
			System.err.println("ERR: The media with title: " + item.getTitle() + " is existed!");
		}else{
			itemsOrdered.add(item);
			System.out.println("MSG: The media with title: " + item.getTitle() + " has been added.");
		}
	}
	public boolean removeMedia(String id) {
		boolean tmp = false;
		for(Media media: itemsOrdered) {
			if(media.getId().equalsIgnoreCase(id)) {
				removeMedia(media);
				tmp = true;
				break;
			}
		}
		if(tmp == false) {
			System.err.println("ERR: Id isn't founded!");
		}
		return tmp;
	}
	
	public void removeMedia(Media item) {
		if(itemsOrdered.contains(item)) {
			System.out.println("MSG: Media with ID: " + item.getId() + " has been deleted!");
			itemsOrdered.remove(item);
		}else {
			System.err.println("ERR: The media may not exist!");
		}
	}

	public float totalCost() {
		float total = 0.0f;
		for(int i = 0; i < itemsOrdered.size(); i++) {
			total += itemsOrdered.get(i).getCost();
		}
		return total;
	}
	public MyDate getDateOrdered() {
		return dateOrdered;
	}

	public void print() {
		System.out.println("*************************Order*************************");
		dateOrdered.print();
		System.out.println("Ordered Items:");
		int i = 1;
		System.out.printf("%-3s | %-6s | %-20s | %-15s |  %-5s ", "STT", "ID", "Title", "Category", "Total");
		System.out.println();
		for(Media media: itemsOrdered) {
				System.out.printf("%-3s | %-6s | %-20s | %-15s | %.2f$\n", i, media.getId(), media.getTitle(), media.getCategory(), media.getCost());
			i++;
		}
		System.out.println("Total cost: " + this.totalCost() + "$");
		System.out.println("*******************************************************");
	}
	public Media getALuckyItem() {
		int LuckyNumber = (int)Math.floor(Math.random() * itemsOrdered.size());
//		this.itemsOrdered.get(LuckyNumber).setCost(0.0f);
		return itemsOrdered.get(LuckyNumber);
		
	}
}
