package hust.soict.globalict.aims;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import hust.soict.globalict.aims.media.Book;
import hust.soict.globalict.aims.media.CompactDisc;
import hust.soict.globalict.aims.media.DigitalVideoDisc;
import hust.soict.globalict.aims.media.Media;
import hust.soict.globalict.aims.media.Track;

public class TestMediaCompareTo {
	private List<Media> itemsOrdered = new ArrayList<Media>();
	public static void main(String[] args)
	{
		TestMediaCompareTo test=new TestMediaCompareTo();
		DigitalVideoDisc dvd1=new DigitalVideoDisc("The Lion King","Animation","Roger Allers",87,19.95f);
		test.itemsOrdered.add(dvd1);
		/*Không có test. sẽ lỗi (tức là chỉ có itemsOrdered.add(dvd1) sẽ lỗi vì itemsOrder chưa khởi tạo.)
		Nghĩ xem các kiểu sau có chạy ko:
		-tạo method void call(){itemsOrder.add() //không bị lỗi reference đến nonstatic
		-cho khai báo itemsOrder vào trong main()}
		*/
		/*--> Chú ý method static có tác động đến instant variable non-static thì phải chú ý
		 vì method static thuộc về class mà instant variable non-static thuộc về đối tượng
		 */
		DigitalVideoDisc dvd2=new DigitalVideoDisc("Star Wars","Science Fiction","George Lucas",124,24.95f);
		test.itemsOrdered.add(dvd2);
		DigitalVideoDisc dvd3=new DigitalVideoDisc("Aladdin","Animation","John Musker",90,18.99f);
		test.itemsOrdered.add(dvd3);
		
		CompactDisc cd1=new CompactDisc("You of yesterday", "Love music", "Son Tung MTP", "MTP entertainment", 0, 0);
		Track track1=new Track("You and me are friends", 2);
		Track track2=new Track("You and me are love",3);
		cd1.addTrack(track1);
		cd1.addTrack(track2);
		test.itemsOrdered.add(cd1);
		
		Book book1=new Book("Harry Potter", "Fantasy",63f);
		book1.addAuthor("J.K.Rowling");
		test.itemsOrdered.add(book1);
		
		Collections.sort(test.itemsOrdered);
		for(Media media:test.itemsOrdered)
		{
			System.out.println(media.getId());
		}
		
	}
	
}
