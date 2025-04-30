import java.util.ArrayList;
import java.util.Stack;

// ---------- Member Class ----------
class member {
    private String name;
    private String id;

    public member(String name, String id) {
        this.name = name;
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void display() {
        System.out.println("Member Name: " + name + ", ID: " + id);
    }
}

// ---------- Borrowed Book Item ----------
class BorrowedBook {
    private String title;
    private String memberId;

    public BorrowedBook(String title, String memberId) {
        this.title = title;
        this.memberId = memberId;
    }

    public void display() {
        System.out.println("Book Title: " + title + ", Borrowed by Member ID: " + memberId);
    }
}

// ---------- Borrowed Books Management (using Stack) ----------
class BorrowedBooksManagement {
    Stack<BorrowedBook> stack = new Stack<>();

    public void borrowBook(String title, String memberId) {
        stack.push(new BorrowedBook(title, memberId));
        System.out.println(title + " borrowed by Member ID: " + memberId);
    }

    public void returnBook() {
        if (!stack.isEmpty()) {
            BorrowedBook returned = stack.pop();
            System.out.println(returned + " returned.");
        } else {
            System.out.println("No books to return.");
        }
    }

    public void displayBorrowedBooks() {
        if (stack.isEmpty()) {
            System.out.println("No borrowed books.");
            return;
        }
        System.out.println("Currently Borrowed Books:");
        for (BorrowedBook book : stack) {
            book.display();
        }
    }
}

// ---------- Membership Management (using ArrayList) ----------
class membershipManagement {
    ArrayList<member> members = new ArrayList<>();

    public void registerMember(String name, String id) {
        for (member m : members) {
            if (m.getId().equals(id)) {
                System.out.println("Member ID already exists.");
                return;
            }
        }
        members.add(new member(name, id));
        System.out.println("Member registered: " + name);
    }

    public void unregisterMember(String id) {
        for (member m : members) {
            if (m.getId().equals(id)) {
                members.remove(m);
                System.out.println("Member unregistered: ID " + id);
                return;
            }
        }
        System.out.println("Member ID not found.");
    }

    public void displayMembers() {
        if (members.isEmpty()) {
            System.out.println("No members registered.");
            return;
        }
        System.out.println("Registered Members:");
        for (member m : members) {
            m.display();
        }
    }
}

// ---------- Book Node (for Catalog Linked List) ----------
class BookNode {
    String title;
    String author;
    BookNode next;

    public BookNode(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public void display() {
        System.out.println("Book Title: " + title + ", Author: " + author);
    }
}

// ---------- Book Catalog Management (Custom Singly Linked List) ----------
class BookCatalog {
    BookNode head;

    public void addBook(String title, String author) {
        BookNode newBook = new BookNode(title, author);
        if (head == null) {
            head = newBook;
        } else {
            BookNode curr = head;
            while (curr.next != null) {
                curr = curr.next;
            }
            curr.next = newBook;
        }
        System.out.println("Book added: " + title);
    }

    public void removeBook(String title) {
        if (head == null) return;
        if (head.title.equals(title)) {
            head = head.next;
            System.out.println("Book removed: " + title);
            return;
        }

        BookNode prev = head;
        BookNode curr = head.next;
        while (curr != null) {
            if (curr.title.equals(title)) {
                prev.next = curr.next;
                System.out.println("Book removed: " + title);
                return;
            }
            prev = curr;
            curr = curr.next;
        }
        System.out.println("Book not found: " + title);
    }

    public void displayBooks() {
        if (head == null) {
            System.out.println("No books in the catalog.");
            return;
        }
        System.out.println("Book Catalog:");
        BookNode curr = head;
        while (curr != null) {
            curr.display();
            curr = curr.next;
        }
    }
}

// ---------- Main Class ----------
public class V2Q1 {
    public static void main(String[] args) {

        // Book Catalog Operations
        BookCatalog catalog = new BookCatalog();
        catalog.addBook("The Alchemist", "Paulo Coelho");
        catalog.addBook("1984", "George Orwell");
        catalog.addBook("To Kill a Mockingbird", "Harper Lee");

        // Membership Operations
        membershipManagement membership = new membershipManagement();
        membership.registerMember("Alice", "M001");
        membership.registerMember("Bob", "M002");
        membership.registerMember("Charlie", "M003");
        membership.registerMember("Diana", "M004");

        membership.unregisterMember("M003");
        membership.unregisterMember("M004");

        // Borrowing Operations
        BorrowedBooksManagement borrowManager = new BorrowedBooksManagement();
        borrowManager.borrowBook("The Alchemist", "M001");
        borrowManager.borrowBook("1984", "M002");
        borrowManager.borrowBook("To Kill a Mockingbird", "M001");

        borrowManager.returnBook();

        // Final Displays
        System.out.println("\n--- Members ---");
        membership.displayMembers();

        System.out.println("\n--- Borrowed Books ---");
        borrowManager.displayBorrowedBooks();

        System.out.println("\n--- Book Catalog ---");
        catalog.displayBooks();
    }
}
