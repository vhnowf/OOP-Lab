package hust.soict.hedspi.aims.media;


public class Media {
	protected String title;
	protected String category;
	protected float cost;
	protected String id;
	
	public Media(String id, String title, float cost) {
		this.id = id;
		this.title = title;
		this.cost = cost;
	}
	
	public Media(String id, String title, String category, float cost) {
		this(id, title, cost);
		this.category = category;
	}
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
	public float getCost() {
		return cost;
	}
	public void setCost(float cost) {
		this.cost = cost;
	}
	public String getId() {
		return id;
	}

}
