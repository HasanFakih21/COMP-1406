import java.util.ArrayList;

public class User {
  private String     userName;
  private boolean    online;
  private ArrayList<Song> songList;
  
  public User()  { this(""); }
  
  public User(String u)  {
    songList = new ArrayList<Song>();
    userName = u;
    online = false;
  }
  
  public String getUserName() { return userName; }
  public boolean isOnline() { return online; }
  public ArrayList<Song> getSongList() {
    return songList;
  }

  public void addSong(Song s) {
    s.setOwner(this);
    songList.add(s);
  }

  public int totalSongTime() {
    int totalTime = 0;
    for(Song i:songList) {
      totalTime = totalTime + i.getDuration();
    }
    return totalTime;
  }

  public String toString()  {
    String s = "" + userName + ": " + songList.size() + " songs (";
    if (!online) s += "not ";
    return s + "online)";
  }

  public void register(MusicExchangeCenter m) {
    m.registerUser(this);
  }

  public void logon() {
    online = true;
  }

  public void logoff() {
    online = false;
  }

  public Song songWithTitle(String title) {
    Song foundSong = null;
    for(Song i:songList) {
      if(i.getTitle() == title) {
        foundSong = i;
        break;
      }
    }
    return foundSong;
  }

  public void downloadSong(MusicExchangeCenter m, String title, String ownerName) {
    Song toAdd = m.getSong(title,ownerName);
    if(toAdd != null) {
      addSong(toAdd);
    }
  }

  public static ArrayList<String> requestCompleteSonglist(MusicExchangeCenter m) {
    ArrayList<String> songListString = new ArrayList<String>();
    songListString.add(String.format("     %-30s%-20s%-8s%-15s","TITLE","ARTIST","TIME","OWNER"));
    for(int x = 0;x<m.allAvailableSongs().size();x++) {
      Song i = m.allAvailableSongs().get(x);
      String s;
      s = String.format("%3s  %-30s%-20s%d:%02d    %-15s", x+1+".",i.getTitle(),i.getArtist(),i.getMinutes(),i.getSeconds(),i.getOwner().getUserName());
      songListString.add(s);
    }
    return songListString;
  }

  public static ArrayList<String> requestSonglistByArtist(MusicExchangeCenter m, String artist) {
    ArrayList<Song> songList = m.availableSongsByArtist(artist);
    ArrayList<String> songListString = new ArrayList<String>();
    songListString.add(String.format("    %-30s%-20s%-8s%-15s","TITLE","ARTIST","TIME","OWNER"));
    for(int x = 0;x<songList.size();x++) {
      Song i = songList.get(x);
      String s;
      s = String.format("%-4s%-30s%-20s%d:%02d    %-15s", x+1+".",i.getTitle(),i.getArtist(),i.getMinutes(),i.getSeconds(),i.getOwner().getUserName());
      songListString.add(s);
    }
    return songListString;
  }
}
