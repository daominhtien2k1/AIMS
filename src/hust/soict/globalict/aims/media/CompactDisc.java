package hust.soict.globalict.aims.media;
import java.util.ArrayList;
import hust.soict.globalict.aims.playable.Playable;
public class CompactDisc extends Disc implements Playable{
	private String artist;
	private ArrayList<Track> tracks=new ArrayList<>();
	public CompactDisc(String title, String category,String artist, String director, int length,float cost) {
		super(title, category, director, length,cost);
		this.artist=artist;
	}
	public void addTrack(Track track)
	{
		if(tracks.contains(track))
		{
			System.out.println("Already have");
		}
		else
		{
			tracks.add(track);
			length+=track.getLength();
		}
		
		
	}
	public void removeTrack(Track track)
	{
		if(tracks.contains(track))
		{
			tracks.remove(track);
			length-=track.getLength();
		}
		else
		{
			System.out.println("Can't remove");
		}
	}
	
	public String getArtist() {
		return artist;
	}
	public void setArtist(String artist) {
		this.artist = artist;
	}
	public ArrayList<Track> getTracks() {
		return tracks;
	}
	public void setTracks(ArrayList<Track> tracks) {
		this.tracks = tracks;
	}
	@Override
	public void play() {
		for(Track track: tracks)
		{
			track.play();
		}
		
	}
	
	
	
}
