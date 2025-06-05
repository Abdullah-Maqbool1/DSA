class Patient{
    int patientID;
    String patientName;
    Patient left,right;
    public Patient(int patientID, String patientName) {
        this.patientID = patientID;
        this.patientName = patientName;
        left = right = null;
    }

    @Override
    public String toString(){
        return " -------------------------\n" +
                " --> Patient ID: " + patientID + "\n --> Patient Name: " + patientName;
    }
}

class PatientManagementSystem_BST {
    public Patient root;

    // Method to insert a Patient
    public Patient insertPatient(Patient root, int id, String name) {
        if (root == null) {
            System.out.println("Patient with id (" + id + ") added successfully!");
            return new Patient(id, name);
        } else if (id < root.patientID) {
            root.left = insertPatient(root.left, id, name);
        } else if (id > root.patientID) {
            root.right = insertPatient(root.right, id, name);
        } else {
            System.out.println("Error: Patient with ID " + id + " already exist!");
        }
        return root;
    }

    // method to delete a Patient by its ID
    public Patient deleteByID(Patient root, int id) {
        if (root == null) {
            return null;
        }
        if (id < root.patientID) {
            root.left = deleteByID(root.left, id);
        } else if (id > root.patientID) {
            root.right = deleteByID(root.right, id);
        } else {
            // Node with only one child or no child
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            // Node with two children: get inorder successor (smallest in the right subtree)
            root.patientID = getMinValue(root.right);

            // Delete the inorder successor
            root.right = deleteByID(root.right, root.patientID);
        }
        return root;
    }

    int getMinValue(Patient root) {
        int min = root.patientID;
        while (root.left != null) {
            min = root.left.patientID;
            root = root.left;
        }
        return min;
    }

    // Method to Search for a Patient by its ID and displaying its info:
    public boolean searchByID(Patient root,int id){
        if (root == null){
            System.out.println("Patient not Found!");
            return false;
        }
        if (id == root.patientID){
            System.out.println("Patient found! \n Patient Information: \n"+ root);
            return true;
        }
        else if (id < root.patientID){
            return searchByID(root.left,id);
        }
        else{
            return searchByID(root.right,id);
        }
    }

    // Method to Display all students in ascending order of PatientIDs (using inOrder traversal technique bcz this technique give sorted data):
    public void inorderTraversal(Patient root) {
        if (root != null) {
            inorderTraversal(root.left);
            System.out.println(root);
            inorderTraversal(root.right);
        }
    }
}


public class Scenario02 {
    public static void main(String[] args) {
        PatientManagementSystem_BST system = new PatientManagementSystem_BST();

        // inserting 5 Patient Records:
        system.root = system.insertPatient(system.root,1,"Abdullah");
        system.root = system.insertPatient(system.root,5,"Ali");
        system.root = system.insertPatient(system.root,2,"Ahmad");
        system.root = system.insertPatient(system.root,4,"Umar");
        system.root = system.insertPatient(system.root,3,"Naeem");


        System.out.println("\n List of Patients in Sorted Order (before deletion):");
        system.inorderTraversal(system.root);

        System.out.println("\n Deleting Patient with id = 4:");
        system.root = system.deleteByID(system.root,4);

        System.out.println("\n List of Patients in Sorted Order (After deletion):");
        system.inorderTraversal(system.root);

        System.out.println("\n Searching a Patient with ID = 3:");
        system.searchByID(system.root,3);
    }
}