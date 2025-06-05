class Book {
    int isbn;
    String title, author;
    Book Left, Right;

    public Book(int isbn, String title, String author) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.Left = null;
        this.Right = null;
    }

    @Override
    public String toString() {
        return " -------------------------\n" +
                " --> ISBN: " + isbn +
                "\n --> Title: " + title +
                "\n --> Author: " + author;
    }
}

class LibraryBST {
    public Book root;

    // Method to insert a new book
    public Book addBook(Book root, int isbn, String title, String author) {
        if (root == null) {
            System.out.println("Book with ISBN (" + isbn + ") added successfully!");
            return new Book(isbn, title, author);
        } else if (isbn < root.isbn) {
            root.Left = addBook(root.Left, isbn, title, author);
        } else if (isbn > root.isbn) {
            root.Right = addBook(root.Right, isbn, title, author);
        } else {
            System.out.println("Error: Book with ISBN " + isbn + " already exists!");
        }
        return root;
    }

    // Method to search a book by ISBN
    public boolean searchBook(Book root, int isbn) {
        if (root == null) {
            System.out.println("Book not found!");
            return false;
        }
        if (isbn == root.isbn) {
            System.out.println("Book found! \nBook Information: \n" + root);
            return true;
        } else if (isbn < root.isbn) {
            return searchBook(root.Left, isbn);
        } else {
            return searchBook(root.Right, isbn);
        }
    }

    // Method to print all books sorted by ISBN (in-order traversal)
    public void printBooks(Book root) {
        if (root != null) {
            printBooks(root.Left);
            System.out.println(root);
            printBooks(root.Right);
        }
    }

    // Method to delete a book by ISBN
    public Book deleteBook(Book root, int isbn) {
        if (root == null) {
            System.out.println("Error: Book with ISBN " + isbn + " not found!");
            return null;
        }

        if (isbn < root.isbn) {
            root.Left = deleteBook(root.Left, isbn);
        } else if (isbn > root.isbn) {
            root.Right = deleteBook(root.Right, isbn);
        } else {
            // Node with only one child or no child
            if (root.Left == null) {
                System.out.println("Book with ISBN " + isbn + " deleted successfully!");
                return root.Right;
            } else if (root.Right == null) {
                System.out.println("Book with ISBN " + isbn + " deleted successfully!");
                return root.Left;
            }

            // Node with two children: Get the inorder successor (smallest in the right subtree)
            Book minNode = findMin(root.Right);
            root.isbn = minNode.isbn;
            root.title = minNode.title;
            root.author = minNode.author;

            // Delete the inorder successor
            root.Right = deleteBook(root.Right, minNode.isbn);
        }
        return root;
    }

    private Book findMin(Book root) {
        while (root.Left != null) {
            root = root.Left;
        }
        return root;
    }
}

public class Scenario03 {
    public static void main(String[] args) {
        LibraryBST library = new LibraryBST();

        // Adding books
        library.root = library.addBook(library.root, 1, "Effective Java", "Joshua Bloch");
        library.root = library.addBook(library.root, 3, "Java: The Complete Reference", "Herbert Schildt");
        library.root = library.addBook(library.root, 5, "Clean Code", "Robert C. Martin");
        library.root = library.addBook(library.root, 2, "Head First Java", "Kathy Sierra");
        library.root = library.addBook(library.root, 4, "Java Concurrency in Practice", "Brian Goetz");

        System.out.println("\nEnsuring non-duplicate book entry:");
        library.root = library.addBook(library.root, 5, "Effective Java 2nd Edition", "Joshua Bloch");

        System.out.println("\nSearching for a Book with ISBN = 2:");
        library.searchBook(library.root, 2);

        System.out.println("\n\nAll Books Sorted by ISBN:");
        library.printBooks(library.root);

        System.out.println("\nDeleting Book with ISBN = 3:");
        library.root = library.deleteBook(library.root, 3);

        System.out.println("\nAll Books After Deletion:");
        library.printBooks(library.root);
    }
}