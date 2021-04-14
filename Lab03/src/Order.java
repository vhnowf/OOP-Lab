
public class Order {
	
	public static final int MAX_NUMBERS_ORDERED = 10;
	private int qtyOrdered;
	private DigitalVideoDisc itemsOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
	
	public int getQtyOrdered() {
		return qtyOrdered;
	}
	public void setQtyOrdered(int qtyOrdered) {
		this.qtyOrdered = qtyOrdered;
	}
	public void addDigitalVideoDisc(DigitalVideoDisc disc) {
		if(qtyOrdered == MAX_NUMBERS_ORDERED) {
			System.out.println("Orderlist is full! ");
		} else {
			itemsOrdered[qtyOrdered] = disc;
			qtyOrdered++;
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
}
