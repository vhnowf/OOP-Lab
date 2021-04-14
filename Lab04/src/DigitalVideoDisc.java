
public class DigitalVideoDisc {
	private String title;
	private String category;
	private String director;
	private int length;
	private float cost;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
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
	public float getCost() {
		return cost;
	}
	public boolean setCost(float cost) {
		if(cost > 0) {
			this.cost = cost;
			return true;
		}else 	
			return false;
	}
	public DigitalVideoDisc() {
		super();
		this.title = "noname";
		this.category = "unknown";
		this.director = "unknown";
		this.length = 0;
		this.cost = 0.0f;
	}
		
	
	public DigitalVideoDisc(String title) {
		super();
		this.title = title;
	}
	public DigitalVideoDisc(String category, String title) {
		super();
		this.category = category;
		this.title = title;
	}
	public DigitalVideoDisc(String director,String category, String title) {
		super();
		this.director = director;
		this.category = category;
		this.title = title;
	}
	public DigitalVideoDisc( String title,String category,String director, int length, int cost) {
		super();
		this.title = title;
		this.category = category;
		this.director = director;
		this.length = length;
		this.cost = cost;
	}
	
	
}
