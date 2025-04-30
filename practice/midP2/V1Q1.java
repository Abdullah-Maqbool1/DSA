import java.util.ArrayList;
import java.util.Stack;

class Member {
    private String name;
    private String id;

    public Member(String name, String id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void displayMember() {
        System.out.println("--------------------------------");
        System.out.println("Member name: " + name);
        System.out.println("Member ID: " + id);
    }
}

class BorrowedEquipmentItem {
    private String itemName;
    private String borrowerID;

    public BorrowedEquipmentItem(String name, String borrowerID) {
        this.itemName = name;
        this.borrowerID = borrowerID;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getBorrowerID() {
        return borrowerID;
    }

    public void setBorrowerID(String borrowerID) {
        this.borrowerID = borrowerID;
    }

    public void display() {
        System.out.println("-----------------------------");
        System.out.println("Item Name: " + itemName);
        System.out.println("Borrower id: " + borrowerID);
    }
}

class BorrowedEquipmentManagement {
    Stack<BorrowedEquipmentItem> borrowedItems = new Stack<>();

    public void borrowItem(String borrowerID, String itemName) {
        BorrowedEquipmentItem item = new BorrowedEquipmentItem(itemName, borrowerID);
        borrowedItems.push(item);
        System.out.println(itemName + " is borrowed by the member with id: " + borrowerID);
    }

    public void returnItem() {
        BorrowedEquipmentItem returnedItem = borrowedItems.pop();
        System.out.println(returnedItem.getItemName() + " has returned by user id " + returnedItem.getBorrowerID());
    }

    public void displayAllBorrowHistory() {
        System.out.println("Borrowed items history: ");
        for (BorrowedEquipmentItem i : borrowedItems) {
            i.display();
        }
    }
}

class MembershipManagement {
    ArrayList<member> members = new ArrayList<>();

    public void addMember(String name, String id) {
        for (member m : members) {
            if (m.getId().equals(id)) {
                System.out.println("Member with this id is already present!Please choose any other id!");
                return;
            }
        }
        member member = new member(name, id);
        members.add(member);
        System.out.println("Member added successfully!");
    }

    public void removeMember(String id) {
        for (member m : members) {
            if (m.getId().equals(id)) {
                members.remove(m);
                return;
            }
        }
        System.out.println("Member not found!");
    }

    public void displayAllMembers() {
        if (members.isEmpty()) {
            System.out.println("Sorry,no member found!");
            return;
        }
        System.out.println("Members information: ");
        for (member m : members) {
            m.displayMember();
        }
    }
}

class Node {
    String name;
    String type;
    Node next;

    public Node(String name, String type) {
        this.name = name;
        this.type = type;
        this.next = null;
    }

    public void display() {
        System.out.println("------------------------");
        System.out.println("Name: " + name);
        System.out.println("Type: " + type);
    }
}

class EquipmentCatalogManagement {
    Node head;

    public void addItem(String name, String type) {
        Node newNode = new Node(name, type);
        if (head == null) {
            head = newNode;
            System.out.println("Item added!");
            return;
        }
        Node curr = head;
        while (curr.next != null) {
            curr = curr.next;
        }
        curr.next = newNode;
        System.out.println("Item added!");
    }

    public void removeItem(String name) {
        if (head == null) {
            System.out.println("Catalog is empty.");
            return;
        }
        if (head.name.equals(name)) {
            head = head.next;
            System.out.println("Item Removed!");
            return;
        }
        Node curr = head;
        while (curr.next != null && !curr.next.name.equals(name)) {
            curr = curr.next;
        }
        if (curr.next == null) {
            System.out.println("Item not found!");
        } else {
            curr.next = curr.next.next;
            System.out.println("Item Removed!");
        }
    }


    public void displayAvailableEquipment() {
        Node curr = head;
        while (curr.next != null) {
            curr.display();
            curr = curr.next;
        }
    }
}


public class V1Q1 {
    public static void main(String[] args) {
        EquipmentCatalogManagement ecm = new EquipmentCatalogManagement();
        ecm.addItem("Yoga mat","mat");
        ecm.addItem("3kg dumbbell","weight");
        ecm.addItem("11kg dumbbell","weight");

        membershipManagement mm = new membershipManagement();
        mm.addMember("M1","001");
        mm.addMember("M2","002");

        BorrowedEquipmentManagement bem = new BorrowedEquipmentManagement();
        bem.borrowItem("001","yoga mat");
        bem.borrowItem("002","3kg dumbbell");
        bem.returnItem();

        ecm.displayAvailableEquipment();
        mm.displayAllMembers();
        bem.displayAllBorrowHistory();

    }
}
