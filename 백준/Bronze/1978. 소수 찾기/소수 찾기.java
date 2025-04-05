import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String strN = sc.nextLine();
        int n = Integer.parseInt(strN);
        int count = 0;

        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int temp = sc.nextInt();
            list.add(temp);
        }

        for (int num : list) {
            if (num < 2) {
                continue;
            }
            boolean isPrime = true;
            for (int j = 2; j <= num / 2; j++) {
                if (num % j == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                count++;
            }
        }
        System.out.println(count);
    }
}