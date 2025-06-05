class Student{
    int rollNumber;
    double score;
    Student Left,Right;

    public Student(int rollNumber, double score) {
        this.rollNumber = rollNumber;
        this.score = score;
        Left = null;
        Right = null;
    }

    @Override
    public String toString(){
        return " -------------------------\n" +
                " --> Student RollNumber: " + rollNumber + "\n --> Student Score: " + score;
    }
}

class ScoreManagementSystem_BST{
    public Student root;

    // Method to insert student data:
    public Student insertStudentData(Student root,int rollNumber,double score){
        if (root == null){
            System.out.println("Student with rollNumber ("+rollNumber+") added Successfully!");
            return new Student(rollNumber,score);
        } else if (rollNumber < root.rollNumber) {
            root.Left = insertStudentData(root.Left,rollNumber,score);
        }else if (rollNumber > root.rollNumber){
            root.Right = insertStudentData(root.Right,rollNumber,score);
        }else {
            System.out.println("Error: Student with roll number " + rollNumber + " already exists!");
        }
        return root;
    }

    // Method to Search for a student by roll number and displaying its info:
    public boolean search(Student root,int rollNumber){
        if (root == null){
            System.out.println("Student not Found!");
            return false;
        }
        if (rollNumber == root.rollNumber){
            System.out.println("Student found! \n Student Information: \n"+ root);
            return true;
        }
        else if (rollNumber < root.rollNumber){
            return search(root.Left,rollNumber);
        }
        else{
            return search(root.Right,rollNumber);
        }
    }

    // Method to Display all students in ascending order of roll number (using inOrder traversal technique bcz this technique give sorted data):
    public void inorderTraversal(Student root) {
        if (root != null) {
            inorderTraversal(root.Left);
            System.out.println(root);
            inorderTraversal(root.Right);
        }
    }

    // Method to find the student with the lowest score
    public Student findStudentWithLowestScore(Student root) {
        if (root == null) return null;

        Student minStudent = root;
        Student leftMin = findStudentWithLowestScore(root.Left);
        Student rightMin = findStudentWithLowestScore(root.Right);

        if (leftMin != null && leftMin.score < minStudent.score) {
            minStudent = leftMin;
        }
        if (rightMin != null && rightMin.score < minStudent.score) {
            minStudent = rightMin;
        }
        return minStudent;
    }

    // Method to find the student with the highest score
    public Student findStudentWithHighestScore(Student root) {
        if (root == null) {
            return null;
        }
        Student maxStudent = root;
        Student leftMax = findStudentWithHighestScore(root.Left);
        Student rightMax = findStudentWithHighestScore(root.Right);

        if (leftMax != null && leftMax.score > maxStudent.score) {
            maxStudent = leftMax;
        }
        if (rightMax != null && rightMax.score > maxStudent.score) {
            maxStudent = rightMax;
        }
        return maxStudent;
    }
}

public class Scenario01 {
    public static void main(String[] args) {
        ScoreManagementSystem_BST system = new ScoreManagementSystem_BST();

        // adding 5 records in BST(where unique key is the rollNumber):
        system.root = system.insertStudentData(system.root,1,10);
        system.root = system.insertStudentData(system.root,2,7);
        system.root = system.insertStudentData(system.root,5,15);
        system.root = system.insertStudentData(system.root,4,25);
        system.root = system.insertStudentData(system.root,3,21);

        System.out.println("\nEnsuring non-duplicate records");
        // ensuring non-duplicate records
        system.root = system.insertStudentData(system.root,5,14); // it will give error (as rollNumber 5 already added before!)

        System.out.println("\n Searching a Student with rollNumber 3: ");
        // searching a Student and displaying their data:
        system.search(system.root,3);

        // displaying all students in ascending order of roll numbers:
        System.out.println("\n\n Students in ascending order of roll numbers:");
        system.inorderTraversal(system.root);

        System.out.println("\n ~~> Student with Lowest Score: ");
        System.out.println(system.findStudentWithLowestScore(system.root));

        System.out.println("\n ~~> Student with Highest Score: ");
        System.out.println(system.findStudentWithHighestScore(system.root));
    }
}
