import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = n / 2;
        boolean isPrime = true;

        int i = 2;
        while (i <= m) {
            if (n % i == 0) {
                isPrime = false;
                System.out.println(i);
                n = n / i;
                i = 1;
            }
            i++;
        }

        if (isPrime && n != 1) {
            System.out.println(n);
        }
    }
}