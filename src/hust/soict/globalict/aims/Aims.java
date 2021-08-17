package hust.soict.globalict.aims;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import hust.soict.globalict.aims.media.Book;
import hust.soict.globalict.aims.media.CompactDisc;
import hust.soict.globalict.aims.media.DigitalVideoDisc;
import hust.soict.globalict.aims.media.Media;
import hust.soict.globalict.aims.media.Track;
import hust.soict.globalict.aims.order.Order;

public class Aims
{
	private ArrayList<Order> listOrders=new ArrayList<Order>();
	private static HashMap<Integer,Media> listSourceMedia=new HashMap<Integer,Media>();
	
	public static void main(String[] args)
	{	
//		MemoryDaemon memoryDaemon=new MemoryDaemon();
//		Thread thread=new Thread(memoryDaemon);
//		thread.setDaemon(true);
//		thread.start();
		
		Aims anUser=new Aims();
		InputListSourceMedia();
		PrintListItem();
		System.out.println("--------------------------------");
		showMenu();
		Scanner sc=new Scanner(System.in);
		do {
			System.out.println("Please choose a number: 0-1-2-3-4");
			int x=sc.nextInt();
			if(x==0)
				return;
			else if(x==1)
				anUser.CreateNewOrder();
			else if(x==2)
				anUser.AddItemToOrder();
			else if(x==3)
				anUser.DeleteItemFromOrder();
			else if(x==4)
				anUser.DisplayItemFromOrder();
		}while(true);
	}
	public static void showMenu() {
		System.out.println("Order Management Application: ");
		System.out.println("1. Create new order");
		System.out.println("2. Add item to the order");
		System.out.println("3. Delete item by id");
		System.out.println("4. Display the items list of order");
		System.out.println("0. Exit");
		System.out.println("--------------------------------");
	}
	
	public void CreateNewOrder() 
	{
		System.out.println("Create New Order");
		if(listOrders.size()<Order.MAX_LIMITTED_ORDERS)
		{	
			 listOrders.add(new Order());
			 System.out.println("Successful for creating a "+listOrders.size()+" order");
		}
		else
		{
			System.out.println("LIMIT ORDER");
		}
	}
	public void AddItemToOrder()
	{
		System.out.println("Add Item To Order");
		System.out.println("Select type of media:\n 1.Book\n 2.Disc");
		Scanner sc=new Scanner(System.in);
		int x=sc.nextInt();
		if(x==1)
		{
			PrintListSpecifiedItem("Book");
			System.out.println("Select Id Item");
			int y=sc.nextInt();
			listOrders.get(listOrders.size()-1).addMedia(listSourceMedia.get(y));
		}
		else if(x==2)
		{
			System.out.println("Select type of Disc:\n 1.DVD\n 2.CD");
			int y=sc.nextInt();
			if(y==1)
			{
				PrintListSpecifiedItem("DVD");
				System.out.println("Select Id Item");
				int z=sc.nextInt();
				listOrders.get(listOrders.size()-1).addMedia(listSourceMedia.get(z));
			}
			else if(y==2)
			{
				PrintListSpecifiedItem("CD");
				System.out.println("Select Id Item");
				int z=sc.nextInt();
				listOrders.get(listOrders.size()-1).addMedia(listSourceMedia.get(z));
			}
		}
	}
	public void DeleteItemFromOrder()
	{
		System.out.println("Delete Item From Order");
		DisplayItemFromOrder();
		System.out.println("Select Id Item To Remove");
		Scanner sc=new Scanner(System.in);
		int x=sc.nextInt();
		if(listOrders.get(listOrders.size()-1).getItemsOrdered().contains(listSourceMedia.get(x)))
			listOrders.get(listOrders.size()-1).removeMedia(listSourceMedia.get(x));
	}
	public void DisplayItemFromOrder()
	{
		for(int i=0;i<listOrders.size();i++)
		{
			listOrders.get(i).printListItemInOrder();	 
		}
	}
	public static void InputListSourceMedia()
	{
		DigitalVideoDisc dvd1=new DigitalVideoDisc("The Lion King","Animation","Roger Allers",87,19.95f);
		listSourceMedia.put(dvd1.getId(), dvd1);
		
		DigitalVideoDisc dvd2=new DigitalVideoDisc("Star Wars","Science Fiction","George Lucas",124,24.95f);
		listSourceMedia.put(dvd2.getId(), dvd2);
		
		DigitalVideoDisc dvd3=new DigitalVideoDisc("Aladdin","Animation","John Musker",90,18.99f);
		listSourceMedia.put(dvd3.getId(), dvd3);
		
		
		CompactDisc cd1=new CompactDisc("You of yesterday", "Love music", "Son Tung MTP", "MTP entertainment", 0, 0);
		Track track1=new Track("You and me are friends", 2);
		Track track2=new Track("You and me are love",3);
		cd1.addTrack(track1);
		cd1.addTrack(track2);
		listSourceMedia.put(cd1.getId(), cd1);
		
		Book book1=new Book("Harry Potter", "Fantasy",63f);
		book1.addAuthor("J.K.Rowling");
		listSourceMedia.put(book1.getId(),book1);
		
		Book book2=new Book("Head first Java","Reference",20f);
		book2.addAuthor("Kathy Sierra");
		book2.addAuthor("Bert Bates");
		listSourceMedia.put(book2.getId(),book2);
	}
	public static void PrintListItem()
	{
		System.out.println("***********************ListItemInSource***********************");
		for(Map.Entry<Integer,Media> entry:	 listSourceMedia.entrySet())
		{
			System.out.print(entry.getKey());
			if(entry.getValue() instanceof DigitalVideoDisc)
			{
				DigitalVideoDisc dvd=(DigitalVideoDisc) entry.getValue();
				System.out.println(".DVD-"+dvd.getTitle()+"-"+dvd.getCategory()+"-"+dvd.getDirector()+"-"+dvd.getLength()+":"+dvd.getCost());
			}
			else if(entry.getValue() instanceof Book)
			{
				Book book=(Book) entry.getValue();
				System.out.println(".Book-"+book.getTitle()+"-"+book.getCategory()+"-"+book.getCost());
			}
			else if(entry.getValue() instanceof CompactDisc)
			{
				CompactDisc cd=(CompactDisc) entry.getValue();
				System.out.println(".CD-"+cd.getTitle()+"-"+cd.getCategory()+"-"+cd.getArtist()+"-"+cd.getDirector()+"-"+cd.getLength()+":"+cd.getCost());
			}
		}
	}
	public void PrintListSpecifiedItem(String string)
	{
		if(string=="Book")
		{
			System.out.println("***********************ListItemBookInSource***********************");
			for(Map.Entry<Integer,Media> entry:	 listSourceMedia.entrySet())
			{
				if(entry.getValue() instanceof Book)
				{
					System.out.print(entry.getKey());
					Book book=(Book) entry.getValue();
					System.out.println(".Book-"+book.getTitle()+"-"+book.getCategory()+"-"+book.getCost());
				}
			}
		}
		else if(string=="DVD")
		{
			System.out.println("***********************ListItemDVDInSource***********************");
			for(Map.Entry<Integer,Media> entry:	 listSourceMedia.entrySet())
			{
				if(entry.getValue() instanceof DigitalVideoDisc)
				{
					System.out.print(entry.getKey());
					DigitalVideoDisc dvd=(DigitalVideoDisc) entry.getValue();
					System.out.println(".DVD-"+dvd.getTitle()+"-"+dvd.getCategory()+"-"+dvd.getDirector()+"-"+dvd.getLength()+":"+dvd.getCost());
				}
			}
		}
		else if(string=="CD")
		{
			System.out.println("***********************ListItemDVDInSource***********************");
			for(Map.Entry<Integer,Media> entry:	 listSourceMedia.entrySet())
			{
				if(entry.getValue() instanceof CompactDisc)
				{
					System.out.print(entry.getKey());
					CompactDisc cd=(CompactDisc) entry.getValue();
					System.out.println(".CD-"+cd.getTitle()+"-"+cd.getCategory()+"-"+cd.getArtist()+"-"+cd.getDirector()+"-"+cd.getLength()+":"+cd.getCost());
				}
			}
		}
		
	}
	
}
