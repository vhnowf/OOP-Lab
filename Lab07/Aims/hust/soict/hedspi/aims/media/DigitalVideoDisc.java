package hust.soict.hedspi.aims.media;

public class DigitalVideoDisc extends Disc implements Playable {
	protected String director;
	protected int length;
	
	public void setDirector(String director) {
		this.director = director;
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
		super(id, title,length, cost);
	}
	
	public DigitalVideoDisc(String id, String title, String category, int length, float cost ) {
		super(id, title, category,length, cost);
	}
	
	public DigitalVideoDisc(String id, String title, String category, int length, String director, float cost) {
		super(id, title, category, length, director, cost);
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

	@Override
	public void play() {
		System.out.println("Playing DVD: " + this.getTitle());
		System.out.println("DVD length: " + this.getLength());
		
	}
	
	
}
