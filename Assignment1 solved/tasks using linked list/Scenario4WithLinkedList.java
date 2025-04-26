import java.util.LinkedList;
import java.util.Scanner;

class CommentSection {
    LinkedList<String> comments;

    public CommentSection() {
        this.comments = new LinkedList<>();
    }

    public void addComment(String comment) { // time complexity - O(1)
        comments.addLast(comment); // Adds to the end (chronological order)
        System.out.println("Comment added: " + comment);
    }

    public void editComment(int index, String newComment) { // time complexity - O(n)
        if (index >= 0 && index < comments.size()) {
            comments.set(index, newComment);
            System.out.println("Comment at index " + index + " updated to: " + newComment);
        } else {
            System.out.println("Error: Invalid comment index.");
        }
    }

    public void deleteComment(int index) { // time complexity - O(n)
        if (index >= 0 && index < comments.size()) {
            String removed = comments.remove(index);
            System.out.println("Comment deleted: " + removed);
        } else {
            System.out.println("Error: Invalid comment index.");
        }
    }

    public void searchComment(String keyword) { // time complexity - O(n)
        System.out.println("Comments containing '" + keyword + "':");
        boolean found = false;
        for (int i = 0; i < comments.size(); i++) {
            if (comments.get(i).toLowerCase().contains(keyword.toLowerCase())) {
                System.out.println("Index " + i + ": " + comments.get(i));
                found = true;
            }
        }
        if (!found) {
            System.out.println("No comments found with keyword '" + keyword + "'.");
        }
    }

    public void displayReverseOrder() { // time complexity - O(n)
        System.out.println("Comments (most recent first):");
        for (int i = comments.size() - 1; i >= 0; i--) {
            System.out.println("Index " + i + ": " + comments.get(i));
        }
    }

    public void displayChronologicalOrder() { // time complexity - O(n)
        System.out.println("Comments (chronological order):");
        for (int i = 0; i < comments.size(); i++) {
            System.out.println("Index " + i + ": " + comments.get(i));
        }
    }
}

public class Scenario4WithLinkedList {
    public static void main(String[] args) {
        CommentSection cs = new CommentSection();
        Scanner sc = new Scanner(System.in);
        int choice;

        System.out.println("\t~~ Welcome to the Comment Section ~~");
        while (true) {
            System.out.println("\n1) Add a comment");
            System.out.println("2) Edit a comment");
            System.out.println("3) Delete a comment");
            System.out.println("4) Search for a comment by keyword");
            System.out.println("5) Display comments (most recent first)");
            System.out.println("6) Exit");
            System.out.print("Select an option (1-6): ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter your comment: ");
                    String comment = sc.nextLine();
                    cs.addComment(comment);
                    break;
                case 2:
                    System.out.print("Enter the index of the comment to edit: ");
                    int editIndex = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter the new comment: ");
                    String newComment = sc.nextLine();
                    cs.editComment(editIndex, newComment);
                    break;
                case 3:
                    System.out.print("Enter the index of the comment to delete: ");
                    int deleteIndex = sc.nextInt();
                    cs.deleteComment(deleteIndex);
                    break;
                case 4:
                    System.out.print("Enter a keyword to search: ");
                    String keyword = sc.nextLine();
                    cs.searchComment(keyword);
                    break;
                case 5:
                    cs.displayReverseOrder();
                    break;
                case 6:
                    System.out.println("\t~~ Thanks for using the Comment Section ~~");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}