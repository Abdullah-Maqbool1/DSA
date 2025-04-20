class Song {
    String name;
    Song next;

    public Song(String name) {
        this.name = name;
        this.next = null;
    }
}

class Playlist {
    private Song head = null;
    private Song current = null;

    public void addSong(String name) {  // O(n)
        Song newSong = new Song(name);
        if (head == null) {
            head = newSong;
            head.next = head;
            current = head;
        } else {
            Song temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            temp.next = newSong;
            newSong.next = head;
        }
    }

    // Navigate to next song
    public void nextSong() {  //O(1)
        if (current != null)
            current = current.next;
    }

    // Navigate to previous song
    public void previousSong() { //O(n)
        if (current != null) {
            Song temp = head;
            while (temp.next != current) {
                temp = temp.next;
            }
            current = temp;
        }
    }

    public void removeSong(String name) { //O(n)
        if (head == null) return;

        Song temp = head;
        Song prev = null;

        do {
            if (temp.name.equals(name)) {
                if (prev != null) {
                    prev.next = temp.next;
                    if (temp == current) current = temp.next;
                } else {
                    if (head.next == head) {
                        head = null;
                        current = null;
                        return;
                    }
                    Song last = head;
                    while (last.next != head) {
                        last = last.next;
                    }
                    head = head.next;
                    last.next = head;
                    if (temp == current) current = head;
                }
                return;
            }
            prev = temp;
            temp = temp.next;
        } while (temp != head);
    }

    public void displayPlaylist() { //O(n)
        if (head == null) {
            System.out.println("Sorry.,Playlist is empty.");
            return;
        }

        Song temp = head;
        do {
            System.out.println((temp == current ? " -> " : "   ") + temp.name);
            temp = temp.next;
        } while (temp != head);
    }
}

public class PlaylistCircularNavigation {
    public static void main(String[] args) {
        System.out.println("\t\t\n ~~~Welcome to your music Playlist~~~");
        Playlist playlist = new Playlist();
        playlist.addSong("Song A");
        playlist.addSong("Song B");
        playlist.addSong("Song C");
        playlist.addSong("Song D");

        System.out.println("Initial Playlist:");
        playlist.displayPlaylist();

        System.out.println("\nNavigating to next song:");
        playlist.nextSong();
        playlist.displayPlaylist();

        System.out.println("\nNavigating to previous song:");
        playlist.previousSong();
        playlist.displayPlaylist();

        System.out.println("\nRemoving Song B:");
        playlist.removeSong("Song B");
        playlist.displayPlaylist();

        System.out.println("\nRemoving Song A:");
        playlist.removeSong("Song A");
        playlist.displayPlaylist();
    }
}
