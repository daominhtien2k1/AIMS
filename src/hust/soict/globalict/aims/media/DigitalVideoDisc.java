package hust.soict.globalict.aims.media;

import hust.soict.globalict.aims.playable.Playable;

public class DigitalVideoDisc extends Disc implements Playable
{
	public DigitalVideoDisc() {
	}
	public DigitalVideoDisc(String title) {
		super(title);
	}
	public DigitalVideoDisc(String category, String title)
	{
		super(title, category);
	}
	public DigitalVideoDisc(String title, String category, float cost) {
		super(title, category, cost);
	}
	public DigitalVideoDisc(String title, String category, String director, int length, float cost)
	{
		super(title, category, cost);
		this.director = director;
		this.length = length;
	}
	
	public boolean search(String title)
	{
		boolean find=false;
		String arrayTitle[]=title.split("\\s");
		for(String x:arrayTitle)
		{
			if(this.title.equalsIgnoreCase(title))
			{
				find=true;
			}
			else
			{
				find=false;
				break;
			}
			
		}
		return find;
	}

	@Override
	public void play() {
		System.out.println("Playing DVD: " + this.getTitle());
		System.out.println("DVD length: " + this.getLength());
		
	}
}
