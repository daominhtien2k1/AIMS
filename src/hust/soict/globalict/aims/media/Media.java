package hust.soict.globalict.aims.media;

public abstract class Media implements Comparable<Media>{
	protected String title;
	protected String category;
	protected float cost;
	protected int id;
	private static int trackingId;
	public Media() {
	}
	public Media(String title)
	{
		this.title=title;
		trackingId+=1;
		this.id=trackingId;
	}
	public Media(String title,String category)
	{
		this(title);
		this.category=category;
	}
	public Media(String title,String category,float cost)
	{
		this(title,category);
		this.cost=cost;
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
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Override
	public boolean equals(Object o)
	{
		if(o instanceof Media)
			return (this.id == ((Media) o).id);
		else 
			return false;
	}
	  public int compareTo(Media media) {
	        return title.compareTo(media.getTitle());
	    }
}
