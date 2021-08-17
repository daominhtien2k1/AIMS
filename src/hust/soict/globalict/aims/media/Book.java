package hust.soict.globalict.aims.media;

import java.util.ArrayList;

public class Book extends Media{
	private ArrayList<String> authors=new ArrayList<String>();
	public Book() {	
	}
	public Book(String title) {
		super(title);
	}
	public Book(String title, String category) {
		super(title, category);
	}
	public Book(String title,String category,float cost) 
	{
		super(title,category,cost);
	}
	public Book(String title,String category,float cost,ArrayList<String> authors) 
	{
		super(title,category,cost);
		this.authors=authors;
	}
	public void removeAuthor(String authorName)
	{
		for(int i=0;i<authors.size();i++)
		{
			if(authors.get(i)==authorName)
			{ 
				System.out.println("Da xoa "+authors.get(i));
				authors.remove(i);
				return;
			}
		}
		System.out.println("Khong thay");
		return;
	}
	public void addAuthor(String authorName)
	{
		for(int i=0;i<authors.size();i++)
		{
			if(authors.get(i)==authorName)
			{ 
				System.out.println("Da co "+authors.get(i));
				return;
			}
		}
		authors.add(authorName);
		return;
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
	public ArrayList<String> getAuthors() {
		return authors;
	}
	public void setAuthors(ArrayList<String> authors) {
		this.authors = authors;
	}

}
