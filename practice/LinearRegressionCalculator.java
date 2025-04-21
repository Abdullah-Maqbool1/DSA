import java.util.Scanner;
public class LinearRegressionCalculator{
    // function to calculate slope(m)
    public static double calculate_m(int[] X, int[] Y) {
        int summationXY = 0;
        int summationX = 0;
        int summationY = 0;
        int summation_XSquare = 0;
        int square_summationX;
        int n = X.length;

        for (int i = 0; i < X.length; i++) {
            summationXY += X[i] * Y[i];
            summationX += X[i];
            summationY += Y[i];
            summation_XSquare += X[i] * X[i];

        }


        square_summationX = (summationX * summationX);

        return (double) ((n * summationXY) - (summationX * summationY)) / ((n * summation_XSquare) - (square_summationX));
    }

    // function to calculate c
    public static double calculate_c(int[] X, int[] Y) {
        int summationX = 0;
        int summationY = 0;

        for (int i = 0; i < X.length; i++) {
            summationX += X[i];
            summationY += Y[i];
        }

        double m = calculate_m(X, Y);
        int n = X.length;

        return (double) ((summationY) - (m * summationX)) / (n);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] studyHours = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}; // study hours
        int[] examScores = {20, 30, 40, 60, 65, 70, 75, 80, 85, 95}; // exam scores percentages

        double m = calculate_m(studyHours, examScores);
        double c = calculate_c(studyHours, examScores);

        System.out.println("\t WELCOME TO REGRESSION CALCULATOR ");
        String choice;
        do {
            System.out.print("Enter a value(no. of study hours(x)) to make prediction(exam scores percentage): ");
            int x = sc.nextInt();
            sc.nextLine();
            if (x < 0 || x > 24) { // to validate if the study hours are valid or not.
                System.out.println("Invalid input!");
                return;
            }

            // As y = mx + c
            short y = (short) ((m * x) + c);

            if (y > 100) { // condition for in case the percentage exceeds 100.
                y = 99;
            }

            System.out.println("Predicted Exam Score Percentage: " + y + "%");

            System.out.println("Do you want to make more predication(y/n): ");
            choice = sc.nextLine();
        }
        while (choice.equals("y"));
    }
}