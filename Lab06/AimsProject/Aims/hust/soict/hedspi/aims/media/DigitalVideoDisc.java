package hust.soict.hedspi.aims.media;

public class DigitalVideoDisc extends Media {
	protected String director;
	protected int length;
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public int getLength() {
		return length;
	}
	public boolean setLength(int length) {
		if(length > 0) {
			this.length = length;
			return true;
		}else 	
			return false;
	}

	public DigitalVideoDisc(String id, String title, float cost) {
		super(id, title, cost);
	}
	
	public DigitalVideoDisc(String id, String title, int length, float cost) {
		super(id, title, cost);
		this.length = length;
	}
	
	public DigitalVideoDisc(String id, String title, String category, int length, float cost ) {
		super(id, title, category, cost);
		this.length = length;
	}
	
	public DigitalVideoDisc(String id, String title, String category, int length, String director, float cost) {
		this(id, title, category, length, cost);
		this.director = director;
	}
			
	public boolean search(String title) {
		int  i = 0;
		String[] titleItems = title.split("\\s");
		String[] currentTitleItems = this.getTitle().split("\\s");
		for (String item : titleItems) {
			for (String titleItem: currentTitleItems)
			if (item.equals(titleItem)) {
				i++;
			}
		}
		if ( i == currentTitleItems.length) {
			return true;
		} else 
			return false;
	}
	
	
}
