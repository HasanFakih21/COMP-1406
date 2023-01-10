import java.util.*;

public class MusicExchangeCenter {
    private ArrayList<User> users;
    private HashMap<String, Float> royalties;
    private ArrayList<Song> downloadedSongs;

    public ArrayList<Song> getDownloadedSongs() {
        return downloadedSongs;
    }

    public MusicExchangeCenter() {
        users = new ArrayList<User>();
        royalties = new HashMap<String, Float>();
        downloadedSongs = new ArrayList<Song>();
    }

    public void updateRoyaltiesList() {
        for(Song i:downloadedSongs) {
            if(royalties.isEmpty()) {
                royalties.put(i.getArtist(),0f);
            }
            else if(!royalties.containsKey(i.getArtist())) {
                royalties.put(i.getArtist(),0f);
            }
        }
    }

    public void updateRoyalties(Song x) {
        royalties.get(x.getArtist());
        royalties.replace(x.getArtist(),royalties.get(x.getArtist())+0.25f);
    }

    public ArrayList<String> downloadedArtists() {
        ArrayList<String> artists = new ArrayList();
        for(Song i:downloadedSongs) {
            if(!(artists.contains(i.getArtist()))) {
                artists.add(i.getArtist());
            }
        }
        return artists;
    }

    public void displayRoyalties() {
        String header = String.format("%-7s%-10s\n-----------------\n","Amount","Artist");
        System.out.print(header);
        ArrayList<String> artists = downloadedArtists();
        for(String i:artists) {
            String s = String.format("$%.2f  %-10s",royalties.get(i),i);
            System.out.println(s);
        }
    }

    public ArrayList<Song> uniqueSongs() {
        ArrayList<Song> uniqueSongs = new ArrayList<>();
        ArrayList<String> check = new ArrayList<>();

        for(Song i:downloadedSongs) {
            if(!check.contains(i.getTitle())) {
                 check.add(i.getTitle());
                 uniqueSongs.add(i);
            }
        }
        return uniqueSongs;
    }

    public TreeSet<Song> uniqueDownloads() {
        TreeSet<Song> uniqueDownloads = new TreeSet<>();
        ArrayList<Song> uniqueSongs = uniqueSongs();
        uniqueDownloads.addAll(uniqueSongs);
        return uniqueDownloads;
    }

    public ArrayList<Pair<Integer,Song>> songsByPopularity() {
        ArrayList<Pair<Integer,Song>> popularSongs = new ArrayList<>();
        ArrayList<Song> uniqueSongs = new ArrayList<>();
        uniqueSongs.addAll(uniqueDownloads());
        for(Song i:uniqueSongs) {
            Pair<Integer, Song> pair= new Pair<Integer, Song>(i.getDownloads(),i);
            popularSongs.add(pair);
        }
        Collections.sort(popularSongs, new Comparator<Pair<Integer, Song>>() {
            public int compare(Pair<Integer, Song> p1, Pair<Integer, Song> p2) {
                if(p1.getKey()>p2.getKey()) {
                    return -1;
                }
                else {
                    return 1;
                }
            }
        });
        return popularSongs;
    }

    public ArrayList<User> onlineUsers() {
        ArrayList<User> onlineUsers = new ArrayList<User>();
        for(User i:users) {
            if(i.isOnline()) {
                onlineUsers.add(i);
            }
        }
        return onlineUsers;
    }

    public ArrayList<Song> allAvailableSongs() {
        ArrayList<Song> allAvailableSongs = new ArrayList<Song>();
        ArrayList<User> onlineUsers = onlineUsers();
        for(User i:onlineUsers) {
            for(Song k:i.getSongList()) {
                allAvailableSongs.add(k);
            }
        }
        return allAvailableSongs;
    }

    public String toString() {
        String s = String.format("Music Exchange Center (%d users on line, %d songs available)"
                , onlineUsers().size() , allAvailableSongs().size());
        return s;
    }

    public User userWithName(String S) {
        User userWithName = null;
        for(User x:users) {
            if(x.getUserName() == S) {
                userWithName = x;
                break;
            }
        }
        return userWithName;
    }

    public void registerUser(User x) {
        if(userWithName(x.getUserName()) == null) {
            users.add(x);
        }
    }

    public ArrayList<Song> availableSongsByArtist(String artist) {
        ArrayList<Song> availableSongsByArtist = new ArrayList<Song>();
        for(Song x:allAvailableSongs()) {
            if(x.getArtist() == artist) {
                availableSongsByArtist.add(x);
            }
        }
        return availableSongsByArtist;
    }

    public Song getSong(String title, String ownerName) {
        Song foundSong = null;
        for(User i:onlineUsers()) {
            if(i.getUserName() == ownerName) {
               foundSong = i.songWithTitle(title);
               if(foundSong!=null) {
                   foundSong.setDownloads(foundSong.getDownloads()+1);
                   downloadedSongs.add(foundSong);
                   updateRoyaltiesList();
                   updateRoyalties(foundSong);
                   break;
               }
            }
        }
        return foundSong;
    }

}
