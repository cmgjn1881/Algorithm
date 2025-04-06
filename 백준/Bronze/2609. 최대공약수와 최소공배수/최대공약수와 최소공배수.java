import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();
        int max = Math.max(a, b);
        int min = Math.min(a, b);
        int gcd = 1;
        int lcm = 1;

        int i = 2;
        while (i <= min) {
            if (a % i == 0 && b % i == 0) {
                gcd *= i;
                a = a / i;
                b = b / i;
                i = 1;
            }
            i++;
        }
        if (max % min == 0){
            lcm = max;
        }
        else {
            lcm = gcd * a * b;
        }
        System.out.println(gcd);
        System.out.println(lcm);
    }
}