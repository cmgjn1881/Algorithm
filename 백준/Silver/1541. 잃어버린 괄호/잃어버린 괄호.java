
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String s = st.nextToken();

        String[] split = s.split("-");

        int sum = 0;

        String[] firstPart = split[0].split("\\+");
        for (String a : firstPart) {
            sum += Integer.parseInt(a);
        }

        for (int i = 1; i < split.length; i++) {
            int midSum = 0;
            String[] str = split[i].split("\\+");
            for (String a : str) {
                midSum += Integer.parseInt(a);
            }
            sum -= midSum;
        }

        System.out.println(sum);
    }
}
