package hust.soict.globalict.aims.media;

import hust.soict.globalict.aims.playable.Playable;

public class Track implements Playable {
	private String title;
	private int length;
	public Track(){
	}
	public Track(String title, int length) {
		super();
		this.title = title;
		this.length = length;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	@Override
	public void play() {
		System.out.println("Playing Track: " + this.getTitle());
		System.out.println("Track length: " + this.getLength());
		
	}
	@Override
	public boolean equals(Object o)
	{
		if(o instanceof Track)
			return ((this.title == ((Track) o).title)&&(this.length == ((Track) o).length));
		else
			return false;
	}
	
	
}
