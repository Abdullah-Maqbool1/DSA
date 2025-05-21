public class Task03 {
        static void printNumbers(int N) {
            if (N == 0) return;

            printNumbers(N - 1);

            System.out.print(N + " ");
        }

        public static void main(String[] args) {
            int N = 5;
            printNumbers(N); // output: 1 2 3 4 5
        }
    }
