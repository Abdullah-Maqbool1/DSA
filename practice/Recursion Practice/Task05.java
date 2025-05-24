public class Task05 {
    public static void decimalToBinary(int n) {
        if (n > 1) {
            decimalToBinary(n / 2);
        }
        System.out.print(n % 2);
    }

    public static void main(String[] args) {
        int decimal = 10;
        System.out.print("Binary representation of " + decimal + ": ");
        decimalToBinary(decimal); // output: 1010
    }
}
/*
dtb(1)
dtb(2)
dtb(5)
dtb(10)
main()

1 0 1 0

 */