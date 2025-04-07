import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // N ~ M 소수 출력
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        for (int i = n; i <= m; i++) {
            if (i < 2) {
                continue;
            }

            boolean isPrime = true;
            for (int j = 2; j * j <= i; j++) {
                if (i % j == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                System.out.println(i);
            }
        }
    }
}