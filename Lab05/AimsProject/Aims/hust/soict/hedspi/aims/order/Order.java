package hust.soict.hedspi.aims.order;
import hust.soict.hedspi.aims.disc.DigitalVideoDisc;
import hust.soict.hedspi.aims.utils.MyDate;

public class Order {
	
	public Order() {
		super();
		if (nbOrder >= MAX_LIMITTED_ORDERED) {
			System.out.print("Number of order must be less than 5!");
			return;
		} else {
		nbOrder++;
		this.setDateOrdered();
		}
	}
	public static final int MAX_NUMBERS_ORDERED = 10;
	public static final int MAX_LIMITTED_ORDERED = 5;
	
	private int qtyOrdered;
	private	MyDate dateOrdered;
	public static int nbOrder = 0; 
	private DigitalVideoDisc itemsOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
	
	
	public int getQtyOrdered() {
		return qtyOrdered;
	}
	public void setQtyOrdered(int qtyOrdered) {
		this.qtyOrdered = qtyOrdered;
	}
	public void addDigitalVideoDisc(DigitalVideoDisc disc) {
		if(qtyOrdered >= MAX_NUMBERS_ORDERED) {
			System.out.println("Orderlist is full! ");
			return;
		} else {
			itemsOrdered[qtyOrdered] = disc;
			qtyOrdered++;
		}
	}
	public void addDigitalVideoDisc(DigitalVideoDisc [] dvdList) {
		if (qtyOrdered + dvdList.length > MAX_NUMBERS_ORDERED) {
			System.out.println("Orderlist is full! ");
			return;
		}
		for (int i = 0; i < dvdList.length; i++) {
			this.addDigitalVideoDisc(dvdList[i]);
		}
		
	}
	public void addDigitalVideoDisc(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
		if (qtyOrdered + 2 > MAX_NUMBERS_ORDERED) {
			System.out.println("Orderlist is full! ");
			return;
		}else {
			this.addDigitalVideoDisc(dvd1);
			this.addDigitalVideoDisc(dvd2);
		}
	}
	public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
		if(qtyOrdered > 0) {
			 for(int i =0 ; i < qtyOrdered ; i++){
		            if(itemsOrdered[i].getTitle().equals(disc.getTitle())){
		                itemsOrdered[i] = itemsOrdered[i+1];
		                qtyOrdered --;
		                break;
		            }
		        }
		} else {
			System.out.println("Orderlist is empty! ");
			}
	}
	public float totalCost() {
		float total = 0.0f;
		for(int i = 0; i < qtyOrdered; i++) {
			total += itemsOrdered[i].getCost();
		}
		return total;
	}
	public void getDateOrdered() {
		this.dateOrdered.print();
	}
	public void setDateOrdered() {
		MyDate dateOrdered = new MyDate();
		this.dateOrdered = dateOrdered;
	}
	public void print() {
		System.out.println("*************************Order*************************");
		this.getDateOrdered();
		System.out.println("Ordered Items:");
		int k = 1;
		for (int i = 0; i < qtyOrdered ;  i++){
			if(this.itemsOrdered[i]!=null) {
			System.out.println(k + ".DVD - " + this.itemsOrdered[i].getTitle() + " - "  + this.itemsOrdered[i].getDirector() + " - " + this.itemsOrdered[i].getLength() + ": " + this.itemsOrdered[i].getCost());
			k++;
			}
		}
		System.out.println("Total cost: " + this.totalCost());
		System.out.println("*******************************************************");
	}
	public DigitalVideoDisc getALuckyItem() {
		int LuckyNumber = (int)Math.floor(Math.random() * qtyOrdered);
		this.itemsOrdered[LuckyNumber].setCost(0.0f);
		return itemsOrdered[LuckyNumber];
	}
	
	
	
	
}
