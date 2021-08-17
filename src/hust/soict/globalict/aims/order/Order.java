package hust.soict.globalict.aims.order;
import java.util.ArrayList;

import hust.soict.globalict.aims.media.Book;
import hust.soict.globalict.aims.media.CompactDisc;
import hust.soict.globalict.aims.media.DigitalVideoDisc;
import hust.soict.globalict.aims.media.Media;
import hust.soict.globalict.aims.utils.MyDate;

public class Order 
{
	public static final int MAX_NUMBERS_ORDERED = 10;//the maximum number of items that a customer can buy.
	private ArrayList<Media> itemsOrdered = new ArrayList<Media>();
	private MyDate dateOrdered;
	public static final int MAX_LIMITTED_ORDERS=5; // a limited number of orders of a user
	private int id;
	public Order()
	{
		this.dateOrdered=new MyDate();
	}
	public void addMedia(Media media)
	{
		if(itemsOrdered.size()<MAX_NUMBERS_ORDERED)
		{
			itemsOrdered.add(media);
		}
		else
		{
			System.out.println("Full");
		}
	}
	public void removeMedia(Media media)
	{
		if((itemsOrdered.size()==0)||(itemsOrdered.contains(media)==false))
		{
			System.out.println("Can't remove");
		}
		else
		{
			for(int i=0;i<itemsOrdered.size();i++)
			{
				if(itemsOrdered.get(i).equals(media))
				itemsOrdered.remove(i);	
			}
		}
	}
	public float totalCost()
	{
		float sum=0;
		for(int i=0;i<itemsOrdered.size();i++)
		{
			sum=sum+itemsOrdered.get(i).getCost();
		}
		return sum;
	}
	
	public Media getALuckyItem()
	{
		int i=(int) (Math.random()*itemsOrdered.size());
		itemsOrdered.get(i).setCost(0);
		return itemsOrdered.get(i);
	}
	public void printListItemInOrder()
	{
		System.out.println("***********************Order***********************");
		System.out.print("Date: ");
		dateOrdered.print();
		for(int i=0;i<itemsOrdered.size();i++)
		{
			if(itemsOrdered.get(i) instanceof DigitalVideoDisc)
			{
				DigitalVideoDisc dvd=(DigitalVideoDisc) itemsOrdered.get(i);
				System.out.println(dvd.getId()+".DVD-"+dvd.getTitle()+"-"+dvd.getCategory()+"-"+dvd.getDirector()+"-"+dvd.getLength()+":"+dvd.getCost());
			}
			else if(itemsOrdered.get(i) instanceof Book)
			{
				Book book=(Book) itemsOrdered.get(i);
				System.out.println(book.getId()+".Book-"+book.getTitle()+"-"+book.getCategory()+"-"+book.getCost());
			}
			else if(itemsOrdered.get(i) instanceof CompactDisc)
			{
				CompactDisc cd=(CompactDisc) itemsOrdered.get(i);
				System.out.println(cd.getId()+".CD-"+cd.getTitle()+"-"+cd.getCategory()+"-"+cd.getArtist()+"-"+cd.getDirector()+"-"+cd.getLength()+"-"+cd.getCost());
			}
		}
		System.out.println("Total cost:"+totalCost());
	}


	public MyDate getDateOrdered() {
		return dateOrdered;
	}

	public void setDateOrdered(MyDate dateOrdered) {
		this.dateOrdered = dateOrdered;
	}
	public ArrayList<Media> getItemsOrdered() {
		return itemsOrdered;
	}
	public void setItemsOrdered(ArrayList<Media> itemsOrdered) {
		this.itemsOrdered = itemsOrdered;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	

}
