package hust.soict.globalict.aims.utils;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Scanner;

public class MyDate
{
	private int day, month, year;
	private String date;
	private final String[] DAY_SUFFIXES =
	     {	"", "One",  "Two",  "Three",  "Four",  "Five",  "Six",  "Seven",  "Eight",  "Nine",
	       "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen",
	       "Twenty", "Twenty one", "Twenty two", "Twenty three", "Twenty four", "Twenty five", "Twenty six", "Twenty seven", "Twenty eight", "Twenty nine",
	       "Thirty", "Thirty one" 
	     };
	private final String[] DAY_ORDERED_SUFFIXES =
		{
			"","First","Second","Third","Fourth","Fifth","Sixth","Seventh","Eighth","Ninth","Tenth",
			"Eleventh","Twelfth","Thirteenth","Fourteenth","Fifteenth","Sixteenth","Seventeenth","Eighteenth","Nineteenth",
			"Twentieth","Twenty first","Twenty second","Twenty third","Twenty fourth","Twenty fifth", "Twenty sixth", "Twenty seventh", "Twenty eighth", "Twenty ninth",
			"Thirtieth", "Thirty first" 
		};
	private final String[] MONTH_SUFFIXES =
	     {  "",  "January",  "Febuary",  "March",  "April",  "May",  "June",  "July",  "August",  "September",
	       "October", "November", "December"};
	public MyDate(int day, int month, int year) {
		super();
		this.day = day;
		this.month = month;
		this.year = year;
	}

	public MyDate() {
		super();
		LocalDate localDate=LocalDate.now();
		this.day=localDate.getDayOfMonth();
		this.month=localDate.getMonthValue();
		this.year=localDate.getYear();
	}
	public MyDate(String date)
	{
		this.date=date;
	}	
	public MyDate(String day,String month, String year)
	{
		for(int i=1;i<=31;i++)
		{
			if(day.equalsIgnoreCase(DAY_SUFFIXES[i]))
			{	this.day=i;
				break;
			}
		}
		for(int i=1;i<=12;i++)
		{
			if(month.equalsIgnoreCase(MONTH_SUFFIXES[i]))
			{
				this.month = i;
				break;
			}
		}
		String yearTemp[]=year.split("\\s");
		yearTemp[1]=year.substring(yearTemp[0].length()+1);
		String yearConcat="";
		for(int i=1;i<=31;i++)
		{
			if(yearTemp[0].equalsIgnoreCase(DAY_SUFFIXES[i]))
			{
				yearConcat=yearConcat.concat(yearConcat.valueOf(i));
			};
			
		}
		for(int i=1;i<=31;i++)
		{
			if(yearTemp[1].equalsIgnoreCase(DAY_ORDERED_SUFFIXES[i]))
			{
				yearConcat=yearConcat.concat(yearConcat.valueOf(i));
			
			}	
		}
		this.year=Integer.parseInt(yearConcat);
		System.out.println(yearTemp[1]);
		
	}
	public void accept()
	{
		Scanner scan=new Scanner(System.in);
		date=scan.nextLine();
		LocalDate dateTemp;
		dateTemp=LocalDate.parse(date);
		this.day=dateTemp.getDayOfMonth();
		this.month=dateTemp.getMonthValue();
		this.year=dateTemp.getYear();
	}

	public void print()
	{
		if((month>=10)&&(day>=10)) System.out.println(year+"-"+month+"-"+day);
		else if((month>=10)&&(day<10))  System.out.println(year+"-"+month+"-0"+day);
		else if((month<10)&&(day>=10)) System.out.println(year+"-0"+month+"-"+day);
		else if((month<10)&&(day<10)) System.out.println(year+"-0"+month+"-0"+day);
	}
}
