import java.util.Scanner;

class Level {
    String name;
    Level prev, next;

    public Level(String name) {
        this.name = name;
    }
}

class GameLevelSystem {
    Level head = null, tail = null;

    void addLevel(String name) {
        Level newLevel = new Level(name);
        if (head == null) {
            head = tail = newLevel;
        } else {
            tail.next = newLevel;
            newLevel.prev = tail;
            tail = newLevel;
        }
    }

    void displayLevels() {
        Level temp = head;
        System.out.println("Game Levels (Earliest to Latest):");
        while (temp != null) {
            System.out.print(temp.name + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    void displayFromLatest() {
        Level temp = tail;
        System.out.println("Game Levels (Latest to Earliest):");
        while (temp != null) {
            System.out.print(temp.name + " <- ");
            temp = temp.prev;
        }
        System.out.println("null");
    }

    Level searchLevel(String name) {
        Level temp = head;
        while (temp != null) {
            if (temp.name.equalsIgnoreCase(name))
                return temp;
            temp = temp.next;
        }
        return null;
    }

    void removeLevel(String name) {
        Level temp = searchLevel(name);
        if (temp == null) {
            System.out.println("Level not found.");
            return;
        }

        if (temp == head) head = temp.next;
        if (temp == tail) tail = temp.prev;
        if (temp.prev != null) temp.prev.next = temp.next;
        if (temp.next != null) temp.next.prev = temp.prev;

        System.out.println("Level \"" + name + "\" removed.");
    }

    void insertBonusLevel(String after, String bonusName) {
        Level temp = searchLevel(after);
        if (temp == null) {
            System.out.println("Level not found.");
            return;
        }

        Level bonus = new Level(bonusName);
        bonus.next = temp.next;
        bonus.prev = temp;

        if (temp.next != null)
            temp.next.prev = bonus;
        temp.next = bonus;

        if (temp == tail)
            tail = bonus;

        System.out.println("Bonus level \"" + bonusName + "\" added after \"" + after + "\".");
    }
}

public class CaseStudy01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        GameLevelSystem game = new GameLevelSystem();

        while (true) {
            System.out.println("\n1. Add Level\n2. Remove Level\n3. Insert Bonus Level\n4. Display Levels\n5. Display Reverse\n6. Exit");
            System.out.print("Choose option: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter level name: ");
                    String name = sc.nextLine();
                    game.addLevel(name);
                    break;
                case 2:
                    System.out.print("Enter level name to remove: ");
                    game.removeLevel(sc.nextLine());
                    break;
                case 3:
                    System.out.print("After which level? ");
                    String after = sc.nextLine();
                    System.out.print("Enter bonus level name: ");
                    String bonus = sc.nextLine();
                    game.insertBonusLevel(after, bonus);
                    break;
                case 4:
                    game.displayLevels();
                    break;
                case 5:
                    game.displayFromLatest();
                    break;
                case 6:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }
}
