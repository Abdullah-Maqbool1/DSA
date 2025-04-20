import java.util.ArrayList;
import java.util.Scanner;

class Song {
    String title;
    double duration;

    public Song(String title, double duration) {
        this.title = title;
        this.duration = duration;
    }

    public void display() {
        System.out.println("Song title: " + title);
        System.out.println("Song duration(in minutes): " + duration);
        System.out.println("--------------------------------------------");
    }
}

class MusicStreamingApp {
    ArrayList<Song> playlist;

    public MusicStreamingApp() {
        this.playlist = new ArrayList<>();
    }

    public void addSong(String title, double duration) {
        playlist.add(new Song(title, duration));
        System.out.println("Song added to playlist successfully!");
    }

    public void deleteSong(String title) {
        for (Song s : playlist) {
            if (s.title.equals(title)) {
                playlist.remove(s);
                System.out.println("Song removed Successfully!");
                return;
            }
        }
        System.out.println("Song not found!");
    }

    public void searchSong(String title) {
        for (Song s : playlist) {
            if (s.title.equals(title)) {
                System.out.println("Song is present in the playlist!");
                System.out.println("Song details: ");
                s.display();
                return;
            }
        }
        System.out.println("Song not found!");
    }

    public void sort() {
        System.out.println("Songs sorted according to their title alphabetically:");
        int n = playlist.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (playlist.get(j).title.compareTo(playlist.get(j + 1).title) > 0) {
                    // Swap students[j] and students[j + 1]
                    Song temp = playlist.get(j);
                    playlist.set(j, playlist.get(j + 1));
                    playlist.set(j + 1, temp);
                }
            }
        }
        for (Song s : playlist) {
            s.display();
        }
    }

    public void findLongest() {
        Song longestSong = playlist.getFirst();
        for (Song s : playlist) {
            if (s.duration > longestSong.duration) {
            longestSong = s;
            }
        }
        System.out.println("Details of Longest Song(in duration)");
        longestSong.display();
    }

}

public class ScenarioBasedTask02 {
    public static void main(String[] args) {
        MusicStreamingApp app = new MusicStreamingApp();

        app.addSong("A",6.5);
        app.addSong("F",4.5);
        app.addSong("D",9.5);
        app.addSong("L",2.5);

        Scanner sc = new Scanner(System.in);
        int choice;
        while (true) {
            System.out.println("1) Add a new Song in the playlist");
            System.out.println("2) Delete a Song");
            System.out.println("3) Search for a Song");
            System.out.println("4) Sort playlist alphabetically");
            System.out.println("5) Find the longest song (in duration)");
            System.out.println("6) exit");
            System.out.println("Select: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Enter Song title: ");
                    String title = sc.nextLine().trim();
                    System.out.println("Enter song duration in minutes: ");
                    double duration = sc.nextDouble();
                    app.addSong(title, duration);
                    break;
                case 2:
                    System.out.println("Enter Song title to delete: ");
                    String titleToDelete = sc.nextLine().trim();
                    app.deleteSong(titleToDelete);
                    break;
                case 3:
                    System.out.println("Enter Song title to search: ");
                    String titleToSearch = sc.nextLine().trim();
                    app.searchSong(titleToSearch);
                    break;
                case 4:
                    app.sort();
                    break;
                case 5:
                    app.findLongest();
                    break;
                case 6:
                    System.out.println("Exiting");
                    return;
            }
        }
    }
}
